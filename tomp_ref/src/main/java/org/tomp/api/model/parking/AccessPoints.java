package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessPoints {

	@JsonProperty("accessPointLocation")
	private
	LonLatLocation[] accessPointLocation;

	public LonLatLocation[] getAccessPointLocation() {
		return accessPointLocation;
	}

	public void setAccessPointLocation(LonLatLocation[] accessPointLocation) {
		this.accessPointLocation = accessPointLocation;
	} 
}
