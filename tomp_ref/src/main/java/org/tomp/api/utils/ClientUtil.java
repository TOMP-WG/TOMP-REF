package org.tomp.api.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.controllers.WebsocketController;
import org.tomp.api.model.MaasOperator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Call;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Pair;

@Component
public class ClientUtil {

	private static ExternalConfiguration configuration;
	private static final Logger log = LoggerFactory.getLogger(ClientUtil.class);

	private static ObjectMapper mapper;

	@Autowired
	private WebsocketController websocket;

	@Autowired
	private ClientUtil(ExternalConfiguration configuration, ObjectMapper mapper) {
		ClientUtil.configuration = configuration;
		ClientUtil.mapper = mapper;
	}

	public <T> T get(MaasOperator to, String localVarPath, Class<T> class1) throws ApiException {
		return get(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), class1, null);
	}

	public <T> T get(MaasOperator to, String localVarPath, Class<T> class1, Map<String, String> headers)
			throws ApiException {
		return get(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), class1, headers);
	}

	public <T> T get(MaasOperator to, String acceptLanguage, String apiVersion, String localVarPath, String maasId,
			Class<T> class1, Map<String, String> headers) throws ApiException {
		ApiClient apiClient = new ApiClient();
		apiClient.setVerifyingSsl(false);
		String url = to.getUrl();
		if (url.endsWith("/") && localVarPath.startsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		apiClient.setBasePath(url);
		Object localVarPostBody = null;

		List<Pair> localVarQueryParams = new ArrayList<>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<>();

		Map<String, String> localVarHeaderParams = new HashMap<>();
		if (acceptLanguage != null)
			localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));
		localVarHeaderParams.put("Api", apiClient.parameterToString("TOMP"));
		if (apiVersion != null)
			localVarHeaderParams.put("Api-Version", apiClient.parameterToString(apiVersion));

		localVarHeaderParams.put("maas-id", maasId);

		Map<String, Object> localVarFormParams = new HashMap<>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) {
			localVarHeaderParams.put("Accept", localVarAccept);
		}

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				localVarHeaderParams.put(entry.getKey(), entry.getValue());
			}
		}

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] {};
		Call call = apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return handleResult(to, class1, apiClient, call, localVarPath, localVarPostBody, "GET");
	}

	public <T> T post(MaasOperator to, String localVarPath, Object localVarPostBody, Class<T> class1)
			throws ApiException {
		return post(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), localVarPostBody, class1);
	}

	public <T> T post(MaasOperator to, String acceptLanguage, String apiVersion, String localVarPath, String maasId,
			Object localVarPostBody, Class<T> class1) throws ApiException {
		return post(to, acceptLanguage, apiVersion, localVarPath, maasId, null, localVarPostBody, class1);

	}

	public <T> T post(MaasOperator to, String acceptLanguage, String apiVersion, String localVarPath, String maasId,
			Map<String, String> headers, Object localVarPostBody, Class<T> class1) throws ApiException {

		ApiClient apiClient = new ApiClient();
		apiClient.setConnectTimeout(20000);
		apiClient.setReadTimeout(20000);
		String url = to.getUrl();
		if (url.endsWith("/") && localVarPath.startsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		apiClient.setBasePath(url);
		apiClient.setReadTimeout(10000);
		log.info("Connecting to {}{}", url, localVarPath);
		log.info("Body {}", localVarPostBody);

		List<Pair> localVarQueryParams = new ArrayList<>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<>();

		Map<String, String> localVarHeaderParams = new HashMap<>();
		if (acceptLanguage != null)
			localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));
		localVarHeaderParams.put("Api", apiClient.parameterToString("TOMP"));
		if (apiVersion != null)
			localVarHeaderParams.put("Api-Version", apiClient.parameterToString(apiVersion));

		localVarHeaderParams.put("maas-id", maasId);

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				localVarHeaderParams.put(entry.getKey(), entry.getValue());
			}
		}

		Map<String, Object> localVarFormParams = new HashMap<>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] {};

		if (class1 != String.class) {
			try {
				localVarPostBody = mapper.writeValueAsString(localVarPostBody);
			} catch (JsonProcessingException e) {
				log.error(e.getMessage());
			}
		}

		Call call = apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return handleResult(to, class1, apiClient, call, localVarPath, localVarPostBody, "POST");
	}

	private <T> T handleResult(MaasOperator to, Class<T> class1, ApiClient apiClient, Call call, String localVarPath,
			Object body, String getOrPost) {

		if (class1 == String.class) {
			try {
				ApiResponse<T> result = apiClient.execute(call, String.class);
				return result.getData();
			} catch (ApiException e) {
				websocket.sendMessage(localVarPath, body);
				log.error("Cannot connect to {} ({})", to.getName(), to.getUrl());
				log.error(e.getMessage());
				log.error(e.getResponseBody());
				return null;
			}
		}
		try {
			String dest = getOrPost.equals("POST") ? post(to, localVarPath, body, String.class)
					: getOrPost.equals("GET") ? get(to, localVarPath, String.class)
							: patch(to, localVarPath, body, String.class);
			if (dest != null) {
				return mapper.readValue(dest, class1);
			} else {
				return null;
			}
		} catch (IOException e2) {
			log.error("Deserialisation error");
			log.error(e2.getMessage());
		} catch (ApiException e) {
			log.error("Exception connecting to {} ({})", to.getName(), to.getUrl());
			log.error(e.getMessage());
			log.error(e.getResponseBody());
		} catch (Exception e) {
			log.error("Exception connecting to {} ({})", to.getName(), to.getUrl());
			log.error(e.getMessage());
		}
		return null;
	}

	public <T> T patch(MaasOperator to, String localVarPath, Object localVarPostBody, Class<T> class1)
			throws ApiException {
		return patch(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), localVarPostBody, class1);
	}

	private <T> T patch(MaasOperator to, String acceptLanguage, String apiVersion, String localVarPath, String maasId,
			Object localVarPostBody, Class<T> class1) throws ApiException {

		ApiClient apiClient = new ApiClient();
		apiClient.setConnectTimeout(20000);
		apiClient.setReadTimeout(20000);
		String url = to.getUrl();
		if (url.endsWith("/") && localVarPath.startsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		apiClient.setBasePath(url);
		apiClient.setReadTimeout(10000);
		log.info("Connecting to {}{}", url, localVarPath);
		log.info("Body {}", localVarPostBody);

		List<Pair> localVarQueryParams = new ArrayList<>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<>();

		Map<String, String> localVarHeaderParams = new HashMap<>();
		if (acceptLanguage != null)
			localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));
		localVarHeaderParams.put("Api", apiClient.parameterToString("TOMP"));
		if (apiVersion != null)
			localVarHeaderParams.put("Api-Version", apiClient.parameterToString(apiVersion));

		localVarHeaderParams.put("maas-id", maasId);

		Map<String, Object> localVarFormParams = new HashMap<>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] {};

		if (class1 != String.class) {
			try {
				localVarPostBody = mapper.writeValueAsString(localVarPostBody);
			} catch (JsonProcessingException e) {
				log.error(e.getMessage());
			}
		}

		Call call = apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return handleResult(to, class1, apiClient, call, localVarPath, localVarPostBody, "PATCH");
	}
}
