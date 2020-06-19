package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingFacilityInformation {
	@JsonProperty("description")
	private String description;
	@JsonProperty("identifier")
	private String identifier;
	@JsonProperty("name")
	private String name;
	@JsonProperty("specifications")
	private Specification[] specification;
	@JsonProperty("accessPoints")
	private AccessPoints[] accessPoints;

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

	public Specification[] getSpecifications() {
		return specification;
	}

	public void setSpecifications(Specification[] specification) {
		this.specification = specification;
	}

	public AccessPoints[] getAccessPoints() {
		return accessPoints;
	}

	public void setAccessPoints(AccessPoints[] accessPoints) {
		this.accessPoints = accessPoints;
	}
}
