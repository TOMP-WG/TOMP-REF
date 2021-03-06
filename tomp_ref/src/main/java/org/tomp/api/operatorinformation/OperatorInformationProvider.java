package org.tomp.api.operatorinformation;

import java.util.List;

import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

public interface OperatorInformationProvider {

	List<AssetType> getAvailableAssetTypes(String acceptLanguage);

	SystemInformation getOperatorInformation(String acceptLanguage);

	List<StationInformation> getStations(String acceptLanguage);

	List<SystemRegion> getRegions(String acceptLanguage);

	List<SystemPricingPlan> getPricingPlans(String acceptLanguage);

	List<SystemHours> getHours(String acceptLanguage);

	List<SystemCalendar> getCalendar(String acceptLanguage);

	List<EndpointImplementation> getMeta(String acceptLanguage);
}
