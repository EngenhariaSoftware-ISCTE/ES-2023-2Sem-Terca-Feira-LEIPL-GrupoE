package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

public class CriarNovoHorarioTest {

    @Test
    public void testCriarNovoHorario() throws CsvException {
	String s1 = "Engenharia de Software";
	String s2 = "Estatística Computacional";
	Horario h = ConversorCSV.lerCSVParaEstrutura("./Ficheiros/horario_bemFormatado_Final.csv");
	List<String> l = new ArrayList<>();
	l.add(s1);
	l.add(s2);
	Horario h1 = CriarNovoHorario.criarHorario(h, l);
	assertEquals(h1.getAulas().get(0).getUC(), s1);
	assertEquals(h1.getAulas().get(h1.getAulas().size() - 1).getUC(), s2);
    }

}
