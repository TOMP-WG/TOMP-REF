package org.tomp.api.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class ObjectMapperConfiguration {

	@Autowired
	ObjectMapper mapper;

	@PostConstruct
	public void postConstruct() {
		SimpleModule module = new SimpleModule();
		module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
		module.addSerializer(LocalDate.class, new LocalDateSerializer());
		mapper.registerModule(module);
	}
}
