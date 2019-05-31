package com.example.wait.democopsboot.infrastructure.json;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.example.wait.orm.jpa.EntityId;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class EntityIdJsonSerializer extends JsonSerializer<EntityId> {

	@Override
	public void serialize(EntityId entityId, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeString(entityId.asString());
	}

}
