package org.tomp.api.planning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.repository.DummyRepository;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.Fare;
import io.swagger.model.OptionsLeg;
import io.swagger.model.TypeOfAsset;

public class GenericPlanningProvider extends BasePlanningProvider {

	public GenericPlanningProvider(DummyRepository repository, ExternalConfiguration configuration) {
		super(repository, configuration);
	}

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
		ObjectFromFileProvider<TypeOfAsset[]> provider = new ObjectFromFileProvider<>();
		ArrayList<TypeOfAsset> list = new ArrayList<>();
		String assetFile = configuration.getAssetFile();
		TypeOfAsset[] assets = provider.getObject("", TypeOfAsset[].class, assetFile);
		Collections.addAll(list, assets);
		int randomItem = new Random().nextInt(list.size());
		return list.get(randomItem);
	}

}
