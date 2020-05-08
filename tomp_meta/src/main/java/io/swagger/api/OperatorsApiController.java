package io.swagger.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Call;

import io.swagger.annotations.ApiParam;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody.ProgressRequestListener;
import io.swagger.configuration.ObjectFromFileProvider;
import io.swagger.configuration.Registry;
import io.swagger.model.Body;
import io.swagger.model.Coordinates;
import io.swagger.model.MaasOperator;
import io.swagger.model.RegistrationResult;
import io.swagger.model.RegistrationResult.StatusEnum;
import io.swagger.model.SystemRegion;
import io.swagger.model.ValidationRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-06T06:58:30.612Z[GMT]")
@Controller
public class OperatorsApiController implements OperatorsApi {

	private static final Logger log = LoggerFactory.getLogger(OperatorsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private Registry repository;

	private GeometryFactory factory = new GeometryFactory();

	@org.springframework.beans.factory.annotation.Autowired
	public OperatorsApiController(ObjectMapper objectMapper, HttpServletRequest request, Registry repository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.repository = repository;
	}

	public ResponseEntity<MaasOperator> operatorsIdGet(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "maasId", required = true) @PathVariable("id") String id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			MaasOperator maasOperator = repository.get(id);
			if (maasOperator != null) {
				log.info("Someone looked for maas operator {}", id);
				return new ResponseEntity<MaasOperator>(maasOperator, HttpStatus.OK);
			}
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Void> operatorsRegistratePost(
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@ApiParam(value = "") @Valid @RequestBody Body body) {

		log.info("Registration request of " + body.getName() + " (" + body.getId() + ")");
		log.info("Address " + body.getUrl() + "/" + body.getRegistrationresult());

		MaasOperator operator = new MaasOperator();
		operator.setName(body.getName());
		operator.setUrl(body.getUrl());
		operator.setValidationToken(body.getValidationToken());
		operator.setId(UUID.randomUUID().toString());
		repository.register(operator);

		sendResult(body);
		fetchArea(operator);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<MaasOperator> operatorsValidatePost(
			@ApiParam(value = "", required = true) @Valid @RequestBody ValidationRequest body,
			@ApiParam(value = "ISO 639-1 two letter language code", required = true) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true) @RequestHeader(value = "Api", required = true) String api,
			@ApiParam(value = "Version of the API.", required = true) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			MaasOperator maasOperator = repository.get(body.getId());
			if (maasOperator == null) {
				return new ResponseEntity<MaasOperator>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<MaasOperator>(maasOperator, HttpStatus.OK);
		}

		return new ResponseEntity<MaasOperator>(HttpStatus.BAD_REQUEST);
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
			headerParams.put("Api-Version", client.parameterToString(operator.getVersion()));
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

				ApiResponse<SystemRegion[]> response = client.execute(call, SystemRegion[].class);

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
			p.addPointsItem(toCoord(location));
		}
		return p;
	}

	private Coordinates toCoord(Coordinate location) {
		Coordinates c = new Coordinates();
		c.setLat(BigDecimal.valueOf(location.getY()));
		c.setLng(BigDecimal.valueOf(location.getX()));
		return c;
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

	@PostConstruct
	public void populateFromFile() {
		ObjectFromFileProvider<MaasOperator[]> operatorProvider = new ObjectFromFileProvider<>();
		for (MaasOperator operator : operatorProvider.getObject(MaasOperator[].class, "operators2.json")) {
			repository.register(operator);

			try {
				fetchArea(operator);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}
