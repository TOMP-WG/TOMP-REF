package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingData {
	@JsonProperty("ParkingFacilities")
	private ParkingFacility[] parkingFacilities;

	public ParkingFacility[] getParkingFacilities() {
		return parkingFacilities;
	}

	public void setParkingFacilities(ParkingFacility[] parkingFacilities) {
		this.parkingFacilities = parkingFacilities;
	}
}
