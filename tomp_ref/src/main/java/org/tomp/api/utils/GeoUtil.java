package org.tomp.api.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.tomp.api.model.parking.LonLatLocation;

import io.swagger.model.Coordinates;
import io.swagger.model.GeojsonLine;
import io.swagger.model.GeojsonPoint;
import io.swagger.model.GeojsonPolygon;

public class GeoUtil {

	static GeometryFactory gf = new GeometryFactory();

	private GeoUtil() {
	}

	public static boolean isNearby(@NotNull @Valid Coordinates coordinates, @NotNull @Valid Coordinates coordinates2,
			@Valid double meters) {
		float distance = distanceInMeters(coordinates.getLat().floatValue(), coordinates.getLng().floatValue(),
				coordinates2.getLat().floatValue(), coordinates2.getLng().floatValue());
		return distance < meters;
	}

	/* Distance in meters
	 * */
	public static float distanceInMeters(float lat1, float lng1, float lat2, float lng2) {
		double earthRadius = 6371000; // meters
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (float) (earthRadius * c);
	}

	public static Coordinates toCoordinates(double lat, double lng) {
		Coordinates c = new Coordinates();
		c.setLat(BigDecimal.valueOf(lat));
		c.setLng(BigDecimal.valueOf(lng));
		return c;
	}

	public static GeojsonPolygon toPolygon(LonLatLocation location, double radius) {
		Coordinates c = new Coordinates();
		c.setLng(location.getLongitude());
		c.setLat(location.getLatitude());
		return toPolygon(c, radius);
	}

	public static void addPoint(GeojsonPolygon polygon, BigDecimal lng, BigDecimal lat) {
		if (polygon.isEmpty()) {
			polygon.add(new GeojsonLine());
		}
		GeojsonPoint e = new GeojsonPoint();
		e.add(lng);
		e.add(lat);
		polygon.get(0).add(e);
	}

	public static void addPoint(GeojsonPolygon polygon, double lng, double lat) {
		addPoint(polygon, BigDecimal.valueOf(lng), BigDecimal.valueOf(lat));
	}

	public static GeojsonPolygon toPolygon(Coordinates location, double radius) {
		GeojsonPolygon p = new GeojsonPolygon();

		BigDecimal r = BigDecimal.valueOf(radius);

		addPoint(p, location.getLng().subtract(r), location.getLat().subtract(r));
		addPoint(p, location.getLng().add(r), location.getLat().subtract(r));
		addPoint(p, location.getLng().add(r), location.getLat().add(r));
		addPoint(p, location.getLng().subtract(r), location.getLat().add(r));
		addPoint(p, location.getLng().subtract(r), location.getLat().subtract(r));

		return p;
	}

	public static Envelope getBoundingBox(Geometry geometry) {
		final Envelope envelope = new Envelope();
		final Geometry enclosingGeometry = geometry.getEnvelope();
		final Coordinate[] enclosingCoordinates = enclosingGeometry.getCoordinates();
		for (Coordinate c : enclosingCoordinates) {
			envelope.expandToInclude(c);
		}
		return envelope;
	}

	public static org.locationtech.jts.geom.Polygon toPolygon(GeojsonPolygon serviceArea) {
		List<Coordinate> points = new ArrayList<>();
		for (GeojsonPoint coordinate : serviceArea.get(0)) {
			points.add(toCoordinate(coordinate));
		}
		return gf.createPolygon(points.toArray(new Coordinate[] {}));
	}

	private static Coordinate toCoordinate(@NotNull @Valid GeojsonPoint coordinates) {
		Coordinate c = new Coordinate();
		c.setX(coordinates.get(0).doubleValue());
		c.setY(coordinates.get(1).doubleValue());
		return c;
	}

	public static List<Coordinates> getCoordinatesFromPolygon(@Valid GeojsonPolygon serviceArea) {
		List<Coordinates> coordinates = new ArrayList<>();
		for (GeojsonLine line : serviceArea) {
			List<Coordinates> points = line.stream().map(point -> {
				Coordinates c = new Coordinates();
				c.setLng(point.get(0));
				c.setLat(point.get(1));
				return c;
			}).collect(Collectors.toList());
			coordinates.addAll(points);
		}
		return coordinates;
	}
}
