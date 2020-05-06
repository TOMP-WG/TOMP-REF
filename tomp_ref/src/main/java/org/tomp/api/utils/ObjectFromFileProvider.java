package org.tomp.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectFromFileProvider<T> implements ObjectProvider<T> {

	private static final Logger log = LoggerFactory.getLogger(ObjectFromFileProvider.class);

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public T getObject(String acceptLanguage, Class<T> c, String fromFile) {
		if (fromFile == null) {
			throw new RuntimeException();
		}

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
			resourceAsStream = new FileInputStream(file);
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
