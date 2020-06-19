package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaticParkingData {
	@JsonProperty("parkingFacilityInformation")
	private
	ParkingFacilityInformation information;

	public ParkingFacilityInformation getInformation() {
		return information;
	}

	public void setInformation(ParkingFacilityInformation information) {
		this.information = information;
	}
}
