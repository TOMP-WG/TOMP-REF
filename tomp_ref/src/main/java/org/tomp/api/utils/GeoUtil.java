package org.tomp.api.utils;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.tomp.api.model.parking.LonLatLocation;

import io.swagger.model.Coordinates;
import io.swagger.model.Polygon;

public class GeoUtil {

	private GeoUtil() {
	}

	public static boolean isNearby(@NotNull @Valid Coordinates coordinates, @NotNull @Valid Coordinates coordinates2,
			@Valid double meters) {
		float distance = distFrom(coordinates.getLat().floatValue(), coordinates.getLng().floatValue(),
				coordinates2.getLat().floatValue(), coordinates2.getLng().floatValue());
		return distance < meters;
	}

	private static float distFrom(float lat1, float lng1, float lat2, float lng2) {
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

	public static Polygon toPolygon(LonLatLocation location, double radius) {
		Polygon p = new Polygon();
		BigDecimal r = BigDecimal.valueOf(radius);
		Coordinates pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().add(r));
		pointsItem.setLng(location.getLongitude().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().add(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);
		return p;
	}

	public static Polygon toPolygon(Coordinates location, double radius) {
		Polygon p = new Polygon();
		BigDecimal r = BigDecimal.valueOf(radius);
		Coordinates pointsItem = new Coordinates();
		pointsItem.setLat(location.getLat().subtract(r));
		pointsItem.setLng(location.getLng().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLat().subtract(r));
		pointsItem.setLng(location.getLng().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLat().add(r));
		pointsItem.setLng(location.getLng().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLat().add(r));
		pointsItem.setLng(location.getLng().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLat().subtract(r));
		pointsItem.setLng(location.getLng().subtract(r));
		p.addPointsItem(pointsItem);
		return p;
	}
}
