package org.tomp.api.planning;

import org.tomp.api.mp.ObjectFromFileProvider;

import io.swagger.model.Fare;
import io.swagger.model.OptionsLeg;
import io.swagger.model.TypeOfAsset;

public class GenericPlanningProvider extends BasePlanningProvider {

	@Override
	protected Fare getFare() {
		ObjectFromFileProvider<Fare> conditionFileProvider = new ObjectFromFileProvider<>();
		return conditionFileProvider.getObject("", Fare.class, configuration.getFareFile());
	}

	@Override
	protected OptionsLeg getLeg() {
		ObjectFromFileProvider<OptionsLeg> conditionFileProvider = new ObjectFromFileProvider<>();
		return conditionFileProvider.getObject("", OptionsLeg.class, configuration.getOptionsLegFile());
	}

	@Override
	protected TypeOfAsset getAssetType() {
		ObjectFromFileProvider<TypeOfAsset> conditionFileProvider = new ObjectFromFileProvider<>();
		return conditionFileProvider.getObject("", TypeOfAsset.class, configuration.getTypeOfAssetFile());
	}

}
