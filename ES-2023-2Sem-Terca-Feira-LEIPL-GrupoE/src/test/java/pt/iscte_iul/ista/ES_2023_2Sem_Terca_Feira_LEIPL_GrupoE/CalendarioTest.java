package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

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

    @Test
    public void testAddHorarioAoCalendario() {
	Horario horario = new Horario();
	Calendario.getCalendar().clear();
	// Cria um objeto Horario com duas aulas
	Aula aula1 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
		LocalTime.parse("13:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
		LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
		LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "AA2.25", 34);

	horario.adicionaAula(aula1);

	// Adiciona as aulas ao calendário
	Calendario.addHorarioAoCalendario(horario);

	// Verifica se as entradas foram adicionadas corretamente
	List<Entry<?>> entries = Calendario.getCalendar().findEntries(aula1.displayEntry());
	System.out.println(horario.getAulas().size());
	System.out.println(entries.size());
	Assertions.assertEquals(horario.getAulas().size(), entries.size());
	horario = null;
    }

    @Test
    public void testGetCalendar() {
	Calendario.getCalendar().clear();
	Aula aula2 = new Aula("ME", "Teoria dos Jogos e dos Contratos", "01789TP01", "MEA1", 30, "Sex",
		LocalTime.parse("14:30:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
		LocalTime.parse("17:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")),
		LocalDate.parse("02/12/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "AA2.25", 34);

	Horario horario = new Horario();
	horario.adicionaAula(aula2);

	// Adiciona as aulas ao calendário
	Calendario.addHorarioAoCalendario(horario);
	Assertions.assertNotNull(Calendario.getCalendar());
	Assertions.assertEquals("Calendar", Calendario.getCalendar().getName());
	horario = null;
    }

}