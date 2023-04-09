package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConversorJsonTest {

    @Test
    public void testGravarEmArquivoJson() throws IOException {
        List<Aula> aulas = new ArrayList<>();
        Aula aula1 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex", "13:00:00", "14:30:00", "02/12/2022", "AA2.25", 34);

        aulas.add(aula1);

        String filePath = "test_aulas.json";

        ConversorJson.gravarEmArquivoJSON(aulas, filePath);

        assertTrue(Files.exists(Paths.get(filePath)));

        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testCarregarDeArquivoJson() throws IOException {
        List<Aula> aulas = new ArrayList<>();
        Aula aula1 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex", "13:00:00", "14:30:00", "02/12/2022", "AA2.25", 34);
        Aula aula2 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex", "14:30:00", "17:00:00", "02/12/2022", "AA2.25", 34);

        aulas.add(aula1);
        aulas.add(aula2);
        String filePath = "test_aulas.json";

        ConversorJson.gravarEmArquivoJSON(aulas, filePath);
        List<Aula> aulasCarregadas = ConversorJson.carregarDeArquivoJSON(filePath);

        assertEquals(2,aulasCarregadas.size());
        Aula aulaCarregada = aulasCarregadas.get(0);
        Aula aulaCarregada2 = aulasCarregadas.get(1);


        assertEquals(aula1.getNome(), aulaCarregada.getNome());
        assertEquals(aula1.getCurso(), aulaCarregada.getCurso());
        assertEquals(aula1.getTurno(), aulaCarregada.getTurno());
        assertEquals(aula1.getTurma(), aulaCarregada.getTurma());
        assertEquals(aula1.getInscritos(), aulaCarregada.getInscritos());
        assertEquals(aula1.getDia(), aulaCarregada.getDia());
        assertEquals(aula1.getHora_inicio(), aulaCarregada.getHora_inicio());
        assertEquals(aula1.getHora_fim(), aulaCarregada.getHora_fim());
        assertEquals(aula1.getData(), aulaCarregada.getData());
        assertEquals(aula1.getSala(), aulaCarregada.getSala());
        assertEquals(aula1.getLotacao(), aulaCarregada.getLotacao());

        assertEquals(aula2.getNome(), aulaCarregada2.getNome());
        assertEquals(aula2.getCurso(), aulaCarregada2.getCurso());
        assertEquals(aula2.getTurno(), aulaCarregada2.getTurno());
        assertEquals(aula2.getTurma(), aulaCarregada2.getTurma());
        assertEquals(aula2.getInscritos(), aulaCarregada2.getInscritos());
        assertEquals(aula2.getDia(), aulaCarregada2.getDia());
        assertEquals(aula2.getHora_inicio(), aulaCarregada2.getHora_inicio());
        assertEquals(aula2.getHora_fim(), aulaCarregada2.getHora_fim());
        assertEquals(aula2.getData(), aulaCarregada2.getData());
        assertEquals(aula2.getSala(), aulaCarregada2.getSala());
        assertEquals(aula2.getLotacao(), aulaCarregada2.getLotacao());

        Files.deleteIfExists(Paths.get(filePath));

    }
}