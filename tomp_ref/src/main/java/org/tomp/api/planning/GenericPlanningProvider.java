package org.tomp.api.planning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.tomp.api.providers.assets.AssetProvider;
import org.tomp.api.providers.fares.FareProvider;

import io.swagger.model.Fare;
import io.swagger.model.TypeOfAsset;

@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "generic", matchIfMissing = true)
public class GenericPlanningProvider extends BasePlanningProvider {

	@Autowired
	AssetProvider assetProvider;

	@Autowired
	FareProvider fareProvider;

	@Override
	protected Fare getFare() {
		return fareProvider.getFare();
	}

	@Override
	protected TypeOfAsset getAssetType() {
		return assetProvider.getTypeOfAsset();
	}
}
