package org.tomp.api.planning;

import javax.validation.Valid;

import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

public interface PlanningProvider {

	Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent);

}
