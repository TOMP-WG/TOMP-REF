package org.tomp.api.mp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.client.ApiException;
import io.swagger.model.SystemInformation;
import io.swagger.model.SysteminformationInformation;
import io.swagger.model.TypeOfAsset;

@Component
@Profile("maasprovider")
public class TOProvider {

	@Autowired
	private ExternalConfiguration configuration;

	List<TransportOperator> cache = new ArrayList<>();

	public List<TransportOperator> getTransportOperators() {
		if (cache.isEmpty()) {
			for (TransportOperator operator : configuration.getTransportOperators()) {
				populateTransportOperatorInfo(operator);
			}
		}
		return cache;
	}

	private void populateTransportOperatorInfo(TransportOperator operator) {
		try {
			getSystemInformation(operator);
			getAssetInformation(operator);

			cache.add(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getAssetInformation(TransportOperator to) throws ApiException {
		try {
			TypeOfAsset[] assets = ClientUtil.get(to, "/operator/available-assets", TypeOfAsset[].class);
			for (TypeOfAsset assetType : assets) {
				to.getAssetClasses().add(assetType.getAssetClass());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getSystemInformation(TransportOperator to) throws ApiException {
		SystemInformation[] data = ClientUtil.get(to, "/operator/information", SystemInformation[].class);
		SysteminformationInformation info = data[0].getInformation().get(0);
		to.setName(info.getName());
		to.setMaaSId(info.getSystemId());
		to.setDescription(info.getPurchaseUrl());
		to.setContact(info.getPhoneNumber());
	}
}
