package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.calendarfx.model.Entry;

/**
 * @author Tatiana
 *
 */
public class CalendarioTest {

	/*
	 * @Test public void testAddHorarioAoCalendario() { Aula aula1 = new Aula("ME",
	 * "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
	 * LocalTime.parse("13:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
	 * LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
	 * LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	 * "AA2.25", 34); Aula aula2 = new Aula("ME",
	 * "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
	 * LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
	 * LocalTime.parse("17:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
	 * LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	 * "AA2.25", 34);
	 * 
	 * Horario horario = new Horario(); horario.adicionaAula(aula1);
	 * horario.adicionaAula(aula2); /* Calendario calendario = new
	 * Calendario(horario); List<Entry<?>> entries =
	 * calendario.getCalendar().findEntries(aula1.getUC());
	 * 
	 * // Verifique se as aulas foram adicionadas corretamente ao calendário
	 * Assertions.assertEquals(horario.getAulas().size(), entries.size());
	 */
	// }

	@Test
	public void testAddHorarioAoCalendario() {
		// Cria um objeto Horario com duas aulas
		Aula aula1 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
				LocalTime.parse("13:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "AA2.25", 34);
		Aula aula2 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
				LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalTime.parse("17:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
				LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "AA2.25", 34);

		Horario horario = new Horario();
		horario.adicionaAula(aula1);
		horario.adicionaAula(aula2);

		// Adiciona as aulas ao calendário
		Calendario.addHorarioAoCalendario(horario);

		// Verifica se as entradas foram adicionadas corretamente
		List<Entry<?>> entries = Calendario.getCalendar().findEntries(aula1.getUC());
		Assertions.assertEquals(horario.getAulas().size(), entries.size());

	}

	// @Test
	// public void testGetCalendar() {
	// assertNotNull(Calendario.getCalendar());
	// assertEquals("Calendar", Calendario.getCalendar().getName());

	// }
}