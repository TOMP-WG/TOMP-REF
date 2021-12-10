package org.tomp.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.utils.ExternalFileService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Call;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody.ProgressRequestListener;
import io.swagger.model.GeojsonPolygon;

@Component
public class LookupService {

	private static final Logger log = LoggerFactory.getLogger(LookupService.class);

	private ExternalConfiguration configuration;
	private ObjectMapper mapper;

	private HashMap<String, MaasOperator> cache = new HashMap<>();

	@Autowired
	ExternalFileService fileService;

	@Autowired
	public LookupService(ExternalConfiguration configuration, ObjectMapper mapper) {
		this.configuration = configuration;
		this.mapper = mapper;
	}

	public MaasOperator getMaasOperator(String id) {

		if (configuration.isAllowUnknownOperators()) {
			return null;
		}

		MaasOperator operator = cache.get(id);
		if (operator == null && !cache.containsKey(id)) {
			operator = callEndpoint("GET", "/operators/" + id, null, MaasOperator.class);
			cache.put(id, operator);
		}
		return operator;
	}

	public boolean validate(String maasId, String token) {
		if (!configuration.isAuthenticationRequired()) {
			return true;
		}
		MaasOperator operator = callEndpoint("POST", "/operators/authenticate?id=" + maasId + "&token=" + token, "",
				MaasOperator.class);
		return operator != null;

	}

	public MaasOperator[] findOperators(GeojsonPolygon area) throws JsonProcessingException {
		Object body = "{\"area\": " + mapper.writeValueAsString(area) + "}";
		return callEndpoint("POST", "/operators", body, MaasOperator[].class);
	}

	@PostConstruct
	public void configureLookUp() throws IOException {
		if (configuration.getMaasId().equals("none")) {
			registrateOperator();
		} else {
			refreshMetaInformation();
		}
	}

	private void refreshMetaInformation() throws IOException {
		if (configuration.isRefreshOnStartUp()) {
			String body = body(configuration.getMaasId());
			MaasOperator registered = callEndpoint("PUT",
					"/operators/" + configuration.getMaasId() + "?token=" + configuration.getMaasId(), body,
					MaasOperator.class);
			if (registered != null) {
				configuration.setMaasId(registered.getId());
			}
		}
	}

	private void registrateOperator() throws IOException {
		String body = body("");
		MaasOperator registered = callEndpoint("POST", "/operators/registrate", body, MaasOperator.class);
		if (registered != null) {
			log.info("Assigned id: {}", registered.getId());
			configuration.setMaasId(registered.getId());
		}
	}

	private String body(String id) throws IOException {
		GeojsonPolygon area = fileService.getArea();
		MaasEnvironmentType type = configuration.getEnvironmentType();
		String json = mapper.writeValueAsString(area).replace("\"", "\\\"");
		json = "{" + "  \"id\": \"" + id + "\"," + "  \"type\": " + mapper.writeValueAsString(type) + ","
				+ "  \"name\": \"" + configuration.getAppName() + "\"," + "  \"url\": \""
				+ configuration.getExternalUrl() + "\"," + "  \"supportedVersions\": " + fileService.getVersions()
				+ ",  \"validationToken\": \"" + configuration.getMaasId() + "\","
				+ "  \"transactionProvider\": \"none\"," + "  \"servicedArea\": " + json + ","
				+ "  \"registrationresult\": \"" + configuration.getExternalUrl() + "/registrated/\"" + "}";
		log.info(json);
		return json;
	}

	private <T> T callEndpoint(String method, String endpoint, Object body, Class<T> c) {
		String lookupService = configuration.getLookupService();
		ApiClient client = new ApiClient();
		if (lookupService.endsWith("/")) {
			lookupService = lookupService.substring(0, lookupService.length() - 1);
		}
		log.info("Calling {}{}", lookupService, endpoint);
		if (body != null && !body.equals("")) {
			log.info("body: {}", body);
		}

		client.setBasePath(lookupService);
		List<Pair> queryParams = new ArrayList<>();
		List<Pair> collectionQueryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();
		String[] authNames = new String[] {};
		ProgressRequestListener progressRequestListener = null;

		headerParams.put("Accept-Language", client.parameterToString("nl"));
		headerParams.put("Api", client.parameterToString("TOMP"));

		headerParams.put("Api-Version", client.parameterToString(configuration.getApiVersion()));
		headerParams.put("maas-id", configuration.getMaasId());

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = client.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			headerParams.put("Accept", localVarAccept);
		headerParams.put("Content-Type", "application/json");

		try {
			Call call = client.buildCall(endpoint, method, queryParams, collectionQueryParams, body, headerParams,
					formParams, authNames, progressRequestListener);
			ApiResponse<T> response = client.execute(call, c);
			if (response.getStatusCode() != 200) {
				log.info("Error code: {}", response.getStatusCode());
			}
			return response.getData();
		} catch (ApiException e) {
			log.error(e.getMessage());
			log.error(e.getResponseBody());
		}
		return null;
	}
}
