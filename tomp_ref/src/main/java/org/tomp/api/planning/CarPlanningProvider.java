package org.tomp.api.planning;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import io.swagger.model.AssetClass;
import io.swagger.model.AssetProperties;
import io.swagger.model.AssetProperties.EnergyLabelEnum;
import io.swagger.model.Fare;
import io.swagger.model.FarePart;
import io.swagger.model.FarePart.TypeEnum;
import io.swagger.model.AssetType;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "car", matchIfMissing = false)
public class CarPlanningProvider extends BasePlanningProvider {

	@Override
	protected Fare getFare() {
		Fare fare = new Fare();
		FarePart part = new FarePart();
		part.setType(TypeEnum.FIXED);
		part.setCurrencyCode("EUR");
		part.setAmount(BigDecimal.valueOf(3.33));
		part.setVatRate(BigDecimal.valueOf(21.0));
		fare.addPartsItem(part);
		return fare;
	}

	@Override
	protected AssetType getAssetType() {
		AssetType assetType = new AssetType();
		assetType.setAssetClass(AssetClass.CAR);
		assetType.setAssetSubClass("Small car");
		AssetProperties sharedProperties = new AssetProperties();
		sharedProperties.setModel("Peugeot 208");
		sharedProperties.setEnergyLabel(EnergyLabelEnum.A);
		assetType.setSharedProperties(sharedProperties);
		return assetType;
	}
}
