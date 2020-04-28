package org.tomp.api.operatorinformation;

import java.util.List;

import io.swagger.model.StationInformation;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemRegion;
import io.swagger.model.TypeOfAsset;

public interface OperatorInformationProvider {

	List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage);

	SystemInformation getOperatorInformation(String acceptLanguage);

	List<StationInformation> getStations(String acceptLanguage);

	List<SystemRegion> getRegions(String acceptLanguage);

}
