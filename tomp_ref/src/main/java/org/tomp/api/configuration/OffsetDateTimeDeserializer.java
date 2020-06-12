package org.tomp.api.configuration;

import java.io.IOException;

import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OffsetDateTimeDeserializer extends StdDeserializer<OffsetDateTime> {

	private static final long serialVersionUID = 8908258441798461284L;

	public OffsetDateTimeDeserializer() {
		this(null);
	}

	protected OffsetDateTimeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public OffsetDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);

		return OffsetDateTime.parse(node.textValue());
	}

}
