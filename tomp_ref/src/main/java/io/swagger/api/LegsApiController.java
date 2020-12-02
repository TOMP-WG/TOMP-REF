package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Asset;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegProgress;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")
@RestController
public class LegsApiController implements LegsApi {

	private static final Logger log = LoggerFactory.getLogger(LegsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public LegsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<List<Asset>> legsIdAvailableAssetsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Asset>>(objectMapper.readValue(
						"[ {\n  \"overriddenProperties\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 1,\n    \"cabrio\" : true,\n    \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n    \"buildingYear\" : 6,\n    \"stateOfCharge\" : 56,\n    \"co2PerKm\" : 0.8008281904610115,\n    \"propulsion\" : \"MUSCLE\",\n    \"infantSeat\" : true,\n    \"persons\" : 1,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : \"\",\n    \"name\" : \"name\",\n    \"location\" : {\n      \"name\" : \"name\",\n      \"coordinates\" : {\n        \"lng\" : 6.169639,\n        \"lat\" : 52.253279\n      },\n      \"physicalAddress\" : {\n        \"areaReference\" : \"Smallcity, Pinetree county\",\n        \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n        \"postalCode\" : \"postalCode\"\n      },\n      \"stopReference\" : [ {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      }, {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      } ],\n      \"stationId\" : \"stationId\",\n      \"extraInfo\" : \"\"\n    }\n  },\n  \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n  \"isReserved\" : true,\n  \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"isDisabled\" : true,\n  \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n  \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n  \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"overriddenProperties\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 1,\n    \"cabrio\" : true,\n    \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n    \"buildingYear\" : 6,\n    \"stateOfCharge\" : 56,\n    \"co2PerKm\" : 0.8008281904610115,\n    \"propulsion\" : \"MUSCLE\",\n    \"infantSeat\" : true,\n    \"persons\" : 1,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : \"\",\n    \"name\" : \"name\",\n    \"location\" : {\n      \"name\" : \"name\",\n      \"coordinates\" : {\n        \"lng\" : 6.169639,\n        \"lat\" : 52.253279\n      },\n      \"physicalAddress\" : {\n        \"areaReference\" : \"Smallcity, Pinetree county\",\n        \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n        \"postalCode\" : \"postalCode\"\n      },\n      \"stopReference\" : [ {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      }, {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      } ],\n      \"stationId\" : \"stationId\",\n      \"extraInfo\" : \"\"\n    }\n  },\n  \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n  \"isReserved\" : true,\n  \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"id\" : \"id\",\n  \"isDisabled\" : true,\n  \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n  \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n  \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Asset>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Asset>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Leg> legsIdEventsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody LegEvent body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Leg>(objectMapper.readValue(
						"{\n  \"departureTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"progressGeometry\" : \"\",\n  \"distance\" : 7250,\n  \"ticket\" : \"\",\n  \"legSequenceNumber\" : 0,\n  \"travelerReferenceNumbers\" : [ \"travelerReferenceNumbers\", \"travelerReferenceNumbers\" ],\n  \"suboperator\" : {\n    \"maasId\" : \"maasId\",\n    \"contact\" : \"contact\",\n    \"name\" : \"name\",\n    \"description\" : \"description\"\n  },\n  \"departureDelay\" : 11112,\n  \"assetAccessData\" : \"\",\n  \"assetType\" : \"\",\n  \"arrivalTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"from\" : \"\",\n  \"id\" : \"id\",\n  \"to\" : \"\",\n  \"state\" : \"NOT_STARTED\",\n  \"asset\" : \"\",\n  \"conditions\" : [ {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  }, {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  } ],\n  \"pricing\" : \"\"\n}",
						Leg.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Leg>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Leg>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Leg> legsIdGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Leg>(objectMapper.readValue(
						"{\n  \"departureTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"progressGeometry\" : \"\",\n  \"distance\" : 7250,\n  \"ticket\" : \"\",\n  \"legSequenceNumber\" : 0,\n  \"travelerReferenceNumbers\" : [ \"travelerReferenceNumbers\", \"travelerReferenceNumbers\" ],\n  \"suboperator\" : {\n    \"maasId\" : \"maasId\",\n    \"contact\" : \"contact\",\n    \"name\" : \"name\",\n    \"description\" : \"description\"\n  },\n  \"departureDelay\" : 11112,\n  \"assetAccessData\" : \"\",\n  \"assetType\" : \"\",\n  \"arrivalTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"from\" : \"\",\n  \"id\" : \"id\",\n  \"to\" : \"\",\n  \"state\" : \"NOT_STARTED\",\n  \"asset\" : \"\",\n  \"conditions\" : [ {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  }, {\n    \"conditionType\" : \"conditionType\",\n    \"id\" : \"deposit50eu\"\n  } ],\n  \"pricing\" : \"\"\n}",
						Leg.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Leg>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Leg>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<LegProgress> legsIdProgressGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.QUERY, description = "Specifies if only the location should be returned", schema = @Schema(defaultValue = "false")) @Valid @RequestParam(value = "location-only", required = false, defaultValue = "false") Boolean locationOnly) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<LegProgress>(objectMapper.readValue(
						"{\n  \"duration\" : 11112,\n  \"distance\" : 7250,\n  \"coordinates\" : {\n    \"lng\" : 6.169639,\n    \"lat\" : 52.253279\n  }\n}",
						LegProgress.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<LegProgress>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<LegProgress>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> legsIdProgressPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody LegProgress body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> legsIdPut(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "changed leg (e.g. with different duration or destination)", required = true, schema = @Schema()) @Valid @RequestBody Leg body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
