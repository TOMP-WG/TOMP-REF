package org.tomp.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.tripexecution.TripExecutionProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.LegsApiController;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;

@RestController
public class TripExecutionController extends LegsApiController {

	@Autowired
	TripExecutionProvider provider;

	private HttpServletRequest request;

	private ObjectMapper objectMapper;

	public TripExecutionController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	@Override
	public ResponseEntity<Leg> legsIdEventsPost(
			@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "Leg identifier", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody LegEvent body) {

		HeaderValidator.validateHeader(request);
		Leg leg = null;

		String maasId = request.getHeader("maas-id");
		switch (body.getEvent()) {
		case ASSIGN_ASSET:
			leg = provider.assignAsset(body, acceptLanguage, id, maasId);
			break;
		case FINISH:
			leg = provider.finish(body, acceptLanguage, id, maasId);
			break;
		case ISSUE:
			break;
		case PAUSE:
			leg = provider.pause(body, acceptLanguage, id, maasId);
			break;
		case PREPARE:
			leg = provider.prepare(body, acceptLanguage, id, maasId);
			break;
		case SET_IN_USE:
			leg = provider.setInUse(body, acceptLanguage, id, maasId);
			break;
		case START_FINISHING:
			leg = provider.startFinishing(body, acceptLanguage, id, maasId);
			break;
		default:
			break;

		}

		return new ResponseEntity<>(leg, HttpStatus.CREATED);
	}
}
