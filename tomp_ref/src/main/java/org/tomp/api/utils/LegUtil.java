package org.tomp.api.utils;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.threeten.bp.temporal.ChronoUnit;

import io.swagger.model.Coordinates;
import io.swagger.model.Leg;

@Component
public class LegUtil {

	private static final Logger log = LoggerFactory.getLogger(LegUtil.class);

	/*
	 * Duration in seconds
	 */
	public Integer getDuration(Leg leg) {
		if (leg.getDepartureTime() != null && leg.getArrivalTime() != null) {
			return (int)ChronoUnit.MINUTES.between(leg.getDepartureTime(), leg.getArrivalTime());
		}
		// avg 30 km/h => 30000 m/h => 30000/3600 = 8.3 m/s
		double duration = getDistance(leg) / 8.3;
		log.info("Duration (seconds): {}", duration);
		return (int)duration;
	}

	/*
	 * Straight line distance
	 */
	public double getDistance(@Valid Leg leg) {
		Coordinates from = leg.getFrom().getCoordinates();
		Coordinates to = leg.getTo().getCoordinates();
		float distance = GeoUtil.distanceInMeters(from.getLat().floatValue(), from.getLng().floatValue(),
				to.getLat().floatValue(), to.getLng().floatValue());
		log.info("Distance (meters): {}", distance);
		return (double) distance;
	}
}
