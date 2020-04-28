package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.swagger.model.AssetClass;
import io.swagger.model.Condition;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.OptionsLeg;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;
import io.swagger.model.PlanningResult;
import io.swagger.model.SimpleLeg;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.TypeOfAsset.EnergyLabelEnum;

@Component
@Profile("train")
public class TrainPlanningProvider implements PlanningProvider {

	private @NotNull @Valid Coordinates from;
	private @Valid Coordinates to;
	private @Valid BigDecimal start;
	private @Valid BigDecimal end;

	public PlanningOptions getOptions(@Valid PlanningCheck body, String acceptLanguage) {
		PlanningOptions options = new PlanningOptions();
		options.setConditions(new ArrayList<Condition>());
		from = body.getFrom();
		to = body.getTo();
		start = body.getStartTime();
		end = body.getEndTime();
		options.setResults(getResults(body));
		return options;
	}

	private ArrayList<PlanningResult> getResults(@Valid PlanningCheck body) {
		ArrayList<PlanningResult> arrayList = new ArrayList<>();
		SimpleLeg result = new SimpleLeg();
		if (body.isProvideIds().booleanValue()) {
			result.setId("DF(L<#NFSD=SFDKLJ");
		}
		result.setTypeOfAsset(getAssetType());
		result.setLeg(getLeg());
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

	private OptionsLeg getLeg() {
		OptionsLeg leg = new OptionsLeg();
		leg.setFrom(from);
		leg.setTo(to);
		leg.setStartTime(start);
		leg.setEndTime(end);
		return leg;
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
