package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.utils.RouterUtil;

import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "router", matchIfMissing = false)
public class RouterOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	RouterUtil routerUtil;

	@Override
	public List<AssetType> getAvailableAssetTypes(String acceptLanguage) {
		try {
			AssetType[] assetTypes = routerUtil.sendToTO("GET", "/operator/available-assets/", AssetType[].class, "",
					acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		try {
			return routerUtil.sendToTO("GET", "/operator/information/", SystemInformation.class, "", acceptLanguage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		try {
			StationInformation[] assetTypes = routerUtil.sendToTO("GET", "/operator/stations/",
					StationInformation[].class, "", acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		try {
			SystemRegion[] assetTypes = routerUtil.sendToTO("GET", "/operator/regions/", SystemRegion[].class, "",
					acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		try {
			SystemPricingPlan[] assetTypes = routerUtil.sendToTO("GET", "/operator/pricing/", SystemPricingPlan[].class,
					"", acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		try {
			SystemHours[] assetTypes = routerUtil.sendToTO("GET", "/operator/operating-hours/", SystemHours[].class, "",
					acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		try {
			SystemCalendar[] assetTypes = routerUtil.sendToTO("GET", "/operator/operating-calendar/",
					SystemCalendar[].class, "", acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public List<EndpointImplementation> getMeta(String acceptLanguage) {
		try {
			EndpointImplementation[] assetTypes = routerUtil.sendToTO("GET", "/operator/meta/",
					EndpointImplementation[].class, "", acceptLanguage);
			return Arrays.asList(assetTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
