package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalTimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {

	@Override
	public JsonElement serialize(LocalTime time, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}

	@Override
	public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
