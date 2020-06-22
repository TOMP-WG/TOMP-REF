package org.tomp.api.providers.assets;

import java.util.List;

import io.swagger.model.TypeOfAsset;

public interface AssetProvider {
	public TypeOfAsset getTypeOfAsset();

	public List<TypeOfAsset> getAssetTypes();
}
