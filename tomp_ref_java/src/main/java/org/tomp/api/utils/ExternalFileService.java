package org.tomp.api.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;

import io.swagger.model.Polygon;

@Component
public class ExternalFileService {

	private ExternalConfiguration configuration;

	@Autowired
	public ExternalFileService(ExternalConfiguration configuration) {
		this.configuration = configuration;
	}

	public Polygon getArea() {
		ObjectFromFileProvider<Polygon> areaProvider = new ObjectFromFileProvider<>();
		return areaProvider.getObject("", Polygon.class, configuration.getAreaFile());
	}

	public String getVersions() throws IOException {
		File f = new File(configuration.getVersionFile());
		return String.join("", Files.readAllLines(f.toPath()));
	}
}
