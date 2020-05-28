package org.tomp.api.tripexecution;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.KeyValue;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegState;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;
import io.swagger.model.Token;

@Component
@Profile(value = { "dummy", "bike", "bus", "train", "car", "shared-car" })
public class GenericTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	DummyRepository repository;

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		PlanningResult planning = repository.getSavedOption(id);
		leg.setAssetAccessData(constructTokenToOpenAsset(body, planning));
		leg.setState(LegState.PREPARING);
		repository.saveLegEvent(id, body);
		return leg;
	}

	private Token constructTokenToOpenAsset(LegEvent body, PlanningResult planning) {
		Token token = new Token();
		token.setStartTime(body.getTime());
		if (planning instanceof SimpleLeg) {
			OptionsLeg plannedLeg = ((SimpleLeg) planning).getLeg();
			token.setEndTime(plannedLeg.getEndTime().subtract(BigDecimal.valueOf(60000)));
			token.setMeta(Arrays.asList(toKV("code", UUID.randomUUID())));
		}
		return token;
	}

	private KeyValue toKV(String string, UUID randomUUID) {
		KeyValue kv = new KeyValue();
		kv.put(string, randomUUID);
		return null;
	}

	@Override
	public Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		leg.setAgencyId(maasId);
		leg.setFrom(body.getAsset().getPlace());
		leg.setStartTime(body.getTime());
		repository.saveLegEvent(id, body);
		leg.setState(LegState.IN_USE);
		createJournalItem(id, leg, body, maasId);
		return leg;
	}

	@Override
	public Leg pause(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		leg.setState(LegState.PAUSED);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg startFinishing(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		leg.setState(LegState.FINISHING);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg finish(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		leg.setState(LegState.FINISHED);
		leg.setTo(body.getAsset().getPlace());
		leg.setEndTime(body.getTime());
		finaliseJournalItem(id, leg, body, maasId);
		repository.saveLegEvent(id, body);
		return leg;
	}

	private void createJournalItem(String id, Leg leg, LegEvent body, String maasId) {
		JournalEntry entry = new JournalEntry();
		entry.setJournalId(id);
		entry.setState(null);
		repository.saveJournalEntry(entry, maasId);
	}

	private BigDecimal calculateFare(Leg leg) {
		double amount = 0;
		Fare fare = leg.getFare();

		for (FarePart part : fare.getParts()) {
			switch (part.getType()) {
			case FIXED:
				amount += part.getAmount().doubleValue();
				break;
			case FLEX:
				amount += calculateFlexPart(part, leg);
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

	private double calculateFlexPart(FarePart part, Leg leg) {
		double amount = part.getAmount().doubleValue();
		switch (part.getUnitType()) {
		case HOUR:
			double usedTime = leg.getEndTime().subtract(leg.getStartTime()).doubleValue();
			// 3600 sec/hour
			double hours = usedTime / 3600;
			return amount * hours;
		case KM:
			return amount * (leg.getDistance().doubleValue() / 1000);
		case MILE:
			return amount * (leg.getDistance().doubleValue() / 1609);
		case MINUTE:
			double minutes = leg.getEndTime().subtract(leg.getStartTime()).doubleValue() / 60;
			return amount * minutes;
		case PERCENTAGE:
			break;
		case SECOND:
			double seconds = leg.getEndTime().subtract(leg.getStartTime()).doubleValue();
			return amount * seconds;
		default:
			break;
		}
		return 0;
	}

	private void finaliseJournalItem(String id, Leg leg, LegEvent legEvent, String maasId) {
		JournalEntry entry = repository.getLastStartJournalEntry(maasId, id);
		entry.setUsedTime(leg.getEndTime().subtract(leg.getStartTime()));
		entry.setDistance(calculateDistance(entry, legEvent));
		BigDecimal amount = calculateFare(leg);
		entry.setAmount(amount);
		entry.setCurrencyCode(configuration.getCurrencyCode());
		long vatRate = configuration.getVatRate();
		entry.setVatRate(BigDecimal.valueOf(vatRate));
		entry.setAmountExVat(BigDecimal.valueOf(amount.doubleValue() * ((100.0 - vatRate) / 100.0)));
		entry.setVatCountryCode(configuration.getCurrencyCode());
		long expirationDate = Instant.now().getEpochSecond();
		expirationDate += configuration.getExpirationDays() * 24 * 60 * 60;
		entry.setExpirationDate(BigDecimal.valueOf(expirationDate));
		entry.setState(JournalState.TO_INVOICE);
	}

	private BigDecimal calculateDistance(JournalEntry entry, LegEvent legEvent) {
		List<LegEvent> legEvents = repository.getLegEvents(entry.getJournalId());
		Coordinates coordinates = legEvents.get(0).getAsset().getPlace().getCoordinates();
		Coordinates coordinates2 = legEvent.getAsset().getPlace().getCoordinates();

		BigDecimal lat = coordinates.getLat().subtract(coordinates2.getLat()).abs();
		BigDecimal lon = coordinates.getLng().subtract(coordinates2.getLng()).abs();

		lat = lat.multiply(lat);
		lon = lon.multiply(lon);

		return BigDecimal.valueOf(Math.sqrt(lat.doubleValue() + lon.doubleValue()));
	}

}
