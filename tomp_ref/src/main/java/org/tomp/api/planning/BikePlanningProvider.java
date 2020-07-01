package org.tomp.api.planning;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.utils.GeoUtil;

import io.swagger.model.AssetClass;
import io.swagger.model.AssetProperties;
import io.swagger.model.AssetProperties.EnergyLabelEnum;
import io.swagger.model.Condition;
import io.swagger.model.ConditionReturnArea;
import io.swagger.model.Coordinates;
import io.swagger.model.Day;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.GeojsonPolygon;
import io.swagger.model.Leg;
import io.swagger.model.SystemHours;
import io.swagger.model.AssetType;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "bike", matchIfMissing = false)
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

	@Override
	protected AssetType getAssetType() {
		AssetType assetType = new AssetType();
		assetType.setAssetClass(AssetClass.BICYCLE);
		assetType.setAssetSubClass("Child, 26 inch");
		AssetProperties sharedProperties = new AssetProperties();
		sharedProperties.setModel("Batavus");
		sharedProperties.setEnergyLabel(EnergyLabelEnum.A);
		assetType.setSharedProperties(sharedProperties);
		return assetType;
	}

	@Override
	protected List<Condition> getConditionsForLeg(Leg result, String acceptLanguage) {
		ConditionReturnArea condition = new ConditionReturnArea();
		condition.setId("Haarlem");
		GeojsonPolygon geometry = new GeojsonPolygon();
		GeoUtil.addPoint(geometry, 4.599516, 52.42857);
		GeoUtil.addPoint(geometry, 4.686921, 52.42857);
		GeoUtil.addPoint(geometry, 4.686921, 52.338906);
		GeoUtil.addPoint(geometry, 4.599516, 52.338906);
		GeoUtil.addPoint(geometry, 4.599516, 52.42857);
		condition.setReturnArea(geometry);
		SystemHours period = new SystemHours();
		period.setStartTime("12:18");
		period.setEndTime("13:02");
		period.setDays(Arrays.asList(Day.MON));
		condition.setReturnHours(Arrays.asList(period));
		return Arrays.asList((Condition) condition);
	}
}
