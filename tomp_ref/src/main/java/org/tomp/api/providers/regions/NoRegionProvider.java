package org.tomp.api.providers.regions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.region-file", havingValue = "none", matchIfMissing = false)
public class NoRegionProvider implements RegionProvider {

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		return new ArrayList<SystemRegion>();
	}

}
