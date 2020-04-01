package org.tomp.api.planning;

import javax.validation.Valid;

import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;

public interface PlanningProvider {

	PlanningOptions getOptions(@Valid PlanningCheck body, String acceptLanguage);

}
