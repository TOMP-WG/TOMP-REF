package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DynamicParkingData {
	@JsonProperty("parkingFacilityDynamicInformation")
	private
	ParkingFacilityDynamicInformation parkingFacilityDynamicInformation;

	public ParkingFacilityDynamicInformation getParkingFacilityDynamicInformation() {
		return parkingFacilityDynamicInformation;
	}

	public void setParkingFacilityDynamicInformation(ParkingFacilityDynamicInformation parkingFacilityDynamicInformation) {
		this.parkingFacilityDynamicInformation = parkingFacilityDynamicInformation;
	}
}
