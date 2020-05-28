package org.tomp.api.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.AssetClass;
import io.swagger.model.SystemRegion;

public class TransportOperator extends MaasOperator {

	private List<AssetClass> typeOfAssets = new ArrayList<>();
	private List<SystemRegion> list = new ArrayList<>();

	public boolean providesAssetClass(AssetClass assetClass) {
		return getAssetClasses().contains(assetClass);
	}

	public List<AssetClass> getAssetClasses() {
		return typeOfAssets;
	}

	public void setAssetClasses(List<AssetClass> typeOfAssets) {
		this.typeOfAssets = typeOfAssets;
	}

	public void setRegions(List<SystemRegion> list) {
		this.list = list;
	}

	public List<SystemRegion> getRegions() {
		return list;
	}
}
