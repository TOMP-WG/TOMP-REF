package io.swagger.configuration;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;

import io.swagger.model.Coordinates;

public class GeometryUtil {
	static GeometryFactory gf = new GeometryFactory();

	private GeometryUtil() {
	}

	public static boolean isInPolygon(List<Coordinates> coords, Coordinates location) {
		Coordinate[] points = convertToJts(coords);
		Polygon polygon = createPolygon(points);
		return polygon.contains(convertToJts(location));
	}

	public static boolean overlaps(List<Coordinates> coords, List<Coordinates> area) {
		Polygon polygon = createPolygon(convertToJts(coords));
		Polygon polygon2 = createPolygon(convertToJts(area));
		return !polygon.intersection(polygon2).isEmpty();
	}

	private static Polygon createPolygon(Coordinate[] points) {
		return gf.createPolygon(points);
	}

	private static Geometry convertToJts(Coordinates location) {
		return gf.createPoint(toCoordinate(location));
	}

	private static Coordinate[] convertToJts(List<Coordinates> coords) {
		int size = coords.size();
		boolean startIsEnd = coords.get(0).equals(coords.get(coords.size() - 1));
		if (!startIsEnd) {
			size += 1;
		}

		Coordinate[] result = new Coordinate[size];
		for (int i = 0; i < size; i++) {
			Coordinates c = coords.get(i);
			result[i] = toCoordinate(c);
		}

		if (!startIsEnd) {
			result[coords.size() - 1] = result[0];
		}
		return result;
	}

	private static Coordinate toCoordinate(Coordinates c) {
		return new Coordinate(c.getLng().doubleValue(), c.getLat().doubleValue());
	}
}
