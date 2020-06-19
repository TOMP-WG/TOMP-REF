package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingFacility {
	@JsonProperty("name")
	private String name;
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("staticDataUrl")
	private String staticDataUrl;
	@JsonProperty("dynamicDataUrl")
	private String dynamicDataUrl;
	@JsonProperty("limitedAccess")
	private boolean limitedAccess;
	@JsonProperty("geoLocation")
	private LonLatLocation geoLocation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getStaticDataUrl() {
		return staticDataUrl;
	}

	public void setStaticDataUrl(String staticDataUrl) {
		this.staticDataUrl = staticDataUrl;
	}

	public String getDynamicDataUrl() {
		return dynamicDataUrl;
	}

	public void setDynamicDataUrl(String dynamicDataUrl) {
		this.dynamicDataUrl = dynamicDataUrl;
	}

	public boolean isLimitedAccess() {
		return limitedAccess;
	}

	public void setLimitedAccess(boolean limitedAccess) {
		this.limitedAccess = limitedAccess;
	}

	public LonLatLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(LonLatLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
}
