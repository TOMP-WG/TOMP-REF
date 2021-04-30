package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ExternalFileService;
import org.tomp.api.utils.ObjectFromFileProvider;

import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "bike", matchIfMissing = false)
public class SimpleBikeOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalConfiguration configuration;

	@Autowired
	ExternalFileService fileService;

	@Override
	public List<AssetType> getAvailableAssetTypes(String acceptLanguage) {
		ObjectFromFileProvider<AssetType[]> provider = new ObjectFromFileProvider<>();
		ArrayList<AssetType> list = new ArrayList<>();
		AssetType[] assets = provider.getObject(acceptLanguage, AssetType[].class, configuration.getAssetFile());
		Collections.addAll(list, assets);
		return list;
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		SystemInformation info = new SystemInformation();
		info.setSystemId("maas-3234434");
		info.setEmail("email@bike-operator.org");
		info.setLanguage(Arrays.asList(acceptLanguage));
		info.setName("Bike Operator");
		return info;
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		ObjectFromFileProvider<StationInformation[]> provider = new ObjectFromFileProvider<>();

		return Arrays.asList(
				provider.getObject(acceptLanguage, StationInformation[].class, configuration.getStationsFile()));
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		ObjectFromFileProvider<SystemRegion[]> provider = new ObjectFromFileProvider<>();
		SystemRegion[] regionArray = provider.getObject(acceptLanguage, SystemRegion[].class,
				configuration.getRegionsFile());
		List<SystemRegion> regions = new ArrayList<>();
		for (int i = 0; i < regionArray.length; i++) {
			regions.add(regionArray[i]);
			System.out.println(regionArray[i].toString());
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
