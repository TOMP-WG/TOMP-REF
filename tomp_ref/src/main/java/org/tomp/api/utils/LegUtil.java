package org.tomp.api.utils;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import io.swagger.model.OptionsLeg;

@Component
public class LegUtil {

	public double getDuration(OptionsLeg leg) {
		return leg.getEndTime().subtract(leg.getStartTime()).doubleValue();
	}

	public double getDistance(@Valid OptionsLeg leg) {
		return 1000;
	}
}
