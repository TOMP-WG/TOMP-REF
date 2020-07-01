package org.tomp.api.providers.assets;

import java.util.List;

import io.swagger.model.AssetType;

public interface AssetProvider {
	public AssetType getTypeOfAsset();

	public List<AssetType> getAssetTypes();
}
