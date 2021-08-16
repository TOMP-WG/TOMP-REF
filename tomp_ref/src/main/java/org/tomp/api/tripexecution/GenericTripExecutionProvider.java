package org.tomp.api.tripexecution;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.temporal.ChronoUnit;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DefaultRepository;

import io.swagger.model.Asset;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegState;
import io.swagger.model.Suboperator;
import io.swagger.model.Token;
import io.swagger.model.TokenDefault;

@Component
@ConditionalOnProperty(value = "tomp.providers.tripexecution", havingValue = "generic", matchIfMissing = true)
public class GenericTripExecutionProvider implements TripExecutionProvider {

	@Autowired
	DefaultRepository repository;

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public Leg prepare(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		leg.setAssetAccessData(constructTokenToOpenAsset(body, leg));
		leg.setState(LegState.PREPARING);
		repository.saveLegEvent(id, body);
		return leg;
	}

	private Token constructTokenToOpenAsset(LegEvent body, Leg planning) {
		Token token = new Token();
		token.setValidFrom(body.getTime());
		token.setValidUntil(ChronoUnit.SECONDS.addTo(planning.getDepartureTime(), -3600));
		TokenDefault tokenData = new TokenDefault();
		((TokenDefault) tokenData).put("code", UUID.randomUUID());
		token.setTokenData(tokenData);
		return token;
	}

	@Override
	public Leg assignAsset(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Asset asset = new Asset();
		asset.setId(id);
		leg.setAsset(asset);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg reserve(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg leg = repository.getLeg(id);
		Asset asset = new Asset();
		asset.setId(id);
		leg.setAsset(asset);
		repository.saveLegEvent(id, body);
		return leg;
	}

	@Override
	public Leg setInUse(LegEvent body, String acceptLanguage, String id, String maasId) {
		Leg execution = repository.getLeg(id);
		Suboperator suboperator = new Suboperator();
		suboperator.setMaasId(maasId);
		execution.setSuboperator(suboperator);
		if (execution.getAsset() == null && body.getAsset() != null) {
			execution.setAsset(body.getAsset());
		}
		execution.setFrom(body.getAsset().getOverriddenProperties().getLocation());
		execution.setDepartureTime(body.getTime());
		repository.saveLegEvent(id, body);
		execution.setState(LegState.IN_USE);
		createJournalItem(id, execution, body, maasId);
		return execution;
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
		leg.setTo(body.getAsset().getOverriddenProperties().getLocation());
		leg.setArrivalTime(body.getTime());
		leg.setPricing(leg.getPricing());
		leg.getPricing().setEstimated(false);
		finaliseJournalItem(id, leg, body, maasId);
		repository.saveLegEvent(id, body);
		return leg;
	}

	private void createJournalItem(String id, Leg execution, LegEvent body, String maasId) {
		JournalEntry entry = new JournalEntry();
		entry.setJournalId(id);
		entry.setState(null);
		repository.saveJournalEntry(entry, maasId);
	}

	private BigDecimal calculateFare(Leg execution) {
		double amount = 0;
		Fare fare = execution.getPricing();

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

	private double calculateFlexPart(FarePart part, Leg execution) {
		double amount = part.getAmount().doubleValue();
		switch (part.getUnitType()) {
		case HOUR:
			return ChronoUnit.HOURS.between(execution.getDepartureTime(), execution.getArrivalTime());
		case KM:
			return amount * (execution.getDistance().doubleValue() / 1000);
		case MILE:
			return amount * (execution.getDistance().doubleValue() / 1609);
		case MINUTE:
			return ChronoUnit.MINUTES.between(execution.getDepartureTime(), execution.getArrivalTime());
		case PERCENTAGE:
			break;
		case SECOND:
			return ChronoUnit.SECONDS.between(execution.getDepartureTime(), execution.getArrivalTime());
		default:
			break;
		}
		return 0;
	}

	private void finaliseJournalItem(String id, Leg execution, LegEvent legEvent, String maasId) {
		JournalEntry entry = repository.getLastStartJournalEntry(maasId, id);
		entry.setUsedTime(BigDecimal
				.valueOf(ChronoUnit.SECONDS.between(execution.getDepartureTime(), execution.getArrivalTime())));
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

	private BigDecimal calculateDistance(JournalEntry entry, LegEvent legEvent) {
		List<LegEvent> legEvents = repository.getLegEvents(entry.getJournalId());
		Coordinates coordinates = legEvents.get(0).getAsset().getOverriddenProperties().getLocation().getCoordinates();
		Coordinates coordinates2 = legEvent.getAsset().getOverriddenProperties().getLocation().getCoordinates();

		BigDecimal lat = coordinates.getLat().subtract(coordinates2.getLat()).abs();
		BigDecimal lon = coordinates.getLng().subtract(coordinates2.getLng()).abs();

		lat = lat.multiply(lat);
		lon = lon.multiply(lon);

		return BigDecimal.valueOf(Math.sqrt(lat.doubleValue() + lon.doubleValue()));
	}

}
