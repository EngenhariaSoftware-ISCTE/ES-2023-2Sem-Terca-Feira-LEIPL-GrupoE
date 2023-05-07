package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.lang.reflect.Type;
import java.time.LocalDate;
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
 *         do tipo LocalDate usando o formato "dd/MM/yyyy".
 */
class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    /**
     * Serializa um objeto LocalDate em uma representação JSON.
     *
     * @param date      o objeto LocalDate a ser serializado
     * @param typeOfSrc o tipo do objeto de origem
     * @param context   o contexto de serialização
     * @return o elemento JSON que representa o objeto LocalDate
     */
    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
	return new JsonPrimitive(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    /**
     * Desserializa um elemento JSON em um objeto LocalDate.
     *
     * @param json    o elemento JSON a ser desserializado
     * @param typeOfT o tipo do objeto de destino
     * @param context o contexto de desserialização
     * @return o objeto LocalDate desserializado
     * @throws JsonParseException se ocorrer um erro durante a desserialização
     */
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	    throws JsonParseException {
	return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
