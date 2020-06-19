package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingFacilityDynamicInformation {
	@JsonProperty("description")
	private String description;
	@JsonProperty("identifier")
	private String identifier;
	@JsonProperty("name")
	private String name;
	@JsonProperty("facilityActualStatus")
	private FacilityActualStatus facilityActualStatus;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FacilityActualStatus getFacilityActualStatus() {
		return facilityActualStatus;
	}

	public void setFacilityActualStatus(FacilityActualStatus facilityActualStatus) {
		this.facilityActualStatus = facilityActualStatus;
	}
}
