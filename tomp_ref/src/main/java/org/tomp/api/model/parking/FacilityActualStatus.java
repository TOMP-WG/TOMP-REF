package org.tomp.api.model.parking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacilityActualStatus {
	@JsonProperty("lastUpdated")
	private long lastUpdated;
	@JsonProperty("open")
	private boolean open;
	@JsonProperty("full")
	private boolean full;
	@JsonProperty("parkingCapacity")
	private long parkingCapacity;
	@JsonProperty("vacantSpaces")
	private long vacantSpaces;

	public long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public long getParkingCapacity() {
		return parkingCapacity;
	}

	public void setParkingCapacity(long parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}

	public long getVacantSpaces() {
		return vacantSpaces;
	}

	public void setVacantSpaces(long vacantSpaces) {
		this.vacantSpaces = vacantSpaces;
	}
}
