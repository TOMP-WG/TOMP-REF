package org.tomp.api.planning;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.repository.RegionContainer;
import org.tomp.api.utils.GeoUtil;

import io.swagger.model.Coordinates;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.model.SystemRegion;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "nearStart", matchIfMissing = false)
public class NearStartPlanningProvider extends GenericPlanningProvider {

	static GeometryFactory gf = new GeometryFactory();

	@Autowired
	RegionContainer regionContainer;

	@Override
	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		Point start = gf.createPoint(toCoordinate(body.getFrom().getCoordinates()));
		List<SystemRegion> regions = regionContainer.getRegions();
		for (SystemRegion region : regions) {
			Polygon p = GeoUtil.toPolygon(region.getServiceArea());
			double distance = start.distance(p);
			if (distance < body.getRadius().doubleValue()) {
				return super.getOptions(body, acceptLanguage, bookingIntent);
			}
		}
		return new Planning();
	}

	private Coordinate toCoordinate(@NotNull @Valid Coordinates coordinates) {
		Coordinate c = new Coordinate();
		c.setX(coordinates.getLng().doubleValue());
		c.setY(coordinates.getLat().doubleValue());
		return c;
	}

}
