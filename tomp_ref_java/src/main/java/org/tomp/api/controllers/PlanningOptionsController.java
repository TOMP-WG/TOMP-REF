package org.tomp.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.planning.PlanningProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.PlanningOptionsApiController;
import io.swagger.model.PlanningCheck;
import io.swagger.model.PlanningOptions;

@RestController
public class PlanningOptionsController extends PlanningOptionsApiController {

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
	public ResponseEntity<PlanningOptions> planningOptionsPost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "") @Valid @RequestBody PlanningCheck body) {

		HeaderValidator.validateHeader(request);

		PlanningOptions options = planningProvider.getOptions(body, acceptLanguage);
		return new ResponseEntity<>(options, HttpStatus.CREATED);
	}
}
