package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.AssetClass;
import io.swagger.model.AssetProperties;
import io.swagger.model.AssetProperties.EnergyLabelEnum;
import io.swagger.model.AssetType;
import io.swagger.model.Booking;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.Leg;
import io.swagger.model.Place;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "train", matchIfMissing = false)
public class TrainPlanningProvider implements PlanningProvider {

	private @NotNull @Valid Coordinates from;
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
		Booking booking = new Booking();
		Leg leg = new Leg();
		if (bookingIntent) {
			leg.setId("DF(L<#NFSD=SFDKLJ");
		}
		leg.setAssetType(getAssetType());
		leg.setFrom(toPlace(from));
		leg.setTo(toPlace(to));
		leg.setDepartureTime(start);
		leg.setArrivalTime(end);
		leg.setPricing(getFare());
		booking.setLegs(Arrays.asList(leg));
		return Arrays.asList(booking);
	}

	private Place toPlace(@NotNull @Valid Coordinates from2) {
		// TODO Auto-generated method stub
		return null;
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
		AssetType typeOfAsset = new AssetType();
		typeOfAsset.setAssetClass(AssetClass.BICYCLE);
		typeOfAsset.setAssetSubClass("Child, 26 inch");
		AssetProperties sharedProperties = new AssetProperties();

		typeOfAsset.setSharedProperties(sharedProperties);
		sharedProperties.setModel("Batavus");
		sharedProperties.setEnergyLabel(EnergyLabelEnum.A);
		return typeOfAsset;
	}

}
