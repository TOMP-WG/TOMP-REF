package org.tomp.api.operatorinformation.assets;

import java.util.List;

import io.swagger.model.TypeOfAsset;

public interface AssetsProvider {

	List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage);

}
