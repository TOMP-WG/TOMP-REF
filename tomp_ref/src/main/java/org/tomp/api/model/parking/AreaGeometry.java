package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaGeometry {
	@JsonProperty("type")
	private String type;
	@JsonProperty("coordinates")
	private Float[][][] polygon;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float[][][] getPolygon() {
		return polygon;
	}

	public void setPolygon(Float[][][] polygon) {
		this.polygon = polygon;
	}
}
