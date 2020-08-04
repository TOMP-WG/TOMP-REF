package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ExternalFileService;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "generic", matchIfMissing = true)
public class GenericOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;
	@Autowired
	ExternalFileService fileService;

	@Override
	public List<AssetType> getAvailableAssetTypes(String acceptLanguage) {
		ObjectFromFileProvider<AssetType[]> provider = new ObjectFromFileProvider<>();
		ArrayList<AssetType> list = new ArrayList<>();
		Collections.addAll(list, provider.getObject(acceptLanguage, AssetType[].class, configuration.getAssetFile()));
		return list;
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		ObjectFromFileProvider<SystemInformation> provider = new ObjectFromFileProvider<>();
		return provider.getObject(acceptLanguage, SystemInformation.class, configuration.getSystemInformationFile());
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		ObjectFromFileProvider<StationInformation[]> provider = new ObjectFromFileProvider<>();
		StationInformation[] stationArray = provider.getObject(acceptLanguage, StationInformation[].class,
				configuration.getStationsFile());
		List<StationInformation> stations = new ArrayList<>();
		for (int i = 0; i < stationArray.length; i++) {
			stations.add(stationArray[i]);
		}
		return stations;
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		ObjectFromFileProvider<SystemRegion[]> provider = new ObjectFromFileProvider<>();
		SystemRegion[] regionArray = provider.getObject(acceptLanguage, SystemRegion[].class,
				configuration.getRegionsFile());
		List<SystemRegion> regions = new ArrayList<>();
		for (int i = 0; i < regionArray.length; i++) {
			regions.add(regionArray[i]);
		}
		return regions;
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<EndpointImplementation> getMeta(String acceptLanguage) {
		return fileService.getEndPoints();
	}
}
