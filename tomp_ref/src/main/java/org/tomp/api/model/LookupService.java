package org.tomp.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

import com.squareup.okhttp.Call;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody.ProgressRequestListener;

@Component
public class LookupService {

	private static final Logger log = LoggerFactory.getLogger(LookupService.class);

	private ExternalConfiguration configuration;

	@Autowired
	public LookupService(ExternalConfiguration configuration) {
		this.configuration = configuration;
	}

	public <T> T callEndpoint(String method, String endpoint, Object body, Class<T> c) {
		String lookupService = configuration.getLookupService();
		ApiClient client = new ApiClient();
		if (lookupService.endsWith("/")) {
			lookupService = lookupService.substring(0, lookupService.length() - 1);
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
			return response.getData();
		} catch (ApiException e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
