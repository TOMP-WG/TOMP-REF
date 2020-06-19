package org.tomp.api.model.parking;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaGeometry {
	@JsonProperty("type")
	private String type;
	@JsonProperty("coordinates")
	private BigDecimal[][][] polygon;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal[][][] getPolygon() {
		return polygon;
	}

	public void setPolygon(BigDecimal[][][] polygon) {
		this.polygon = polygon;
	}
}
