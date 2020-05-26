package org.tomp.ref.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Call;

import io.swagger.annotations.ApiParam;
import io.swagger.api.OperatorsApiController;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody.ProgressRequestListener;
import io.swagger.configuration.Registry;
import io.swagger.model.Body;
import io.swagger.model.Coordinates;
import io.swagger.model.MaasOperator;
import io.swagger.model.SearchCondition;
import io.swagger.model.StringContainer;
import io.swagger.model.SystemRegion;

@Controller
public class ApiController extends OperatorsApiController {

	private static final String CELL_SPLIT = "</td><td>";
	private static final String APPLICATION_JSON_TOKEN = "application/json";
	private static final String ACCEPT_TOKEN = "Accept";
	private static final Logger log = LoggerFactory.getLogger(ApiController.class);
	private HttpServletRequest request;

	private Registry repository;

	private GeometryFactory factory = new GeometryFactory();

	@org.springframework.beans.factory.annotation.Autowired
	public ApiController(ObjectMapper objectMapper, HttpServletRequest request, Registry repository) {
		super(objectMapper, request);
		this.request = request;
		this.repository = repository;
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsAuthenticatePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "id", required = true) String id,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "token", required = true) String token) {
		String accept = request.getHeader(ACCEPT_TOKEN);
		if (accept != null && accept.contains(APPLICATION_JSON_TOKEN)) {
			log.info("GET operators/authenticate/{}", id);
			String storedToken = repository.getToken(id);
			if (storedToken == null) {
				log.info("NOT_FOUND {}", id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			if (!storedToken.equals(token)) {
				log.info("INCORRECT_TOKEN {}", id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			log.info("OK {}", id);
			return new ResponseEntity<>(repository.get(id), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsIdGet(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader(ACCEPT_TOKEN);
		log.info("GET operators/{}", id);
		if (accept != null && accept.contains(APPLICATION_JSON_TOKEN)) {
			MaasOperator maasOperator = repository.get(id);
			if (maasOperator != null) {
				log.info("OK {}", id);
				return new ResponseEntity<>(maasOperator, HttpStatus.OK);
			}
		}

		log.info("NOT_FOUND {}", id);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsIdPut(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody MaasOperator body,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader(ACCEPT_TOKEN);
		if (accept != null && accept.contains(APPLICATION_JSON_TOKEN)) {
			log.info("PUT operators/{}", id);
			MaasOperator old = repository.get(id);
			if (old == null) {
				// return new ResponseEntity<MaasOperator>(HttpStatus.BAD_REQUEST);
				// for now, autoregistrate
				repository.register(body);
				log.info("REGISTERED {}", id);
				return new ResponseEntity<>(body, HttpStatus.OK);
			}
			if (old.getValidationToken().equals(token)) {
				repository.register(body);
				log.info("REFRESHED {}", id);
				return new ResponseEntity<>(body, HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<MaasOperator>> operatorsPost(
			@ApiParam(value = "", required = true) @Valid @RequestBody SearchCondition body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader(ACCEPT_TOKEN);
		if (accept != null && accept.contains(APPLICATION_JSON_TOKEN)) {
			log.info("POST operators/{area}");
			List<Coordinates> points = body.getArea().getPoints();
			List<MaasOperator> locations = repository.getOperators(points);
			log.info("OK #found: {}", locations.size());
			return new ResponseEntity<>(locations, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsRegistratePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "") @Valid @RequestBody Body body) {
		String accept = request.getHeader(ACCEPT_TOKEN);
		if (accept != null && accept.contains(APPLICATION_JSON_TOKEN)) {
			log.info("POST operators/registrate {}", body.getName());

			body.setId(UUID.randomUUID().toString());
			repository.register(body);

			// sendResult(body);
			fetchArea(body);

			log.info("response {}", body);
		}
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	private void fetchArea(MaasOperator operator) {
		if (operator.getServicedArea() == null || operator.getServicedArea().getPoints() == null
				|| operator.getServicedArea().getPoints().isEmpty()) {

			ApiClient client = new ApiClient();
			String url = operator.getUrl();
			if (url.endsWith("/")) {
				url = url.substring(0, url.length() - 1);
			}
			client.setBasePath(url);
			List<Pair> collectionQueryParams = new ArrayList<>();
			Map<String, String> headerParams = new HashMap<>();
			Map<String, Object> formParams = new HashMap<>();
			String[] authNames = new String[] {};
			ProgressRequestListener progressRequestListener = null;

			headerParams.put("Accept-Language", client.parameterToString("nl"));
			headerParams.put("Api", client.parameterToString("TOMP"));
			headerParams.put("Api-Version",
					client.parameterToString(operator.getSupportedVersions().get(0).getVersion()));
			headerParams.put("maas-id", "1");

			final String[] localVarAccepts = { APPLICATION_JSON_TOKEN };
			final String localVarAccept = client.selectHeaderAccept(localVarAccepts);
			if (localVarAccept != null)
				headerParams.put(ACCEPT_TOKEN, localVarAccept);
			headerParams.put("Content-Type", APPLICATION_JSON_TOKEN);

			try {
				Object responsebody = null;
				Call call = client.buildCall("/operator/regions/", "GET", collectionQueryParams, responsebody,
						headerParams, formParams, authNames, progressRequestListener);

				io.swagger.client.ApiResponse<SystemRegion[]> response = client.execute(call, SystemRegion[].class);

				Polygon polygon = null;
				for (SystemRegion region : response.getData()) {
					if (polygon == null) {
						polygon = toGeometry(region);
					} else {
						polygon.union(toGeometry(region));
					}
				}

				io.swagger.model.Polygon serviceArea = toPolygon(polygon);
				repository.registerArea(operator.getId(), serviceArea);

			} catch (ApiException e) {
				log.error(e.getMessage());
			}
		} else {
			repository.registerArea(operator.getId(), operator.getServicedArea());
		}
	}

	private io.swagger.model.Polygon toPolygon(Polygon polygon) {
		io.swagger.model.Polygon p = new io.swagger.model.Polygon();
		for (Coordinate location : polygon.getCoordinates()) {
			p.addPointsItem(toPoint(location));
		}
		return p;
	}

	private Coordinates toPoint(Coordinate c) {
		Coordinates coordinate = new Coordinates();
		coordinate.setLat(BigDecimal.valueOf(c.getX()));
		coordinate.setLng(BigDecimal.valueOf(c.getY()));
		return coordinate;
	}

	private Polygon toGeometry(SystemRegion region) {
		List<Coordinates> points = region.getServiceArea().getPoints();
		Coordinate[] coords = new Coordinate[points.size()];
		for (int i = 0; i < points.size(); i++) {
			Coordinates c = points.get(i);
			coords[i] = toCoordinate(c);
		}
		return factory.createPolygon(coords);
	}

	private Coordinate toCoordinate(Coordinates c) {
		Coordinate coordinate = new Coordinate();
		coordinate.setY(c.getLat().doubleValue());
		coordinate.setX(c.getLng().doubleValue());
		return coordinate;
	}

	// private void sendResult(Body body) {
	// String registrationresult = body.getRegistrationresult();
	// String host = request.getRemoteHost();
	// int port = request.getRemotePort();
	// ApiClient client = new ApiClient();
	// String url = host + ":" + port + "/" + registrationresult;
	// List<Pair> collectionQueryParams = new ArrayList<>();
	// Map<String, String> headerParams = new HashMap<>();
	// Map<String, Object> formParams = new HashMap<>();
	// String[] authNames = new String[] {};
	//
	// RegistrationResult responsebody = new RegistrationResult();
	// responsebody.setStatus(StatusEnum.ACCEPTED);
	//
	// ProgressRequestListener progressRequestListener = null;
	// try {
	// Call call = client.buildCall(url, "POST", collectionQueryParams,
	// responsebody, headerParams, formParams,
	// authNames, progressRequestListener);
	// client.execute(call);
	// } catch (ApiException e) {
	// e.printStackTrace();
	// }
	// }

	@GetMapping("/maas-operators/")
	@ResponseBody
	public String listMaasOperatorsPage() {
		StringBuilder builder = new StringBuilder("<html><head><title>Registrated MaaS Operators</title></head><body>");
		builder.append("<h1>registrated operators</h1>");
		builder.append("<table><tr><th>name</th><th>url</th><th>id</th><th>type</th></tr>");
		for (MaasOperator operator : repository.getOperators(null)) {
			builder.append("<tr><td>");
			builder.append(operator.getName());
			builder.append(CELL_SPLIT);
			builder.append(operator.getUrl());
			builder.append(CELL_SPLIT);
			builder.append(operator.getId());
			builder.append(CELL_SPLIT);
			builder.append(operator.getType());
			builder.append("</td></tr>");
		}
		builder.append("</table>");
		builder.append("<a href=\"/maas-operators/add\">Registrate new operator</a>");
		return builder.toString();
	}

	@GetMapping("/maas-operators/add")
	@ResponseBody
	public String addMaasOperatorPage() {
		StringBuilder builder = new StringBuilder(
				"<html><head><title>Registrate new MaaS Operator</title></head><body>");
		builder.append("<form action=\"/maas-operators/registrate\" method=\"post\">");
		builder.append("<textarea id=\"json\" name=\"json\" rows=\"50\" cols=\"100\">");
		builder.append(template());
		builder.append("</textarea><input type=\"submit\" value=\"Submit\"></form>");

		return builder.toString();
	}

	private String template() {
		//@formatter:off
		return "{ \"country\": \"NL\",\r\n"
				+ "  \"type\": \"TO\",\r\n"
				+ "  \"name\": \"{{name}}\",\r\n"
				+ "  \"url\": \"{{public url}}\",\r\n"
				+ "  \"supportedVersions\": [\r\n"
				+ "  { \"version\": \"0.5.0\",\r\n"
				+ "    \"endpoints\": [\r\n"
				+ "       { \"method\": \"POST\",\r\n"
				+ "          \"path\": \"string\",\r\n"
				+ "          \"status\": \"NOT_IMPLEMENTED\"\r\n"
				+ "       }\r\n"
				+ "    ],\r\n"
				+ "   \"scenarios\": [\r\n"
				+ "       \"POSTPONED_COMMIT\"\r\n"
				+ "      ]\r\n"
				+ "  }\r\n"
				+ "  ],\r\n"
				+ "  \"validationToken\": \"{{optional validationToken}}\",\r\n"
				+ "  \"servicedArea\": {\r\n"
				+ "    \"points\": [\r\n"
				+ "      { \"lng\": 6.169639,\r\n"
				+ "        \"lat\": 52.253279\r\n"
				+ "      }\r\n"
				+ "    ]"
				+ "  }}";
		//@formatter:on
	}

	@PostMapping("/maas-operators/registrate")
	@ResponseBody
	public String registrateMaasOperator(@ModelAttribute StringContainer operatorContainer) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		MaasOperator operator = mapper.readValue(operatorContainer.getJson(), MaasOperator.class);
		if (operator != null) {
			operator.setId(UUID.randomUUID().toString());
			repository.register(operator);
		}
		return "<html><body>ID: " + operator.getId() + "<br>body:" + mapper.writeValueAsString(operator)
				+ "<br><a href=\"/maas-operators/\">Back</a></body></html>";
	}
}
