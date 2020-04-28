package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.swagger.model.AssetClass;
import io.swagger.model.Condition;
import io.swagger.model.ConditionReturnArea;
import io.swagger.model.Coordinates;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.OptionsLeg;
import io.swagger.model.Polygon;
import io.swagger.model.SystemHours;
import io.swagger.model.Time;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.TypeOfAsset.EnergyLabelEnum;

@Component
@Profile("bike")
public class BikePlanningProvider extends BasePlanningProvider {

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		FarePart part = new FarePart();
		part.setType(TypeEnum.FIXED);
		part.setCurrencyCode("EUR");
		part.setAmount(BigDecimal.valueOf(10.33));
		part.setVatRate(BigDecimal.valueOf(21.0));
		fare.addPartsItem(part);
		return fare;
	}

	protected OptionsLeg getLeg() {
		OptionsLeg leg = new OptionsLeg();
		leg.setFrom(from);
		leg.setTo(to);
		leg.setStartTime(start);
		leg.setEndTime(end);
		return leg;
	}

	@Override
	protected TypeOfAsset getAssetType() {
		TypeOfAsset typeOfAsset = new TypeOfAsset();
		typeOfAsset.setAssetClass(AssetClass.BICYCLE);
		typeOfAsset.setAssetSubClass("Child, 26 inch");
		typeOfAsset.setModel("Batavus");
		typeOfAsset.setEnergyLabel(EnergyLabelEnum.A);
		return typeOfAsset;
	}

	@Override
	protected List<Condition> getConditions(String acceptLanguage) {
		ConditionReturnArea condition = new ConditionReturnArea();
		condition.setName("Haarlem");
		Polygon geometry = new Polygon();
		geometry.addPointsItem(toPoint(4.599516, 52.42857));
		geometry.addPointsItem(toPoint(4.686921, 52.42857));
		geometry.addPointsItem(toPoint(4.686921, 52.338906));
		geometry.addPointsItem(toPoint(4.599516, 52.338906));
		geometry.addPointsItem(toPoint(4.599516, 52.42857));
		condition.setReturnArea(geometry);
		SystemHours period = new SystemHours();
		Time startTime = new Time();
		startTime.setTime("12:18");
		period.setStartTime(startTime);
		Time endTime = new Time();
		endTime.setTime("13:02");
		period.setEndTime(endTime);
		condition.setReturnHours(Arrays.asList(period));
		return Arrays.asList((Condition) condition);
	}

	private Coordinates toPoint(double d, double e) {
		Coordinates coordinate = new Coordinates();
		coordinate.setLng(BigDecimal.valueOf(d));
		coordinate.setLat(BigDecimal.valueOf(e));
		return coordinate;
	}
}
