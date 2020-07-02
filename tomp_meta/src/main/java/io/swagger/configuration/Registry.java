package io.swagger.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public void registerArea(String id, Object serviceArea) {
		ObjectMapper mapper = new ObjectMapper();
		Polygon polygon = null;
		try {
			polygon = mapper.readValue(serviceArea.toString(), Polygon.class);
		} catch (Exception e) {
		}
		if (polygon == null) {
			try {
				GeojsonPolygon p = mapper.readValue(serviceArea.toString(), GeojsonPolygon.class);
				if (p != null) {
					polygon = toPolygon(p);
				}
			} catch (Exception e) {
			}
		}

		areaMap.put(id, polygon);
	}

	public void registerPolygon(String id, Polygon polygon) {
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
		List<MaasOperator> locations = new ArrayList<>();

		for (Entry<String, Polygon> entry : areaMap.entrySet()) {
			if (points == null || points.isEmpty() || GeometryUtil.overlaps(points, entry.getValue().getPoints())) {
				MaasOperator maasOperator = map.get(entry.getKey());
				locations.add(maasOperator);
			}
		}

		return locations;
	}

}
