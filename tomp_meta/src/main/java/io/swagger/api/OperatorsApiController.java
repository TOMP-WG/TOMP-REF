package io.swagger.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Body;
import io.swagger.model.MaasOperator;
import io.swagger.model.SearchCondition;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-18T13:26:56.839Z[GMT]")
//@Controller
public class OperatorsApiController implements OperatorsApi {

	private static final Logger log = LoggerFactory.getLogger(OperatorsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public OperatorsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<MaasOperator> operatorsAuthenticatePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "id", required = true) String id,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<MaasOperator>(objectMapper.readValue(
						"{\n  \"supportedVersions\" : [ {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  }, {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  } ],\n  \"validationToken\" : \"validationToken\",\n  \"nation\" : {\n    \"path\" : \"path\",\n    \"method\" : \"POST\",\n    \"status\" : \"NOT_IMPLEMENTED\"\n  },\n  \"name\" : \"name\",\n  \"servicedArea\" : {\n    \"points\" : [ {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    }, {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    } ]\n  },\n  \"transactionProvider\" : \"transactionProvider\",\n  \"id\" : \"id\",\n  \"type\" : \"TO\",\n  \"url\" : \"http://example.com/aeiou\"\n}",
						MaasOperator.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MaasOperator>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<MaasOperator> operatorsIdGet(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<MaasOperator>(objectMapper.readValue(
						"{\n  \"supportedVersions\" : [ {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  }, {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  } ],\n  \"validationToken\" : \"validationToken\",\n  \"nation\" : {\n    \"path\" : \"path\",\n    \"method\" : \"POST\",\n    \"status\" : \"NOT_IMPLEMENTED\"\n  },\n  \"name\" : \"name\",\n  \"servicedArea\" : {\n    \"points\" : [ {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    }, {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    } ]\n  },\n  \"transactionProvider\" : \"transactionProvider\",\n  \"id\" : \"id\",\n  \"type\" : \"TO\",\n  \"url\" : \"http://example.com/aeiou\"\n}",
						MaasOperator.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MaasOperator>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<MaasOperator> operatorsIdPut(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody MaasOperator body,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<MaasOperator>(objectMapper.readValue(
						"{\n  \"supportedVersions\" : [ {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  }, {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  } ],\n  \"validationToken\" : \"validationToken\",\n  \"nation\" : {\n    \"path\" : \"path\",\n    \"method\" : \"POST\",\n    \"status\" : \"NOT_IMPLEMENTED\"\n  },\n  \"name\" : \"name\",\n  \"servicedArea\" : {\n    \"points\" : [ {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    }, {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    } ]\n  },\n  \"transactionProvider\" : \"transactionProvider\",\n  \"id\" : \"id\",\n  \"type\" : \"TO\",\n  \"url\" : \"http://example.com/aeiou\"\n}",
						MaasOperator.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MaasOperator>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<MaasOperator>> operatorsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody SearchCondition body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<MaasOperator>>(objectMapper.readValue(
						"[ {\n  \"supportedVersions\" : [ {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  }, {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  } ],\n  \"validationToken\" : \"validationToken\",\n  \"nation\" : {\n    \"path\" : \"path\",\n    \"method\" : \"POST\",\n    \"status\" : \"NOT_IMPLEMENTED\"\n  },\n  \"name\" : \"name\",\n  \"servicedArea\" : {\n    \"points\" : [ {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    }, {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    } ]\n  },\n  \"transactionProvider\" : \"transactionProvider\",\n  \"id\" : \"id\",\n  \"type\" : \"TO\",\n  \"url\" : \"http://example.com/aeiou\"\n}, {\n  \"supportedVersions\" : [ {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  }, {\n    \"endpoints\" : [ null, null ],\n    \"scenarios\" : [ \"POSTPONED_COMMIT\", \"POSTPONED_COMMIT\" ],\n    \"version\" : \"version\"\n  } ],\n  \"validationToken\" : \"validationToken\",\n  \"nation\" : {\n    \"path\" : \"path\",\n    \"method\" : \"POST\",\n    \"status\" : \"NOT_IMPLEMENTED\"\n  },\n  \"name\" : \"name\",\n  \"servicedArea\" : {\n    \"points\" : [ {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    }, {\n      \"lng\" : 6.169639,\n      \"lat\" : 52.253279\n    } ]\n  },\n  \"transactionProvider\" : \"transactionProvider\",\n  \"id\" : \"id\",\n  \"type\" : \"TO\",\n  \"url\" : \"http://example.com/aeiou\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<MaasOperator>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<MaasOperator>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<MaasOperator> operatorsRegistratePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "") @Valid @RequestBody Body body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<MaasOperator>(HttpStatus.NOT_IMPLEMENTED);
	}

}
