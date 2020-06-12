package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.AssetClass;
import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.Leg;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.TypeOfAsset.EnergyLabelEnum;

@Component
@Profile("bus")
public class BusPlanningProvider implements PlanningProvider {

	private @NotNull @Valid Coordinates from;
	private @Valid Coordinates to;
	private @Valid OffsetDateTime start;
	private @Valid OffsetDateTime end;

	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		Planning options = new Planning();
		options.setConditions(new ArrayList<Condition>());
		from = body.getFrom().getCoordinates();
		to = body.getTo().getCoordinates();
		start = body.getStartTime();
		end = body.getEndTime();
		options.setLegOptions(getResults(body, bookingIntent));
		return options;
	}

	private ArrayList<Leg> getResults(@Valid PlanningRequest body, boolean bookingIntent) {
		ArrayList<Leg> arrayList = new ArrayList<>();
		Leg result = new Leg();
		if (bookingIntent) {
			result.setId(UUID.randomUUID().toString());
		}
		result.setAsset(getAssetType());
		result.setFrom(from);
		result.setTo(to);
		result.setStartTime(start);
		result.setEndTime(end);
		result.setPricing(getFare());
		arrayList.add(result);
		return arrayList;
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

	private TypeOfAsset getAssetType() {
		TypeOfAsset typeOfAsset = new TypeOfAsset();
		typeOfAsset.setAssetClass(AssetClass.BICYCLE);
		typeOfAsset.setAssetSubClass("Child, 26 inch");
		typeOfAsset.setModel("Batavus");
		typeOfAsset.setEnergyLabel(EnergyLabelEnum.A);
		return typeOfAsset;
	}

}
