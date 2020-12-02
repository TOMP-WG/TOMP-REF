package org.tomp.ready.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.utils.ApiResponse;
import org.tomp.ready.utils.Pair;
import org.tomp.ready.validation.ValidationResult;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.squareup.okhttp.Call;

import net.minidev.json.JSONArray;

@Component
public class TestProcessor {

	@Autowired
	ApiClient client;

	public List<ValidationResult> validateProcess(String apiVersion, String mpId, String url)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			InvocationTargetException, ApiException {

		if (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}

		List<ValidationResult> results = new ArrayList<>();

		DefaultListableBeanFactory context = new DefaultListableBeanFactory();
		Set<BeanDefinition> findCandidateComponents = getTestCaseClasses(apiVersion, mpId, url);
		for (BeanDefinition bd : findCandidateComponents) {
			TestCaseInterface bean = constructTestCase(apiVersion, mpId, url, context, bd);
			results.addAll(doTest(bean));
		}
		return results;
	}

	private TestCaseInterface constructTestCase(String apiVersion, String mpId, String url,
			DefaultListableBeanFactory context, BeanDefinition bd) throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {
		context.registerBeanDefinition(UUID.randomUUID().toString(), bd);

		Class<?> c = Class.forName(bd.getBeanClassName());
		Constructor<?> constructor = c.getConstructor(ApiClient.class, String.class, String.class, String.class);
		return (TestCaseInterface) constructor.newInstance(client, url, apiVersion, mpId);
	}

	public Collection<ValidationResult> doTest(TestCaseInterface bean) throws ApiException {
		bean.given();
		bean.when();
		return bean.then();
	}

	private Set<BeanDefinition> getTestCaseClasses(String apiVersion, String mpId, String url) throws ApiException {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		AnnotationTypeFilter includeFilter = new AnnotationTypeFilter(TestCase.class);
		scanner.addIncludeFilter(includeFilter);

		Environment wrappedEnvironment = wrapEnvironment(scanner.getEnvironment(), apiVersion, mpId, url);
		scanner.setEnvironment(wrappedEnvironment);

		Set<BeanDefinition> findCandidateComponents = scanner.findCandidateComponents("org.tomp.ready.testcases");
		return findCandidateComponents;
	}

	private Environment wrapEnvironment(Environment environment, String version, String mpId, String url)
			throws ApiException {
		ExtendedEnvironment extendedEnvironment = new ExtendedEnvironment(environment, version);
		fillEnvironmentWithMetaData(extendedEnvironment, version, mpId, url);
		return extendedEnvironment;
	}

	private void fillEnvironmentWithMetaData(ExtendedEnvironment extendedEnvironment, String version, String mpId,
			String url) throws ApiException {
		Call call = createCall(url, version, mpId);
		JSONArray jsonArray = handleCall(call, version);
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> metaJson = (LinkedHashMap<String, Object>) jsonArray.get(0);
		parseEndpoints(metaJson, extendedEnvironment);
		parseProcessIdentifiers(metaJson, extendedEnvironment);
		parseScenarios(metaJson, extendedEnvironment);
	}

	private void parseScenarios(LinkedHashMap<String, Object> metaJson, ExtendedEnvironment extendedEnvironment) {
		JSONArray scenarios = (JSONArray) metaJson.get("scenarios");
		for (Object scenario : scenarios) {
			extendedEnvironment.addValue(scenario.toString(), "");
		}
		// extendedEnvironment.addValue("scenarios", scenarios);
	}

	private void parseProcessIdentifiers(LinkedHashMap<String, Object> metaJson,
			ExtendedEnvironment extendedEnvironment) {
		// TODO Auto-generated method stub

	}

	private void parseEndpoints(LinkedHashMap<String, Object> metaJson, ExtendedEnvironment extendedEnvironment) {
		// TODO Auto-generated method stub

	}

	protected JSONArray handleCall(Call call, String version) throws ApiException {
		ApiResponse<String> result = client.execute(call, String.class);
		DocumentContext jsonContext = JsonPath.parse(result.getData());
		return jsonContext.read("$[?(@.version=='0.9.0')]");
	}

	protected Call createCall(String url, String version, String mpId) throws ApiException {
		client.setVerifyingSsl(false);
		if (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		client.setBasePath(url);
		Object localVarPostBody = "";

		List<Pair> localVarQueryParams = new ArrayList<>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<>();

		Map<String, String> localVarHeaderParams = new HashMap<>();
		localVarHeaderParams.put("Accept-Language", client.parameterToString("nl"));
		localVarHeaderParams.put("Api", client.parameterToString("TOMP"));
		localVarHeaderParams.put("Api-Version", client.parameterToString(version));
		localVarHeaderParams.put("maas-id", mpId);

		Map<String, Object> localVarFormParams = new HashMap<>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = client.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = client.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		String[] localVarAuthNames = new String[] {};
		return client.buildCall("/operator/meta", "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
	}
}
