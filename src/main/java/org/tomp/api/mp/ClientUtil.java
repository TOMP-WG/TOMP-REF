package org.tomp.api.mp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

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
	private ClientUtil(ExternalConfiguration configuration, ObjectMapper mapper) {
		ClientUtil.configuration = configuration;
		ClientUtil.mapper = mapper;
	}

	public static <T> T get(TransportOperator to, String localVarPath, Class<T> class1) throws ApiException {
		return get(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), class1);
	}

	private static <T> T get(TransportOperator to, String acceptLanguage, String apiVersion, String localVarPath,
			String maasId, Class<T> class1) throws ApiException {
		ApiClient apiClient = new ApiClient();
		String url = to.getTompApiUrl();
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
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] {};
		Call call = apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return handleResult(to, class1, apiClient, call, localVarPath, localVarPostBody, "GET");
	}

	public static <T> T post(TransportOperator to, String localVarPath, Object localVarPostBody, Class<T> class1)
			throws ApiException {
		return post(to, configuration.getAcceptLanguage(), configuration.getApiVersion(), localVarPath,
				configuration.getMaasId(), localVarPostBody, class1);
	}

	private static <T> T post(TransportOperator to, String acceptLanguage, String apiVersion, String localVarPath,
			String maasId, Object localVarPostBody, Class<T> class1) throws ApiException {
		ApiClient apiClient = new ApiClient();
		String url = to.getTompApiUrl();
		if (url.endsWith("/") && localVarPath.startsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		apiClient.setBasePath(url);

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
				e.printStackTrace();
			}
		}

		Call call = apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return handleResult(to, class1, apiClient, call, localVarPath, localVarPostBody, "POST");
	}

	private static <T> T handleResult(TransportOperator to, Class<T> class1, ApiClient apiClient, Call call,
			String localVarPath, Object body, String getOrPost) {

		if (class1 == String.class) {
			try {
				ApiResponse<T> result = apiClient.execute(call, String.class);
				return result.getData();
			} catch (Exception e) {
				String message = String.format("Cannot connect to %s", to.getName());
				log.error(message);
				log.error(e.getMessage());
				return null;
			}
		}
		try {
			String dest = getOrPost.equals("POST") ? ClientUtil.post(to, localVarPath, body, String.class)
					: ClientUtil.get(to, localVarPath, String.class);
			try {
				return mapper.readValue(dest, class1);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			String message = String.format("Cannot connect to %s", to.getName());
			log.error(message);
			log.error(e.getMessage());
			// throw e;
		}
		return null;
	}
	// }
}
