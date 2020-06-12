package org.tomp.api.configuration;

import java.io.IOException;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

	@Override
	public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		//value.withOffsetSameLocal(ZoneOffset.of("Amsterdam"));
		ZoneOffset zoneOffset = OffsetDateTime.now(ZoneId.systemDefault()).getOffset ();
		value = value.withOffsetSameLocal(zoneOffset);
		String string = value.toString();
		gen.writeString(string);
	}

}
