package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Registry;
import io.swagger.model.Coordinates;
import io.swagger.model.MaasLocation;
import io.swagger.model.SearchCondition;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T07:16:19.146Z[GMT]")
@Controller
public class LocationsApiController implements LocationsApi {

	private static final Logger log = LoggerFactory.getLogger(LocationsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private Registry repository;

	@org.springframework.beans.factory.annotation.Autowired
	public LocationsApiController(ObjectMapper objectMapper, HttpServletRequest request, Registry repository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.repository = repository;
	}

	public ResponseEntity<List<MaasLocation>> locationsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody SearchCondition body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			List<Coordinates> points = body.getArea().getPoints();

			List<MaasLocation> locations = repository.getLocations(points);

			return new ResponseEntity<List<MaasLocation>>(locations, HttpStatus.OK);
		}

		return new ResponseEntity<List<MaasLocation>>(HttpStatus.NOT_FOUND);
	}

}
