package org.tomp.api.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.operatorinformation.OperatorInformationProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
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
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			List<AssetType> list = provider.getAvailableAssetTypes(acceptLanguage);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorAvailableAssetsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<SystemInformation> operatorInformationGet(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getOperatorInformation(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorInformationGet", e);

			throw e;
		}
	}

	@Override
	public ResponseEntity<List<StationInformation>> operatorStationsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId) {

		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getStations(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorStationsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemRegion>> operatorRegionsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit) {

		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getRegions(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getPricingPlans(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {

		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getHours(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getCalendar(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<EndpointImplementation>> operatorMetaGet(String acceptLanguage) {
		HeaderValidator.validateHeader(request);

		try {
			return new ResponseEntity<>(provider.getMeta(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}
}
