package org.tomp.api.mp;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.AssetClass;
import io.swagger.model.SystemRegion;

public class TransportOperator {

	private List<AssetClass> typeOfAssets = new ArrayList<>();
	private String maasId;
	private String name;
	private String description;
	private String contact;
	private String tompApiUrl;
	private List<SystemRegion> regions;

	public boolean providesAssetClass(AssetClass assetClass) {
		return getAssetClasses().contains(assetClass);
	}

	public String getMaaSId() {
		return maasId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getContact() {
		return contact;
	}

	public List<AssetClass> getAssetClasses() {
		return typeOfAssets;
	}

	public void setAssetClasses(List<AssetClass> typeOfAssets) {
		this.typeOfAssets = typeOfAssets;
	}

	public void setMaaSId(String maasId) {
		this.maasId = maasId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTompApiUrl() {
		return tompApiUrl;
	}

	public void setTompApiUrl(String tompApiUrl) {
		this.tompApiUrl = tompApiUrl;
	}

	public List<SystemRegion> getRegions() {
		return regions;
	}

	public void setRegions(List<SystemRegion> regions) {
		this.regions = regions;
	}
}
