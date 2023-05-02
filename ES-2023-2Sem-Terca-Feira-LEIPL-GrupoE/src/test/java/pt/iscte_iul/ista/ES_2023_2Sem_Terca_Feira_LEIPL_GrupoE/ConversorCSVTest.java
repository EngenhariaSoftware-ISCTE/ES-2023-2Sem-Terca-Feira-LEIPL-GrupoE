package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.opencsv.exceptions.CsvException;

/**
 * 
 * @author Vítor Hugo Ferreira Teixeira
 *
 */

public class ConversorCSVTest {

    private static final String TEST_CSV_FILE = "test.csv";


	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */



    @Test
    public void testEscreveCSV() throws IOException, CsvException {
	// create a new Horario object and add some Aulas to it
	Horario horario = new Horario();
	Aula aula1 = new Aula("LEI", "POO", "TP1", "A", 50, "Segunda", LocalTime.of(9, 0), LocalTime.of(10, 30),
		LocalDate.of(2023, 5, 1), "C01", 40);
	Aula aula2 = new Aula("LEI", "BD", "T01", "A", 40, "Quarta", LocalTime.of(14, 0), LocalTime.of(15, 30),
		LocalDate.of(2023, 5, 3), "C02", 0);
	horario.adicionaAula(aula1);
	horario.adicionaAula(aula2);

	// write the Horario to the CSV file
	ConversorCSV.escreveCSV(horario, TEST_CSV_FILE);

	// read the CSV file back in and verify that its contents match the original
	// Horario
	Horario hor = ConversorCSV.lerCSVParaEstrutura(TEST_CSV_FILE);

	Assertions.assertEquals(2, hor.getAulas().size()); // 1 header row and 2 data rows

	// check the first data row
	Aula aula4 = hor.getAulas().get(1);
	Assertions.assertEquals(aula2.displayEntry(), aula4.displayEntry());

	Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }

}
