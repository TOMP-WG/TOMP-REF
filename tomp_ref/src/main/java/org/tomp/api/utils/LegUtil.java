package org.tomp.api.utils;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.threeten.bp.temporal.ChronoUnit;

import io.swagger.model.Leg;

@Component
public class LegUtil {

	public double getDuration(Leg leg) {
		return ChronoUnit.MILLIS.between(leg.getDepartureTime(), leg.getArrivalTime());
	}

	public double getDistance(@Valid Leg leg) {
		return 1000;
	}
}
