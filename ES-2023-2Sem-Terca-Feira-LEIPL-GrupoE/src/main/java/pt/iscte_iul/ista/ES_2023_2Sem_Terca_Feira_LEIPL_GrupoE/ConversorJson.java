/**
 * Classe ConversorJson responsável pela conversão de objetos Aula para formato JSON e vice-versa.
 * Utiliza a biblioteca Gson do Google para realizar a conversão.
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ConversorJson {

    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(LocalTime.class, 
    		new LocalTimeAdapter()).setPrettyPrinting().create();

    /**
     * Método para gravar uma lista de objetos Aula em um arquivo JSON.
     *
     * @param aulas    Lista de objetos Aula a serem gravados no arquivo.
     * @param filePath Caminho do arquivo JSON onde os dados serão gravados.
     * @throws IOException Se ocorrer um erro durante a gravação do arquivo.
     */
    public static void gravarEmArquivoJSON(List<Aula> aulas, String filePath) throws IOException {
	try (Writer writer = new FileWriter(filePath)) {
	    gson.toJson(aulas, writer);
	}
    }

    /**
     * Método para carregar uma lista de objetos Aula a partir de um arquivo JSON.
     *
     * @param filePath Caminho do arquivo JSON a ser lido.
     * @return Uma lista de objetos Aula extraídos do arquivo JSON.
     * @throws IOException Se ocorrer um erro durante a leitura do arquivo.
     */
    public static List<Aula> carregarDeArquivoJSON(String filePath) throws IOException {
	try (Reader reader = new FileReader(filePath)) {
	    Type listType = new TypeToken<List<Aula>>() {
	    }.getType();
	    return gson.fromJson(reader, listType);
	}
    }
}