package io.swagger.configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Coordinates;
import io.swagger.model.GeojsonLine;
import io.swagger.model.GeojsonPoint;
import io.swagger.model.GeojsonPolygon;
import io.swagger.model.MaasOperator;
import io.swagger.model.Polygon;

@Component
public class Registry {
	private static final Logger log = LoggerFactory.getLogger(Registry.class);

	private Map<String, MaasOperator> map = new HashMap<>();
	private Map<String, String> tokens = new HashMap<>();
	private Map<String, Polygon> areaMap = new HashMap<>();

	public void register(MaasOperator operator) {
		map.put(operator.getId(), operator);
		tokens.put(operator.getId(), operator.getValidationToken());
		operator.setValidationToken("");
		registerArea(operator.getId(), operator.getServicedArea());
	}

	public MaasOperator get(String id) {
		return map.get(id);
	}

	public String getToken(String id) {
		return tokens.get(id);
	}

	@SuppressWarnings("rawtypes")
	public void registerArea(String id, Object serviceArea) {

		ObjectMapper mapper = new ObjectMapper();
		Polygon polygon = null;

		if (serviceArea instanceof LinkedHashMap) {
			// <= V 0.6
			LinkedHashMap map = (LinkedHashMap) serviceArea;
			Object points = map.get("points");
			@SuppressWarnings("unchecked")
			ArrayList<LinkedHashMap> list = (ArrayList<LinkedHashMap>) points;
			polygon = new Polygon();

			for (LinkedHashMap x : list) {
				Double lon = (Double) x.get("lng");
				Double lat = (Double) x.get("lat");
				Coordinates pointsItem = new Coordinates();
				pointsItem.setLat(BigDecimal.valueOf(lat));
				pointsItem.setLng(BigDecimal.valueOf(lon));
				polygon.addPointsItem(pointsItem);
			}
		} else {
			try {
				polygon = mapper.readValue(serviceArea.toString(), Polygon.class);
			} catch (Exception e) {
				log.warn("Unknown area format {} {}", serviceArea, e);
			}
			if (polygon == null) {
				try {
					GeojsonPolygon p = mapper.readValue(serviceArea.toString(), GeojsonPolygon.class);
					if (p != null) {
						polygon = toPolygon(p);
					}
				} catch (Exception e) {
					log.error("Unknown area format {} {}", serviceArea, e);
				}
			}
		}
		registerPolygon(id, polygon);
	}

	public void registerPolygon(String id, Polygon polygon) {
		log.info("Registered {} with area {}", id, polygon);
		areaMap.put(id, polygon);
	}

	private Polygon toPolygon(GeojsonPolygon p) {
		Polygon polygon = new Polygon();
		for (GeojsonLine line : p) {
			for (GeojsonPoint point : line) {
				Coordinates pointsItem = new Coordinates();
				pointsItem.setLng(point.get(0));
				pointsItem.setLat(point.get(1));
				polygon.addPointsItem(pointsItem);
			}
		}
		return polygon;
	}

	public boolean isInArea(String id, Coordinates location) {
		Polygon polygon = areaMap.get(id);
		return GeometryUtil.isInPolygon(polygon.getPoints(), location);
	}

	public List<MaasOperator> getOperators(List<Coordinates> points) {
		log.info("Retrieving operators");
		List<MaasOperator> locations = new ArrayList<>();

		for (Entry<String, Polygon> entry : areaMap.entrySet()) {
			if (entry != null) {
				log.info("test {} {}", entry.getKey(), entry.getValue());
				if (points == null || points.isEmpty() || GeometryUtil.overlaps(points, entry.getValue().getPoints())) {
					MaasOperator maasOperator = map.get(entry.getKey());
					maasOperator.setServicedArea(null);
					locations.add(maasOperator);
				}
			}
		}

		return locations;
	}

}
