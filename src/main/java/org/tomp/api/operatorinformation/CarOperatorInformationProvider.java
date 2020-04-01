package org.tomp.api.operatorinformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.swagger.model.AssetClass;
import io.swagger.model.SystemInformation;
import io.swagger.model.SysteminformationInformation;
import io.swagger.model.TypeOfAsset;

@Component
@Profile(value = { "car" })
public class CarOperatorInformationProvider implements OperatorInformationProvider {

	@Override
	public List<Object> getAvailableAssetTypes(String acceptLanguage) {
		ArrayList<Object> list = new ArrayList<>();
		TypeOfAsset asset = new TypeOfAsset();
		asset.setAssetClass(AssetClass.CAR);
		asset.setAmountAvailable(BigDecimal.valueOf(11));
		list.add(asset);
		return list;
	}

	@Override
	public List<SystemInformation> getOperatorInformation(String acceptLanguage) {
		List<SystemInformation> informationList = new ArrayList<>();
		informationList.add(getStationInformation(acceptLanguage));
		return informationList;
	}

	private SystemInformation getStationInformation(String acceptLanguage) {
		SystemInformation systemInformation = new SystemInformation();
		ArrayList<SysteminformationInformation> information = new ArrayList<>();
		SysteminformationInformation info = new SysteminformationInformation();
		info.setSystemId("maas-car-3342");
		info.setEmail("email@caroperator.org");
		info.setLanguage(acceptLanguage);
		info.setName("Car Operator");
		information.add(info);
		systemInformation.setInformation(information);
		return systemInformation;
	}

}
