package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

class ConversorCSVTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCSV() throws CsvException {
		
		Horario h = ConversorCSV.lerCSVParaEstrutura("C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-exemplo.csv");
		ConversorCSV.escreveCSV(h, "C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste.csv");
		Horario h1 = ConversorCSV.lerCSVParaEstrutura("C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste.csv");
		//ConversorCSV.escreveCSV(h1, "C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste2.csv");
		//Horario h2 = ConversorCSV.lerCSVParaEstrutura("C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste2.csv");
		assertEquals(h.getAulas().get(0).getCurso(),h1.getAulas().get(0).getCurso());
	}

}
