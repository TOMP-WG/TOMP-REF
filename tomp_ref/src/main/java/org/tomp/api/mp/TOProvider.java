package org.tomp.api.mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasEnvironmentType;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.ExternalFileService;
import org.tomp.api.utils.GeoUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.client.ApiException;
import io.swagger.model.AssetType;
import io.swagger.model.Coordinates;
import io.swagger.model.GeojsonLine;
import io.swagger.model.GeojsonPoint;
import io.swagger.model.GeojsonPolygon;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "maasprovider", matchIfMissing = false)
public class TOProvider {

	private static final Logger log = LoggerFactory.getLogger(TOProvider.class);

	private ExternalFileService fileService;
	private ClientUtil clientUtil;
	private LookupService lookupService;
	List<TransportOperator> cache = new ArrayList<>();

	@Autowired
	public TOProvider(ClientUtil clientUtil, LookupService lookupService, ExternalFileService fileService) {
		this.clientUtil = clientUtil;
		this.lookupService = lookupService;
		this.fileService = fileService;
	}

	@PostConstruct
	private void populateTOs() {
		getOperatorsInArea(fileService.getArea());
	}

	private void getOperatorsInArea(GeojsonPolygon area) {
		MaasOperator[] data;
		try {
			data = lookupService.findOperators(area);
			for (int i = 0; i < data.length; i++) {
				if (data[i].getType() == MaasEnvironmentType.TO) {
					TransportOperator operator = new TransportOperator();
					operator.setName(data[i].getName());
					operator.setId(data[i].getId());
					operator.setUrl(data[i].getUrl());
					populateTransportOperatorInfo(operator);
				}
			}
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
	}

	public void clearCache() {
		cache.clear();
	}

	public List<TransportOperator> getTransportOperators(Segment segment) {
		if (cache.isEmpty()) {
			populateTOs();
		}
		if (!segmentInCache(segment)) {
			getOperatorsInArea(getBoundingBox(segment));
		}
		return cache;
	}

	public TransportOperator getTransportOperator(String id) {
		for (TransportOperator o : cache) {
			if (o.getId().equals(id))
				return o;
		}
		return null;
	}

	private GeojsonPolygon getBoundingBox(Segment segment) {
		GeojsonPolygon p = new GeojsonPolygon();
		double minLng = Double.MAX_VALUE;
		double minLat = Double.MAX_VALUE;
		double maxLng = Double.MIN_VALUE;
		double maxLat = Double.MIN_VALUE;

		double lat = segment.getFrom().getCoordinates().getLat().doubleValue();
		if (lat < minLat)
			minLat = lat;
		if (lat > maxLat)
			maxLat = lat;
		double lng = segment.getFrom().getCoordinates().getLng().doubleValue();
		if (lng < minLng)
			minLng = lng;
		if (lng > maxLng)
			maxLng = lng;
		lat = segment.getTo().getCoordinates().getLat().doubleValue();
		if (lat < minLat)
			minLat = lat;
		if (lat > maxLat)
			maxLat = lat;
		lng = segment.getTo().getCoordinates().getLng().doubleValue();
		if (lng < minLng)
			minLng = lng;
		if (lng > maxLng)
			maxLng = lng;

		GeojsonPoint start = toCoordinates(minLng, minLat);
		p.add(new GeojsonLine());
		p.get(0).add(start);
		p.get(0).add(toCoordinates(minLng, maxLat));
		p.get(0).add(toCoordinates(maxLng, maxLat));
		p.get(0).add(toCoordinates(maxLng, minLat));
		p.get(0).add(start);

		return p;
	}

	private GeojsonPoint toCoordinates(double minLng, double minLat) {
		GeojsonPoint start = new GeojsonPoint();
		start.add((float)(minLng));
		start.add((float)(minLat));
		return start;
	}

	private boolean segmentInCache(Segment segment) {
		if (segment != null) {
			for (TransportOperator operator : cache) {
				for (SystemRegion region : operator.getRegions()) {
					if (isRegion(region, segment.getFrom().getCoordinates())
							|| isRegion(region, segment.getTo().getCoordinates())) {
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

	private boolean isRegion(SystemRegion region, Coordinates coord) {
		double minLng = Double.MAX_VALUE;
		double minLat = Double.MAX_VALUE;
		double maxLng = Double.MIN_VALUE;
		double maxLat = Double.MIN_VALUE;

		for (Coordinates p : GeoUtil.getCoordinatesFromPolygon(region.getServiceArea())) {
			double lat = p.getLat().doubleValue();
			if (lat < minLat)
				minLat = lat;
			if (lat > maxLat)
				maxLat = lat;
			double lng = p.getLng().doubleValue();
			if (lng < minLng)
				minLng = lng;
			if (lng > maxLng)
				maxLng = lng;
		}

		if (coord.getLat().doubleValue() < minLat || coord.getLat().doubleValue() > maxLat
				|| coord.getLng().doubleValue() < minLng || coord.getLng().doubleValue() > maxLng)
			return false;

		return true;
	}

	private void populateTransportOperatorInfo(TransportOperator operator) {
		try {
			getSystemInformation(operator);
			getAssetInformation(operator);
			getRegionInformation(operator);

			cache.add(operator);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		log.info("Fetch info of {}", operator.getName());
	}

	private void getRegionInformation(TransportOperator operator) throws ApiException {
		SystemRegion[] regions = clientUtil.get(operator, "/operator/regions", SystemRegion[].class);
		List<SystemRegion> list = new ArrayList<>();
		Collections.addAll(list, regions);
		operator.setRegions(list);
	}

	private void getAssetInformation(TransportOperator to) throws ApiException {
		AssetType[] assets = clientUtil.get(to, "/operator/available-assets", AssetType[].class);
		for (AssetType assetType : assets) {
			to.getAssetClasses().add(assetType.getAssetClass());
		}
	}

	private void getSystemInformation(TransportOperator to) throws ApiException {
		SystemInformation info = clientUtil.get(to, "/operator/information", SystemInformation.class);
		to.setName(info.getName());
		to.setId(info.getSystemId());
	}
}
