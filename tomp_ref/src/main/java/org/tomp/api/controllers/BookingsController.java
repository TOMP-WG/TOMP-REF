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
import org.tomp.api.booking.BookingProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.BookingsApiController;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;

@RestController
public class BookingsController extends BookingsApiController {

	@Autowired
	private BookingProvider provider;

	private HttpServletRequest request;

	private ObjectMapper objectMapper;

	public BookingsController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	public ResponseEntity<Booking> bookingsPost(
			@ApiParam(value = "One of available options, returned by /planning-options, with an ID.", required = true) @Valid @RequestBody BookingOption body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {

		HeaderValidator.validateHeader(request);

		Booking booking = provider.addNewBooking(body, acceptLanguage);

		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	public ResponseEntity<Booking> bookingsIdEventsPost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "Leg identifier", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody BookingOperation body) {

		HeaderValidator.validateHeader(request);

		Booking booking = provider.addNewBookingEvent(body, acceptLanguage, id);

		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
}
