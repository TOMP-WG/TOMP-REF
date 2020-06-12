package org.tomp.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.planning.PlanningProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.PlanningsApiController;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;

@RestController
public class PlanningOptionsController extends PlanningsApiController {

	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	private @Autowired PlanningProvider planningProvider;

	public PlanningOptionsController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
		this.objectMapper.setVisibility(objectMapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	@Override
	public ResponseEntity<Planning> planningsPost(String acceptLanguage, String api, String apiVersion,
			@Valid PlanningRequest body, @Valid Boolean bookingIntent) {

		HeaderValidator.validateHeader(request);

		Planning options = planningProvider.getOptions(body, acceptLanguage, bookingIntent.booleanValue());
		return new ResponseEntity<>(options, HttpStatus.CREATED);
	}

}
