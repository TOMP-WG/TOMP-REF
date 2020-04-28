package io.swagger.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ObjectFromFileProvider<T> {

	private static final Logger log = LoggerFactory.getLogger(ObjectFromFileProvider.class);

	private final ObjectMapper mapper = new ObjectMapper();

	public T getObject(Class<T> c, String fromFile) {
		File file = new File(fromFile);
		InputStream resourceAsStream = null;
		if (!file.exists()) {
			resourceAsStream = ClassLoader.getSystemResourceAsStream(fromFile);
			if (resourceAsStream == null) {
				ClassLoader classLoader = ClassLoader.getSystemClassLoader();

				file = new File(classLoader.getResource(fromFile).getFile());
				if (!file.exists()) {
					log.error(file.getAbsolutePath());
				}
			}
		}

		try {
			if (resourceAsStream == null) {
				resourceAsStream = new FileInputStream(file);
			}
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());
		}

		try {
			return mapper.readValue(resourceAsStream, c);
		} catch (IOException e) {
			log.error("parse exception", e);
		}
		return null;
	}
}
