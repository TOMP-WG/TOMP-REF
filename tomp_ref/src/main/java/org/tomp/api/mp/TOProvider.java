package org.tomp.api.mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.LookupService;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.model.Segment;
import org.tomp.api.model.TransportOperator;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.ObjectFromFileProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;
import io.swagger.model.Coordinates;
import io.swagger.model.Polygon;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemRegion;
import io.swagger.model.TypeOfAsset;

@Component
@Profile("maasprovider")
public class TOProvider {

	private static final Logger log = LoggerFactory.getLogger(TOProvider.class);

	private ExternalConfiguration configuration;
	private ObjectMapper mapper;
	private ClientUtil clientUtil;
	private LookupService lookupService;
	List<TransportOperator> cache = new ArrayList<>();

	@Autowired
	public TOProvider(ExternalConfiguration configuration, ObjectMapper mapper, ClientUtil clientUtil,
			LookupService lookupService) {
		this.configuration = configuration;
		this.mapper = mapper;
		this.clientUtil = clientUtil;
		this.lookupService = lookupService;
	}

	@PostConstruct
	public void registrateWithMeta() {
		if (configuration.getExternalUrl() != null) {
			populateTOs();
		}
	}

	private void populateTOs() {
		ObjectFromFileProvider<Polygon> areaProvider = new ObjectFromFileProvider<>();
		Polygon area = areaProvider.getObject("", Polygon.class, configuration.getAreaFile());
		try {
			addTOsFromAreaToCache(area);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
	}

	private void addTOsFromAreaToCache(Polygon area) throws JsonProcessingException {
		Object body = "{\"area\": " + mapper.writeValueAsString(area) + "}";
		MaasOperator[] data = lookupService.callEndpoint("POST", "/transport-operators", body, MaasOperator[].class);
		for (int i = 0; i < data.length; i++) {
			TransportOperator operator = new TransportOperator();
			operator.setUrl(data[i].getUrl());
			populateTransportOperatorInfo(operator);
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
			try {
				addTOsForSegment(segment);
			} catch (JsonProcessingException e) {
				log.error(e.getMessage());
			}
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

	private void addTOsForSegment(Segment segment) throws JsonProcessingException {
		Polygon polygon = getBoundingBox(segment);
		addTOsFromAreaToCache(polygon);
	}

	private Polygon getBoundingBox(Segment segment) {
		Polygon p = new Polygon();
		double minLng = Double.MAX_VALUE;
		double minLat = Double.MAX_VALUE;
		double maxLng = Double.MIN_VALUE;
		double maxLat = Double.MIN_VALUE;

		double lat = segment.getFrom().getLat().doubleValue();
		if (lat < minLat)
			minLat = lat;
		if (lat > maxLat)
			maxLat = lat;
		double lng = segment.getFrom().getLng().doubleValue();
		if (lng < minLng)
			minLng = lng;
		if (lng > maxLng)
			maxLng = lng;
		lat = segment.getTo().getLat().doubleValue();
		if (lat < minLat)
			minLat = lat;
		if (lat > maxLat)
			maxLat = lat;
		lng = segment.getTo().getLng().doubleValue();
		if (lng < minLng)
			minLng = lng;
		if (lng > maxLng)
			maxLng = lng;

		Coordinates start = toCoordinates(minLng, minLat);
		p.addPointsItem(start);
		p.addPointsItem(toCoordinates(minLng, maxLat));
		p.addPointsItem(toCoordinates(maxLng, maxLat));
		p.addPointsItem(toCoordinates(maxLng, minLat));
		p.addPointsItem(start);

		return p;
	}

	private Coordinates toCoordinates(double minLng, double minLat) {
		Coordinates start = new Coordinates();
		start.setLat(BigDecimal.valueOf(minLat));
		start.setLng(BigDecimal.valueOf(minLng));
		return start;
	}

	private boolean segmentInCache(Segment segment) {
		if (segment != null) {
			for (TransportOperator operator : cache) {
				for (SystemRegion region : operator.getRegions()) {
					if (isRegion(region, segment.getFrom()) || isRegion(region, segment.getTo())) {
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

		for (Coordinates p : region.getServiceArea().getPoints()) {
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
	}

	private void getRegionInformation(TransportOperator operator) throws ApiException {
		SystemRegion[] regions = clientUtil.get(operator, "/operator/regions", SystemRegion[].class);
		List<SystemRegion> list = new ArrayList<>();
		Collections.addAll(list, regions);
		operator.setRegions(list);
	}

	private void getAssetInformation(TransportOperator to) throws ApiException {
		TypeOfAsset[] assets = clientUtil.get(to, "/operator/available-assets", TypeOfAsset[].class);
		for (TypeOfAsset assetType : assets) {
			to.getAssetClasses().add(assetType.getAssetClass());
		}
	}

	private void getSystemInformation(TransportOperator to) throws ApiException {
		SystemInformation info = clientUtil.get(to, "/operator/information", SystemInformation.class);
		to.setName(info.getName());
		to.setId(info.getSystemId());
	}
}
