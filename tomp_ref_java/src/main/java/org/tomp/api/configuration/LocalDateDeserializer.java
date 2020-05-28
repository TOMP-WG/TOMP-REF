package org.tomp.api.configuration;

import java.io.IOException;

import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1586983811903817030L;

	public LocalDateDeserializer() {
		this(null);
	}

	public LocalDateDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		return LocalDate.parse(node.textValue());
	}
}