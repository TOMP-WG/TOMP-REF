package org.tomp.api.model.parking;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LonLatLocation {

	@JsonProperty("latitude")
	private Float latitude;
	@JsonProperty("longitude")
	private Float longitude;

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
}
