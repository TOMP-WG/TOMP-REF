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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import io.swagger.model.RegistrationResult;
import io.swagger.model.RegistrationResult.StatusEnum;
import io.swagger.model.SearchCondition;
import io.swagger.model.SystemRegion;

@Controller
public class ApiController extends OperatorsApiController {

	private static final Logger log = LoggerFactory.getLogger(ApiController.class);
	private HttpServletRequest request;

	private Registry repository;

	private GeometryFactory factory = new GeometryFactory();
	private ObjectMapper objectMapper;

	@org.springframework.beans.factory.annotation.Autowired
	public ApiController(ObjectMapper objectMapper, HttpServletRequest request, Registry repository) {
		super(objectMapper, request);
		this.objectMapper = objectMapper;
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
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			MaasOperator maasOperator = repository.get(id);
			if (maasOperator == null) {
				return new ResponseEntity<MaasOperator>(HttpStatus.NOT_FOUND);
			}

			if (!maasOperator.getValidationToken().equals(token)) {
				return new ResponseEntity<MaasOperator>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<MaasOperator>(maasOperator, HttpStatus.OK);
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsIdGet(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader("Accept");
		log.info("Someone looked for maas operator {}", id);
		if (accept != null && accept.contains("application/json")) {
			MaasOperator maasOperator = repository.get(id);
			if (maasOperator != null) {
				log.info("Found maas operator {}", id);
				return new ResponseEntity<MaasOperator>(maasOperator, HttpStatus.OK);
			}
		}

		log.info("Did not find maas operator {}", id);
		return new ResponseEntity<MaasOperator>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsIdPut(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id,
			@ApiParam(value = "") @Valid @RequestBody MaasOperator body,
			@ApiParam(value = "the old token") @Valid @RequestParam(value = "token", required = false) String token) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			MaasOperator old = repository.get(id);
			if (old == null) {
				// return new ResponseEntity<MaasOperator>(HttpStatus.BAD_REQUEST);
				// for now, autoregistrate
				repository.register(body);
				Body registrationBody = null;
				try {
					String serialized = objectMapper.writeValueAsString(body);
					registrationBody = objectMapper.readValue(serialized, Body.class);
				} catch (IOException e) {
					log.error(e.getMessage());
				}
				return operatorsRegistratePost(acceptLanguage, api, apiVersion, registrationBody);
			}
			if (old.getValidationToken().equals(token)) {
				repository.register(body);
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
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			List<Coordinates> points = body.getArea().getPoints();

			List<MaasOperator> locations = repository.getOperators(points);
			return new ResponseEntity<List<MaasOperator>>(locations, HttpStatus.OK);
		}

		return new ResponseEntity<List<MaasOperator>>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<MaasOperator> operatorsRegistratePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "") @Valid @RequestBody Body body) {
		log.info("Registration request of " + body.getName() + " (" + body.getId() + ")");
		log.info("Address " + body.getUrl() + "/" + body.getRegistrationresult());

		body.setId(UUID.randomUUID().toString());
		repository.register(body);

		// sendResult(body);
		fetchArea(body);

		return new ResponseEntity<MaasOperator>(body, HttpStatus.OK);
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

			final String[] localVarAccepts = { "application/json" };
			final String localVarAccept = client.selectHeaderAccept(localVarAccepts);
			if (localVarAccept != null)
				headerParams.put("Accept", localVarAccept);
			headerParams.put("Content-Type", "application/json");

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

	private void sendResult(Body body) {
		String registrationresult = body.getRegistrationresult();
		String host = request.getRemoteHost();
		int port = request.getRemotePort();
		ApiClient client = new ApiClient();
		String url = host + ":" + port + "/" + registrationresult;
		List<Pair> collectionQueryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();
		String[] authNames = new String[] {};

		RegistrationResult responsebody = new RegistrationResult();
		responsebody.setStatus(StatusEnum.ACCEPTED);

		ProgressRequestListener progressRequestListener = null;
		try {
			Call call = client.buildCall(url, "POST", collectionQueryParams, responsebody, headerParams, formParams,
					authNames, progressRequestListener);
			client.execute(call);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
