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

import io.swagger.model.AssetType;

@Component
@ConditionalOnProperty(value = "tomp.asset-file", matchIfMissing = false)
public class FileBasedAssetProvider implements AssetProvider {

	@Autowired
	ExternalConfiguration configuration;

	public List<AssetType> getAssetTypes() {
		ObjectFromFileProvider<AssetType[]> provider = new ObjectFromFileProvider<>();
		String assetFile = configuration.getAssetFile();
		AssetType[] assets = provider.getObject("", AssetType[].class, assetFile);
		ArrayList<AssetType> list = new ArrayList<>();
		Collections.addAll(list, assets);
		return list;
	}

	public AssetType getTypeOfAsset() {
		ObjectFromFileProvider<AssetType[]> provider = new ObjectFromFileProvider<>();
		ArrayList<AssetType> list = new ArrayList<>();
		String assetFile = configuration.getAssetFile();
		AssetType[] assets = provider.getObject("", AssetType[].class, assetFile);
		Collections.addAll(list, assets);
		int randomItem = new Random().nextInt(list.size());
		return list.get(randomItem);
	}
}
