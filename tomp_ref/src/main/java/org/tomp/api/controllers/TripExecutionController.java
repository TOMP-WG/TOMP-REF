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
import io.swagger.api.ExecutionsApiController;
import io.swagger.model.Execution;
import io.swagger.model.ExecutionEvent;

@RestController
public class TripExecutionController extends ExecutionsApiController {

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
	public ResponseEntity<Execution> executionsIdEventsPost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "Leg identifier", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody ExecutionEvent body) {

		HeaderValidator.validateHeader(request);
		Execution leg = null;

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
