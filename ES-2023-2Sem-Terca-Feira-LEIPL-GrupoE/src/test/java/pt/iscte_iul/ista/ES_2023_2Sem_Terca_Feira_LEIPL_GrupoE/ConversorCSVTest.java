package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvException;

/**
 * 
 * @author Vítor Hugo Ferreira Teixeira
 *
 */

class ConversorCSVTest {

    /*
     * @Test void test() { fail("Not yet implemented"); }
     */

    @Test
    public void testCSV() throws CsvException {

	Horario h = ConversorCSV.lerCSVParaEstrutura(
		"C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-exemplo.csv");
	ConversorCSV.escreveCSV(h,
		"C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste.csv");
	Horario h1 = ConversorCSV.lerCSVParaEstrutura(
		"C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-teste.csv");

	assertEquals(h.getAulas().get(123).getCurso(), h1.getAulas().get(123).getCurso());
    }

    /*
     * @Test public void testLocalizacaoFicheiro() throws CsvException {
     * assertNull(ConversorCSV.
     * lerCSVParaEstrutura("C:\\Users\\vitor\\Documents\\Licenciatura em Engenharia Informatica ISCTE\\2022-2023\\ES\\Projeto\\OLD\\horario-nulo.csv"
     * )); }
     */

}
