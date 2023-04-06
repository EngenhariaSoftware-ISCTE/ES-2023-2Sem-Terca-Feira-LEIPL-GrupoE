package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class ConversorJson {

    private static final Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").setPrettyPrinting().create();

    public static void gravarEmArquivoJSON(List<Aula> aulas, String filePath) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(aulas, writer);
        }
    }

    public static List<Aula> carregarDeArquivoJSON(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Aula>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        }
    }
}