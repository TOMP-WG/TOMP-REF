package org.tomp.api.operatorinformation;

import java.util.List;

import io.swagger.model.SystemInformation;

public interface OperatorInformationProvider {

	List<Object> getAvailableAssetTypes(String acceptLanguage);

	List<SystemInformation> getOperatorInformation(String acceptLanguage);

}
