package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

import java.io.StringReader;

public class StringToICalendar {

    public static Calendar convertStringToICalendar(String iCalendarData) throws Exception {
        try (StringReader reader = new StringReader(iCalendarData)) {
            CalendarBuilder builder = new CalendarBuilder();
            return builder.build(reader);
        }
    }
}
