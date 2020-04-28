package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.mp.ObjectFromFileProvider;

import io.swagger.model.StationInformation;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemRegion;
import io.swagger.model.TypeOfAsset;

@Component
@Profile(value = { "dummy", "bus", "train", "maasprovider" })
public class GenericOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		ObjectFromFileProvider<TypeOfAsset[]> provider = new ObjectFromFileProvider<>();
		ArrayList<TypeOfAsset> list = new ArrayList<>();
		Collections.addAll(list, provider.getObject(acceptLanguage, TypeOfAsset[].class, configuration.getAssetFile()));
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

}
