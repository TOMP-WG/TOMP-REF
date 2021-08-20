package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.model.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.FarePart.TypeEnum;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "bus", matchIfMissing = false)
public class BusPlanningProvider implements PlanningProvider {

	private @NotNull @Valid Coordinates from;
	private List<String> assets;
	private @Valid Coordinates to;
	private @Valid OffsetDateTime start;
	private @Valid OffsetDateTime end;

	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		Planning options = new Planning();
		from = body.getFrom().getCoordinates();
		to = body.getTo().getCoordinates();
		start = body.getDepartureTime();
		end = body.getArrivalTime();
		options.setOptions(getResults(body, bookingIntent));
		return options;
	}

	private List<Booking> getResults(@Valid PlanningRequest body, boolean bookingIntent) {
		Leg leg = new Leg();
		if (bookingIntent) {
			leg.setId(UUID.randomUUID().toString());
		}
		leg.setAssetType(getAssetType());
		leg.setFrom(toPlace(from));
		leg.setTo(toPlace(to));
		leg.setDepartureTime(start);
		leg.setArrivalTime(end);
		leg.setPricing(getFare());

		Booking booking = new Booking();
		booking.setLegs(Arrays.asList(leg));
		return Arrays.asList(booking);
	}

	private Place toPlace(@NotNull @Valid Coordinates coord) {
		Place place = new Place();
		place.setCoordinates(coord);
		return place;
	}

	private Fare getFare() {
		Fare fare = new Fare();
		FarePart part = new FarePart();
		part.setType(TypeEnum.FIXED);
		part.setCurrencyCode("EUR");
		part.setAmount(BigDecimal.valueOf(10.33));
		part.setVatRate(BigDecimal.valueOf(21.0));
		fare.addPartsItem(part);
		return fare;
	}

	private AssetType getAssetType() {
		AssetType assetType = new AssetType();
		assetType.setAssetClass(AssetClass.BICYCLE);
		assetType.setAssetSubClass("Child, 26 inch");
		AssetProperties sharedProperties = new AssetProperties();
		sharedProperties.setModel("Batavus");
		sharedProperties.setEnergyLabel(io.swagger.model.AssetProperties.EnergyLabelEnum.A);
		assetType.setSharedProperties(sharedProperties);
		return assetType;
	}

}
