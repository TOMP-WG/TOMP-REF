package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specification {
	@JsonProperty("areaGeometry")
	private
	AreaGeometry areaGeometry;

	public AreaGeometry getAreaGeometry() {
		return areaGeometry;
	}

	public void setAreaGeometry(AreaGeometry areaGeometry) {
		this.areaGeometry = areaGeometry;
	}
}
