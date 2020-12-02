package org.tomp.ready.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.utils.ApiResponse;
import org.tomp.ready.utils.Pair;
import org.tomp.ready.validation.ArrayValidation;
import org.tomp.ready.validation.EqualsValidation;
import org.tomp.ready.validation.IValidation;
import org.tomp.ready.validation.ValidationResult;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.squareup.okhttp.Call;

public class BaseTestCase implements TestCaseInterface {

	private String endpoint;
	private String body;
	private List<IValidation> validations = new ArrayList<>();
	private ApiClient apiClient;
	private String url;
	private String id;
	private String apiVersion;
	private String resultJson;
	private String httpMethod;

	public BaseTestCase(ApiClient client, String baseUrl, String apiVersion, String mpId) {
		this.setUrl(baseUrl);
		this.apiClient = client;
		this.apiVersion = apiVersion;
		this.id = mpId;
	}

	@Override
	public void given() {
		TestCase[] annotationsByType = getClass().getAnnotationsByType(TestCase.class);
		if (annotationsByType.length > 0) {
			this.configEndpoint(annotationsByType[0].httpMethod(), annotationsByType[0].endpoint(), "");
		}
	}

	protected void configEndpoint(String httpMethod, String endpoint, String body) {
		this.httpMethod = httpMethod;
		this.endpoint = endpoint;
		this.body = body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public void when() throws ApiException {
		executeCall();
	}

	protected void executeCall() throws ApiException {
		Call call = createCall();
		handleCall(call);
	}

	public List<ValidationResult> then() {
		List<ValidationResult> results = new ArrayList<>();
		for (IValidation validation : this.validations) {
			validation.setEndpoint(httpMethod, endpoint);
			results.addAll(validation.validate(resultJson));
		}
		results.forEach(x -> x.setEndpoint(httpMethod, endpoint));

		return results;
	}

	protected void addEquals(String expression, String errorMessage, ErrorType type, String... expected) {
		EqualsValidation validation = new EqualsValidation(expression, errorMessage, type, expected);
		this.validations.add(validation);
	}

	protected <T> T getValue(String expression) {
		DocumentContext jsonContext = JsonPath.parse(resultJson);
		return jsonContext.read(expression);
	}

	protected void addValidation(IValidation validation) {
		this.validations.add(validation);
	}

	protected void addExists(String expression, String errorMessage, ErrorType type) {
		EqualsValidation validation = new EqualsValidation(expression, errorMessage, type, "EXISTS");
		this.validations.add(validation);
	}

	protected void addMandatoryField(String expression) {
		EqualsValidation validation = new EqualsValidation(expression,
				String.format("Mandatory field %s exists", expression), ErrorType.ERROR, "EXISTS");
		this.validations.add(validation);
	}

	protected void addMandatoryFieldInEachObject(String arrayExpression, String field) {
		this.validations.add(new ArrayValidation(arrayExpression, field,
				String.format("Mandatory field %s exists in each object", field), ErrorType.ERROR, "EXISTS"));
	}

	protected void addEqualsInEachObject(String arrayExpression, String expression, String errorMessage, ErrorType type,
			String... expected) {
		ArrayValidation validation = new ArrayValidation(arrayExpression, expression, errorMessage, type, expected);
		this.validations.add(validation);
	}

	protected void addMandatoryArray(String expression) {
		EqualsValidation validation = new EqualsValidation(expression,
				String.format("mandatory array %s does not exists", expression), ErrorType.ERROR, "EXISTS");
		this.validations.add(validation);
	}

	protected void handleCall(Call call) throws ApiException {
		ApiResponse<String> result = apiClient.execute(call, String.class);
		setResultJson(result.getData());
	}

	protected Call createCall() throws ApiException {
		apiClient.setVerifyingSsl(false);
		if (getUrl().endsWith("/") && endpoint.startsWith("/")) {
			setUrl(getUrl().substring(0, getUrl().length() - 1));
		}
		apiClient.setBasePath(getUrl());
		Object localVarPostBody = this.body;

		List<Pair> localVarQueryParams = new ArrayList<>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<>();

		Map<String, String> localVarHeaderParams = new HashMap<>();
		localVarHeaderParams.put("Accept-Language", apiClient.parameterToString("nl"));
		localVarHeaderParams.put("Api", apiClient.parameterToString("TOMP"));
		localVarHeaderParams.put("Api-Version", apiClient.parameterToString(this.getApiVersion()));
		localVarHeaderParams.put("maas-id", getId());

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
		return apiClient.buildCall(endpoint, httpMethod, localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
	}

	public String getResultJson() {
		return resultJson;
	}

	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
