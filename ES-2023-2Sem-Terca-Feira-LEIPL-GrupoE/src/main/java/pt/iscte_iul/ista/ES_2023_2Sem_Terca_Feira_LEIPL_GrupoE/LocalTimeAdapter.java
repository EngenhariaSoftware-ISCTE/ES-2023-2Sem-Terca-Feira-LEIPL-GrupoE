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

/**
 * @author Luis Rosa Classe adaptadora para serializar e desserializar objetos
 *         do tipo LocalTime usando o formato "HH:mm:ss".
 */
public class LocalTimeAdapter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {

    /**
     * Serializa um objeto LocalTime em uma representação JSON.
     *
     * @param time      o objeto LocalTime a ser serializado
     * @param typeOfSrc o tipo do objeto de origem
     * @param context   o contexto de serialização
     * @return o elemento JSON que representa o objeto LocalTime
     */
    @Override
    public JsonElement serialize(LocalTime time, Type typeOfSrc, JsonSerializationContext context) {
	return new JsonPrimitive(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    /**
     * Desserializa um elemento JSON em um objeto LocalTime.
     *
     * @param json    o elemento JSON a ser desserializado
     * @param typeOfT o tipo do objeto de destino
     * @param context o contexto de desserialização
     * @return o objeto LocalTime desserializado
     * @throws JsonParseException se ocorrer um erro durante a desserialização
     */
    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {
	return LocalTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
