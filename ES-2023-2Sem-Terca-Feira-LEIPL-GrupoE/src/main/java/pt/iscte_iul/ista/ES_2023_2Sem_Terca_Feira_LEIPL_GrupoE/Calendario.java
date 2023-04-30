package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

/**
 * @autor Tatiana Clim Classe responsável por representar um calendário de
 *        aulas. Utiliza a biblioteca CalendarFX para criar e gerenciar as
 *        entradas do calendário.
 */

public class Calendario {
    public static Calendar<Aula> calendario = new Calendar<>("Calendar");

    /**
     * Adiciona as aulas contidas em um objeto Horario ao calendário.
     * 
     * @param horario objeto Horario contendo as informações das aulas a serem
     *                adicionadas ao calendário
     */
    public static void addHorarioAoCalendario(Horario horario) {
	for (Aula aula : horario.getAulas()) {
	    Entry<Aula> entry = new Entry<>(aula.displayEntry());
	    entry.setUserObject(aula);
	    entry.changeStartDate(aula.getData());
	    entry.changeEndDate(aula.getData());
	    entry.setInterval(aula.getHoraInicio(), aula.getHoraFim());
	    
	    calendario.addEntry(entry);
	}
    }

    /**
     * Retorna o calendário de aulas.
     * 
     * @return objeto Calendar<Aula> contendo as aulas adicionadas ao calendário
     */
    public static Calendar<Aula> getCalendar() {
	return calendario;
    }
}
