package org.tomp.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.planning.PlanningProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.PlanningsApiController;
import io.swagger.model.Planning;
import io.swagger.model.PlanningRequest;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

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
	public ResponseEntity<Planning> planningsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "Specifies whether IDs should be returned for the leg options that can be referred to when booking", schema = @Schema(defaultValue = "false")) @Valid @RequestParam(value = "booking-intent", required = false, defaultValue = "false") Boolean bookingIntent,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody PlanningRequest body) {
		HeaderValidator.validateHeader(request);

		Planning options = planningProvider.getOptions(body, acceptLanguage, bookingIntent.booleanValue());
		return new ResponseEntity<>(options, HttpStatus.CREATED);
	}

}
