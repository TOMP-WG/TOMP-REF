package org.tomp.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.model.parking.ParkingFacilityDynamicInformation;
import org.tomp.api.model.parking.ParkingFacilityInformation;

import io.swagger.model.StationInformation;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "parking", matchIfMissing = false)
public class ParkingRepository implements RegionContainer {

	private HashMap<String, ParkingFacilityInformation> staticData = new HashMap<>();
	private HashMap<String, ParkingFacilityDynamicInformation> dynamicData = new HashMap<>();
	private HashMap<String, String> dynamicUrls = new HashMap<>();
	private List<SystemRegion> regions = new ArrayList<>();
	private List<StationInformation> stations = new ArrayList<>();

	public HashMap<String, ParkingFacilityInformation> getStaticData() {
		return staticData;
	}

	public void setStaticData(HashMap<String, ParkingFacilityInformation> staticData) {
		this.staticData = staticData;
	}

	public HashMap<String, ParkingFacilityDynamicInformation> getDynamicData() {
		return dynamicData;
	}

	public void setDynamicData(HashMap<String, ParkingFacilityDynamicInformation> dynamicData) {
		this.dynamicData = dynamicData;
	}

	public HashMap<String, String> getDynamicUrls() {
		return dynamicUrls;
	}

	public void setDynamicUrls(HashMap<String, String> dynamicUrls) {
		this.dynamicUrls = dynamicUrls;
	}

	public List<SystemRegion> getRegions() {
		return regions;
	}

	public void setRegions(List<SystemRegion> regions) {
		this.regions = regions;
	}

	public List<StationInformation> getStations() {
		return stations;
	}

	public void setStations(List<StationInformation> stations) {
		this.stations = stations;
	}

}
