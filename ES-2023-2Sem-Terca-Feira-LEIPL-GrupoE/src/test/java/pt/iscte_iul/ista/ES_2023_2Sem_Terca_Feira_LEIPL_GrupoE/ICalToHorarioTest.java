package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

public class ICalToHorarioTest {

    @Test
    public void testConvertCalendarToHorario() throws Exception {
	String icalString = "BEGIN:VCALENDAR\n" + "BEGIN:VEVENT\n" + "SUMMARY:Example Event\n"
		+ "LOCATION:C5.08\\, 5\\, Edifício II (ISCTE-IUL)\\, ISCTE-IUL\n" + "DTSTART:20230430T090000Z\n"
		+ "DTEND:20230430T100000Z\n"
		+ "DESCRIPTION:Semestre: 2022/2023 - 2.º Semestre Unidade de execução: Interação Pessoa-Máquina Código: L5316 Turno: L5316TP03 Início: 2023-03-27 19:30 Fim: 2023-03-27 21:00 Docente: Pedro Cláudio de Faria Lopes Semester: 2022/2023 - 2.º Semestre Execution course: Human-Computer Interaction Code: L5316 Shift: L5316TP03 Begin: 2023-03-27 19:30 End: 2023-03-27 21:00  Teacher: Pedro Cláudio de Faria Lopes\r\n"
		+ "END:VEVENT\n" + "END:VCALENDAR";

	CalendarBuilder builder = new CalendarBuilder();
	Calendar calendar = builder.build(new StringReader(icalString));

	Horario horario = ICalToHorario.convertCalendarToHorario(calendar);

	Aula aula = horario.getAulas().get(0);

	// Set Portugal timezone
	ZoneId portugalZone = ZoneId.of("Europe/Lisbon");

	// Convert LocalDate to Portugal timezone
	LocalDate portugalDate = LocalDate.of(2023, 4, 30).atStartOfDay(portugalZone).toLocalDate();

	// Convert LocalTime to Portugal timezone
	LocalTime portugalStartTime = LocalTime.of(9, 0).atDate(portugalDate).atZone(portugalZone).toLocalTime();
	LocalTime portugalEndTime = LocalTime.of(10, 0).atDate(portugalDate).atZone(portugalZone).toLocalTime();

	assertEquals("Example Event", aula.getUC());
	assertEquals("C5.08, 5, Edifício II (ISCTE-IUL), ISCTE-IUL", aula.getSala());
	assertEquals("L5316TP03", aula.getTurno());

	assertEquals(portugalDate, aula.getData());
	assertEquals(portugalStartTime, aula.getHoraInicio());
	assertEquals(portugalEndTime, aula.getHoraFim());

	assertEquals("Dom", aula.getDia());
    }
}