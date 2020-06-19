package org.tomp.api.planning;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

@Component
@ConditionalOnProperty(value = "tomp.providers.planning", havingValue = "none", matchIfMissing = false)
public class NoPlanningProvider implements PlanningProvider {

	@Override
	public Planning getOptions(@Valid PlanningRequest body, String acceptLanguage, boolean bookingIntent) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

}
