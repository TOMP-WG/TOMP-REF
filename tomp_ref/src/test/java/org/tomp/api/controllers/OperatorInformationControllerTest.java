package org.tomp.api.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.EndpointImplementation;

public class OperatorInformationControllerTest {

	@Test
	public void deserialize() throws JsonMappingException, JsonProcessingException {
		String s = "[{\"version\":\"0.5.0\",\"baseUrl\":\"https://dummy-to.org/\",\"endpoints\":[],\"scenarios\":[\"POSTPONED_COMMIT\"],\"processIdentifiers\":{\"operatorInformation\":null,\"planning\":[\"LOCATION_BASED\"],\"booking\":[\"ACCESS_CODE_QR\",\"ACCESS_CODE_IN_COMMIT_EVENT\"],\"tripExecution\":null,\"support\":null,\"payment\":null,\"general\":null}}]";
		ObjectMapper mapper = new ObjectMapper();
		EndpointImplementation[] endpoints = mapper.readValue(s, EndpointImplementation[].class);
		assertNotNull(endpoints);
	}
}
