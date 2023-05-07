package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;

public class ToICalendarTest {

    @Test
    public void testConvertStringToICalendar() {
	String iCalendarData = "BEGIN:VCALENDAR\r\n" + "PRODID:-//ISCTE-IUL//fenix//EN\r\n" + "VERSION:2.0\r\n"
		+ "CALSCALE:GREGORIAN\r\n" + "X-WR-CALNAME:lfran@iscte.pt_iscte-iul\r\n" + "BEGIN:VEVENT\r\n"
		+ "UID:2023-04-29T16:30:00Z\r\n" + "DTSTAMP:20230429T163000Z\r\n" + "DTSTART:20230429T163000Z\r\n"
		+ "DTEND:20230429T183000Z\r\n" + "SUMMARY:Example Event\r\n" + "LOCATION:Example Location\r\n"
		+ "END:VEVENT\r\n" + "END:VCALENDAR\r\n";

	try {
	    Calendar calendar = ToICalendar.convertStringToICalendar(iCalendarData);

	    assertNotNull(calendar);
	    assertEquals(1, calendar.getComponents(Component.VEVENT).size());

	    Optional<VEvent> eventOptional = calendar.getComponents(Component.VEVENT).stream()
		    .filter(component -> component instanceof VEvent).map(component -> (VEvent) component).findFirst();

	    assertTrue(eventOptional.isPresent());
	    VEvent event = eventOptional.get();
	    assertNotNull(event);
	    // print dstamp
	    System.out.println(event.getEndDate().get().getDate().getClass());
	    assertEquals("Example Event", event.getProperty("SUMMARY").get().getValue());
	    assertEquals("Example Location", event.getProperty("LOCATION").get().getValue());

	} catch (Exception e) {
	    fail("Exception occurred during test: " + e.getMessage());
	}
    }
}