package io.swagger.api;

import io.swagger.model.Coordinates;
import io.swagger.model.Error;
import io.swagger.model.MaasOperator;
import io.swagger.model.SearchCondition;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.configuration.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-06T06:58:30.612Z[GMT]")
@Controller
public class TransportOperatorsApiController implements TransportOperatorsApi {

	private static final Logger log = LoggerFactory.getLogger(TransportOperatorsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private Registry repository;

	@org.springframework.beans.factory.annotation.Autowired
	public TransportOperatorsApiController(ObjectMapper objectMapper, HttpServletRequest request, Registry repository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.repository = repository;
	}

	public ResponseEntity<List<MaasOperator>> transportOperatorsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody SearchCondition body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader("Accept");
		List<Coordinates> points = body.getArea().getPoints();

		List<MaasOperator> locations = repository.getOperators(points);

		return new ResponseEntity<List<MaasOperator>>(locations, HttpStatus.OK);

	}

}
