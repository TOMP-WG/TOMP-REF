package org.tomp.api.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.booking.BookingProvider;
import org.tomp.api.booking.SharedCarBookingProvider;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.PostPonedResult;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.BookingsApiController;
import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingRequest;

@RestController
public class BookingsController extends BookingsApiController {

	@Autowired
	private BookingProvider provider;

	private HttpServletRequest request;

	private ObjectMapper objectMapper;

	@Autowired
	private ExternalConfiguration config;

	@Autowired
	private DefaultRepository repository;

	public BookingsController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	public ResponseEntity<Booking> bookingsPost(
			@ApiParam(value = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "One of available legs, returned by /plannings, with an ID.", required = true) @Valid @RequestBody BookingRequest body)

	// @Override
	// public ResponseEntity<Booking> bookingsPost(
	// @ApiParam(value = "One of available options, returned by /planning-options,
	// with an ID.", required = true) @Valid @RequestBody BookingRequest body,
	// @ApiParam(value = "ISO 639-1 two letter language code", required = true)
	// @RequestHeader(value = "Accept-Language", required = true) String
	// acceptLanguage,
	// @ApiParam(value = "API description, can be TOMP or maybe other
	// (specific/derived) API definitions", required = true) @RequestHeader(value =
	// "Api", required = true) String api,
	// @ApiParam(value = "Version of the API.", required = true)
	// @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
	{

		HeaderValidator.validateHeader(request);

		Booking booking = provider.addNewBooking(body, acceptLanguage);

		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking> bookingsIdEventsPost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "Leg identifier", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody BookingOperation body) {

		HeaderValidator.validateHeader(request);
		provider.setRequest(request);
		Booking booking = provider.addNewBookingEvent(body, acceptLanguage, id);

		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking> bookingsIdGet(String acceptLanguage, String api, String apiVersion, String id) {
		HeaderValidator.validateHeader(request);
		return new ResponseEntity<>(provider.getBooking(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> bookingsIdSubscriptionPost(String acceptLanguage, String api, String apiVersion,
			String id, @Valid Booking body) {
		provider.subscribeToBookings(acceptLanguage, api, apiVersion, id, body);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> bookingsIdSubscriptionDelete(String acceptLanguage, String api, String apiVersion,
			String id) {
		provider.unsubscribeToBookings(acceptLanguage, api, apiVersion, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/postponed/{id}")
	@ResponseBody
	public String respondToPostponedBooking(@PathVariable("id") String id) {
		if (provider instanceof SharedCarBookingProvider) {
			String externalUrl = config.getExternalUrl();
			if (externalUrl.endsWith("/")) {
				externalUrl = externalUrl.substring(0, externalUrl.length() - 1);
			}
			return ((SharedCarBookingProvider) provider).getPostponedBookingHtml(id, externalUrl + "/postponed/");
		}
		return "";
	}

	@PostMapping("/postponed/")
	public String postPostponedBooking(@ModelAttribute PostPonedResult result) {

		if (provider instanceof SharedCarBookingProvider) {
			((SharedCarBookingProvider) provider).saveResult(result.getId(), result.getChoice() == 1,
					result.getRemark());
		}
		try {
			return objectMapper.writeValueAsString(repository.getBooking(result.getId()));
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}
}
