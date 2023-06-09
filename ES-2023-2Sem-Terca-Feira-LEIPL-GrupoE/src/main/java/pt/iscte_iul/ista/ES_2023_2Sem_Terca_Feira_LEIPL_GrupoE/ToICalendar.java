package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

/**
 * @author Luis Rosa Classe ToICalendar responsável por converter uma String em
 *         um objeto Calendar (ical4j).
 */
public class ToICalendar {
    /**
     * Converte uma String com dados no formato iCalendar em um objeto Calendar
     * (ical4j).
     *
     * @param iCalendarData String contendo os dados no formato iCalendar
     * @return Objeto Calendar do ical4j com os dados convertidos
     * @throws Exception Lança uma exceção em caso de erro na conversão
     */
    public static Calendar convertStringToICalendar(String iCalendarData) throws Exception {
	try (ByteArrayInputStream inputStream = new ByteArrayInputStream(
		iCalendarData.getBytes(StandardCharsets.UTF_8));
		InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
	    CalendarBuilder builder = new CalendarBuilder();
	    return builder.build(reader);
	}
    }
}
