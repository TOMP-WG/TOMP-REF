package org.tomp.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.tomp.api.operatorinformation.OperatorInformationProvider;
import org.tomp.api.utils.HeaderValidator;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.api.OperatorApiController;
import io.swagger.model.AssetType;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;

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
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
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
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {

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
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {

		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getRegions(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(String acceptLanguage, String api,
			String apiVersion) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getPricingPlans(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(String acceptLanguage, String api,
			String apiVersion) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getHours(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}

	@Override
	public ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(String acceptLanguage, String api,
			String apiVersion) {
		HeaderValidator.validateHeader(request);
		try {
			return new ResponseEntity<>(provider.getCalendar(acceptLanguage), HttpStatus.OK);
		} catch (Exception e) {
			log.error("operatorRegionsGet", e);
			throw e;
		}
	}
}
