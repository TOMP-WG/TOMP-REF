package org.tomp.api.providers.assets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.TypeOfAsset;

@Component
@ConditionalOnProperty(value = "tomp.asset-file", matchIfMissing = false)
public class FileBasedAssetProvider implements AssetProvider {

	@Autowired
	ExternalConfiguration configuration;

	public List<TypeOfAsset> getAssetTypes() {
		ObjectFromFileProvider<TypeOfAsset[]> provider = new ObjectFromFileProvider<>();
		String assetFile = configuration.getAssetFile();
		TypeOfAsset[] assets = provider.getObject("", TypeOfAsset[].class, assetFile);
		ArrayList<TypeOfAsset> list = new ArrayList<>();
		Collections.addAll(list, assets);
		return list;
	}

	public TypeOfAsset getTypeOfAsset() {
		ObjectFromFileProvider<TypeOfAsset[]> provider = new ObjectFromFileProvider<>();
		ArrayList<TypeOfAsset> list = new ArrayList<>();
		String assetFile = configuration.getAssetFile();
		TypeOfAsset[] assets = provider.getObject("", TypeOfAsset[].class, assetFile);
		Collections.addAll(list, assets);
		int randomItem = new Random().nextInt(list.size());
		return list.get(randomItem);
	}
}
