package org.tomp.api.repository;

import java.util.List;

import io.swagger.model.StationInformation;

public interface StationContainer {
	public List<StationInformation> getStations();
}
