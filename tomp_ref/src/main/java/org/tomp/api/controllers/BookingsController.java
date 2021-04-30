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
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

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

	@Override
	public ResponseEntity<Booking> bookingsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.DEFAULT, description = "One of available booking options, returned by /plannings, with an ID.", required = true, schema = @Schema()) @Valid @RequestBody BookingRequest body,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
		HeaderValidator.validateHeader(request);

		Booking booking = provider.addNewBooking(body, acceptLanguage);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking> bookingsIdEventsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody BookingOperation body) {

		HeaderValidator.validateHeader(request);
		provider.setRequest(request);
		Booking booking = provider.addNewBookingEvent(body, acceptLanguage, id);

		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Booking> bookingsIdGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
		HeaderValidator.validateHeader(request);
		return new ResponseEntity<>(provider.getBooking(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> bookingsIdSubscriptionPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
		provider.subscribeToBookings(acceptLanguage, api, apiVersion, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> bookingsIdSubscriptionDelete(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.PATH, description = "Booking identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
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
