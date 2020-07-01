package org.tomp.api.operatorinformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.locationtech.jts.geom.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.configuration.OverpassConfiguration;
import org.tomp.api.providers.assets.AssetProvider;
import org.tomp.api.providers.regions.RegionProvider;
import org.tomp.api.utils.ExternalFileService;
import org.tomp.api.utils.GeoUtil;
import org.tomp.api.utils.OSMUtil;

import io.swagger.model.AssetType;
import io.swagger.model.GeojsonPolygon;
import io.swagger.model.Place;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "overpass", matchIfMissing = false)
public class OsmOperatorInformationProvider implements OperatorInformationProvider {

	@Autowired
	ExternalFileService fileService;

	@Autowired
	ExternalConfiguration configuration;

	@Autowired
	OverpassConfiguration overpassConfiguration;

	@Autowired(required = false)
	AssetProvider assetProvider;

	@Autowired(required = false)
	OperatorInformationProvider operatorInformationProvider;

	@Autowired(required = false)
	RegionProvider regionProvider;

	List<StationInformation> stations = null;

	@PostConstruct
	public void postConstruct() {
		getStations("en");
	}

	@Override
	public List<AssetType> getAvailableAssetTypes(String acceptLanguage) {
		if (assetProvider != null) {
			return assetProvider.getAssetTypes();
		}
		return new ArrayList<>();
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		if (operatorInformationProvider != null) {
			return operatorInformationProvider.getOperatorInformation(acceptLanguage);
		}
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		if (stations == null) {
			stations = new ArrayList<>();
			GeojsonPolygon area = fileService.getArea();
			Envelope boundingBox = GeoUtil.getBoundingBox(GeoUtil.toPolygon(area));
			double[] bb = new double[] { boundingBox.getMinY(), boundingBox.getMinX(), boundingBox.getMaxY(),
					boundingBox.getMaxX() };
			try {
				List<Place> overpassObjects = OSMUtil.getOverpassObjects(overpassConfiguration.getQl(), bb);
				for (Place p : overpassObjects) {
					StationInformation e = new StationInformation();
					e.setCoordinates(p.getCoordinates());
					e.setStationId(p.getStationId());
					stations.add(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stations;
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		if (regionProvider != null) {
			return regionProvider.getRegions(acceptLanguage);
		}
		SystemRegion region = new SystemRegion();
		region.setRegionId(configuration.getMaasId());
		region.setName(configuration.getAppName());
		region.setServiceArea(fileService.getArea());
		return Arrays.asList(region);
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
