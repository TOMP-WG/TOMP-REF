package org.tomp.api.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.operatorinformation.OperatorInformationProvider;
import org.tomp.api.utils.HeaderValidator;
import org.tomp.api.utils.RouterUtil;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.OperatorApiController;
import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class OperatorInformationController extends OperatorApiController {

	private static final Logger log = LoggerFactory.getLogger(OperatorInformationController.class);

	@Autowired
	private OperatorInformationProvider provider;

	@Autowired
	private RouterUtil routerUtil;

	private HttpServletRequest request;
	private ObjectMapper objectMapper;

	public OperatorInformationController(ObjectMapper objectMapper, HttpServletRequest request) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	@Override
	public ResponseEntity<List<AssetType>> operatorAvailableAssetsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			List<AssetType> list = provider.getAvailableAssetTypes(acceptLanguage);
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/available-assets", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(list, headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorAvailableAssetsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<SystemInformation> operatorInformationGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
		HeaderValidator.validateHeader(request);
		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/information", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getOperatorInformation(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorInformationGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<StationInformation>> operatorStationsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "the longitude of the search location (WGS84)", schema = @Schema()) @Valid @RequestParam(value = "lon", required = false) BigDecimal lon,
			@Parameter(in = ParameterIn.QUERY, description = "the latitude of the search location (WGS84)", schema = @Schema()) @Valid @RequestParam(value = "lat", required = false) BigDecimal lat,
			@Parameter(in = ParameterIn.QUERY, description = "the range in meters from the search location to look for stations", schema = @Schema()) @Valid @RequestParam(value = "radius", required = false) BigDecimal radius) {

		HeaderValidator.validateHeader(request);
		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/stations", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getStations(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorStationsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<SystemRegion>> operatorRegionsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit) {

		HeaderValidator.validateHeader(request);
		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/regions", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getRegions(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/pricing-plans", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getPricingPlans(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = false, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = false, schema = @Schema()) @RequestHeader(value = "Api", required = false) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = false) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = false) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {

		log.info("GET /operator/operating-hours");
		// HeaderValidator.validateHeader(request);
		log.info("GET /operator/operating-hours - headers validated");
		try {
			
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/operating-hours", null,
					request.getHeader("MPID"));
			log.info("GET /operator/operating-hours - return headers created");
			return new ResponseEntity<>(provider.getHours(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/operating-calendar", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getCalendar(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<EndpointImplementation>> operatorMetaGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the sending maas operator", required = true, schema = @Schema()) @RequestHeader(value = "maas-id", required = true) String maasId,
			@Parameter(in = ParameterIn.HEADER, description = "The ID of the maas operator that has to receive this message", schema = @Schema()) @RequestHeader(value = "addressed-to", required = false) String addressedTo) {
		HeaderValidator.validateHeader(request);

		try {
			HttpHeaders headers = routerUtil.createHeadersToMP("GET", "/operator/meta", null,
					request.getHeader("MPID"));
			return new ResponseEntity<>(provider.getMeta(acceptLanguage), headers, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
