package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.operatorinformation.assets.AssetsProvider;

import io.swagger.model.StationInformation;
import io.swagger.model.SystemInformation;
import io.swagger.model.SysteminformationInformation;
import io.swagger.model.TypeOfAsset;

@Component
@Profile(value = { "dummy", "bus", "train", "maasprovider" })
public class GenericOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	AssetsProvider assetProvider;

	@Override
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		return assetProvider.getAvailableAssetTypes(acceptLanguage);
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
		info.setSystemId("maas-3234");
		info.setEmail("email@dummy-operator.org");
		info.setLanguage(acceptLanguage);
		info.setName("Generic Operator");
		information.add(info);
		systemInformation.setInformation(information);
		return systemInformation;
	}

	@Override
	public StationInformation getStations(String acceptLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

}
