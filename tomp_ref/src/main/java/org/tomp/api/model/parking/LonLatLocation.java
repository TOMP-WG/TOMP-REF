package org.tomp.api.model.parking;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LonLatLocation {

	@JsonProperty("latitude")
	private BigDecimal latitude;
	@JsonProperty("longitude")
	private BigDecimal longitude;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
}
