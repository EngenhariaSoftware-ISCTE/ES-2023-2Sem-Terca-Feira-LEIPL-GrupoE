package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @autor Tatiana Clim
 * 
 */
class CalendarioTest {

    private Horario horario;
    private Calendario calendario;

    @BeforeEach
    void setUp() {
        horario = new Horario();
        calendario = new Calendario(horario);
    }

    @Test
    void testConstrutor() {
        assertNotNull(calendario.getCalendar());
        assertEquals("Calendar", calendario.getCalendar().getName());
    }

    @Test
    void testAddHorarioAoCalendario() {
    }

    @Test
    void testGetCalendar() {
        assertNotNull(calendario.getCalendar());
        assertEquals("Calendar", calendario.getCalendar().getName());
    }

}

