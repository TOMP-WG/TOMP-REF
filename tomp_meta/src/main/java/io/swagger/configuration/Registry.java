package io.swagger.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import io.swagger.model.Coordinates;
import io.swagger.model.MaasLocation;
import io.swagger.model.MaasOperator;
import io.swagger.model.Polygon;

@Component
public class Registry {

	private Map<String, MaasOperator> map = new HashMap<>();
	private Map<String, Polygon> areaMap = new HashMap<>();

	public void register(MaasOperator operator) {
		map.put(operator.getId(), operator);
	}

	public MaasOperator get(String id) {
		return map.get(id);
	}

	public void registerArea(String id, Polygon serviceArea) {
		areaMap.put(id, serviceArea);
	}

	public boolean isInArea(String id, Coordinates location) {
		Polygon polygon = areaMap.get(id);
		return GeometryUtil.isInPolygon(polygon.getPoints(), location);
	}

	public List<MaasLocation> getLocations(List<Coordinates> points) {
		List<MaasLocation> locations = new ArrayList<>();

		for (Entry<String, Polygon> entry : areaMap.entrySet()) {
			if (GeometryUtil.overlaps(points, entry.getValue().getPoints())) {
				MaasOperator maasOperator = map.get(entry.getKey());
				locations.add(maasOperator);
			}
		}

		return locations;
	}
}
