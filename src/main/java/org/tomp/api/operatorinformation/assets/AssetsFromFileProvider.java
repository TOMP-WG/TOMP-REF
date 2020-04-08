package org.tomp.api.operatorinformation.assets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.mp.ObjectFromFileProvider;

import io.swagger.model.TypeOfAsset;

@Component
@Conditional(AssetsFactory.class)
public class AssetsFromFileProvider extends ObjectFromFileProvider<TypeOfAsset[]> implements AssetsProvider {

	private static final Logger log = LoggerFactory.getLogger(AssetsFromFileProvider.class);

	@Autowired
	ExternalConfiguration configuration;

	@Override
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		List<TypeOfAsset> a = new ArrayList<>();
		try {
			log.debug("Retrieving assets from file");
			TypeOfAsset[] objects = getObject(acceptLanguage, TypeOfAsset[].class, configuration.getAssetFile());
			if (objects != null) {
				log.debug("Retrieved " + objects.length);
				Collections.addAll(a, objects);
			}
		} catch (Exception e) {
			log.error("getAvailableAssetTypes", e);
		}
		return a;
	}
}
