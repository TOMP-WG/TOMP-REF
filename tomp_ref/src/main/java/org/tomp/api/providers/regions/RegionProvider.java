package org.tomp.api.providers.regions;

import java.util.List;

import io.swagger.model.SystemRegion;

public interface RegionProvider {
	public List<SystemRegion> getRegions(String acceptLanguage);
}
