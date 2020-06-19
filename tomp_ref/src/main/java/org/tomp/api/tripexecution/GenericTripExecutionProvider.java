package org.tomp.api.tripexecution;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.temporal.ChronoUnit;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Coordinates;
import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;
import io.swagger.model.ExecutionState;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.KeyValue;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.Token;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "generic", matchIfMissing = true)
public class GenericTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	DummyRepository repository;

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public Execution prepare(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg planning = repository.getSavedOption(id);
		Execution execution = new Execution();
		execution.setAssetAccessData(constructTokenToOpenAsset(body, planning));
		execution.setState(ExecutionState.PREPARING);
		repository.saveLegEvent(id, body);
		return execution;
	}

	private Token constructTokenToOpenAsset(ExecutionEvent body, Leg planning) {
		Token token = new Token();
		token.setStartTime(body.getTime());
		token.setEndTime(ChronoUnit.SECONDS.addTo(planning.getEndTime(), -3600));
		token.setMeta(Arrays.asList(toKV("code", UUID.randomUUID())));
		return token;
	}

	private KeyValue toKV(String string, UUID randomUUID) {
		KeyValue kv = new KeyValue();
		kv.put(string, randomUUID);
		return null;
	}

	@Override
	public Execution assignAsset(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		repository.saveLegEvent(id, body);
		return toExecution(leg);
	}

	@Override
	public Execution reserve(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		repository.saveLegEvent(id, body);
		return toExecution(leg);
	}

	private Execution toExecution(Leg leg) {
		Execution execution = new Execution();
		execution.setAgencyId(configuration.getMaasId());
		execution.setStartTime(leg.getStartTime());
		execution.setEndTime(leg.getEndTime());
		execution.setFrom(toPlace(leg.getFrom()));
		execution.setTo(toPlace(leg.getTo()));
		return execution;
	}

	private Place toPlace(Coordinates coordinate) {
		Place place = new Place();
		place.setCoordinates(coordinate);
		return place;
	}

	@Override
	public Execution setInUse(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Execution execution = toExecution(leg);
		execution.setAgencyId(maasId);
		execution.setFrom(body.getAsset().getPlace());
		leg.setStartTime(body.getTime());
		repository.saveLegEvent(id, body);
		execution.setState(ExecutionState.IN_USE);
		createJournalItem(id, execution, body, maasId);
		return execution;
	}

	@Override
	public Execution pause(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Execution execution = toExecution(leg);
		execution.setState(ExecutionState.PAUSED);
		repository.saveLegEvent(id, body);
		return execution;
	}

	@Override
	public Execution startFinishing(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Execution execution = toExecution(leg);
		execution.setState(ExecutionState.FINISHING);
		repository.saveLegEvent(id, body);
		return execution;
	}

	@Override
	public Execution finish(ExecutionEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Execution execution = toExecution(leg);
		execution.setState(ExecutionState.FINISHED);
		execution.setTo(body.getAsset().getPlace());
		execution.setEndTime(body.getTime());
		execution.setFare(leg.getPricing());
		execution.getFare().setEstimated(false);
		finaliseJournalItem(id, execution, body, maasId);
		repository.saveLegEvent(id, body);
		return execution;
	}

	private void createJournalItem(String id, Execution execution, ExecutionEvent body, String maasId) {
		JournalEntry entry = new JournalEntry();
		entry.setJournalId(id);
		entry.setState(null);
		repository.saveJournalEntry(entry, maasId);
	}

	private BigDecimal calculateFare(Execution execution) {
		double amount = 0;
		Fare fare = execution.getFare();

		for (FarePart part : fare.getParts()) {
			switch (part.getType()) {
			case FIXED:
				amount += part.getAmount().doubleValue();
				break;
			case FLEX:
				amount += calculateFlexPart(part, execution);
				break;
			case MAX:
				if (amount > part.getAmount().doubleValue()) {
					amount = part.getAmount().doubleValue();
					break;
				}
				break;
			default:
				break;
			}
		}

		return BigDecimal.valueOf(amount);
	}

	private double calculateFlexPart(FarePart part, Execution execution) {
		double amount = part.getAmount().doubleValue();
		switch (part.getUnitType()) {
		case HOUR:
			return ChronoUnit.HOURS.between(execution.getStartTime(), execution.getEndTime());
		case KM:
			return amount * (execution.getDistance().doubleValue() / 1000);
		case MILE:
			return amount * (execution.getDistance().doubleValue() / 1609);
		case MINUTE:
			return ChronoUnit.MINUTES.between(execution.getStartTime(), execution.getEndTime());
		case PERCENTAGE:
			break;
		case SECOND:
			return ChronoUnit.SECONDS.between(execution.getStartTime(), execution.getEndTime());
		default:
			break;
		}
		return 0;
	}

	private void finaliseJournalItem(String id, Execution execution, ExecutionEvent legEvent, String maasId) {
		JournalEntry entry = repository.getLastStartJournalEntry(maasId, id);
		entry.setUsedTime(
				BigDecimal.valueOf(ChronoUnit.SECONDS.between(execution.getStartTime(), execution.getEndTime())));
		entry.setDistance(calculateDistance(entry, legEvent));
		BigDecimal amount = calculateFare(execution);
		entry.setAmount(amount);
		entry.setCurrencyCode(configuration.getCurrencyCode());
		long vatRate = configuration.getVatRate();
		entry.setVatRate(BigDecimal.valueOf(vatRate));
		entry.setAmountExVat(BigDecimal.valueOf(amount.doubleValue() * ((100.0 - vatRate) / 100.0)));
		entry.setVatCountryCode(configuration.getCurrencyCode());
		entry.setExpirationDate(ChronoUnit.DAYS.addTo(OffsetDateTime.now(), configuration.getExpirationDays()));
		entry.setState(JournalState.TO_INVOICE);
	}

	private BigDecimal calculateDistance(JournalEntry entry, ExecutionEvent legEvent) {
		List<ExecutionEvent> legEvents = repository.getLegEvents(entry.getJournalId());
		Coordinates coordinates = legEvents.get(0).getAsset().getPlace().getCoordinates();
		Coordinates coordinates2 = legEvent.getAsset().getPlace().getCoordinates();

		BigDecimal lat = coordinates.getLat().subtract(coordinates2.getLat()).abs();
		BigDecimal lon = coordinates.getLng().subtract(coordinates2.getLng()).abs();

		lat = lat.multiply(lat);
		lon = lon.multiply(lon);

		return BigDecimal.valueOf(Math.sqrt(lat.doubleValue() + lon.doubleValue()));
	}

}
