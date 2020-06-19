package org.tomp.api.model.parking;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserialisationTest {

	@Test
	public void testDeserialization() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		File file = new File("src/test/resources");
		File[] listFiles = file.listFiles();
		try (Scanner scanner = new java.util.Scanner(listFiles[0], "UTF8")) {
			scanner.useDelimiter("\\Z");
			String json = scanner.next();
			StaticParkingData object = mapper.readValue(json, StaticParkingData.class);
			assertNotNull(object);
		}
	}
}
