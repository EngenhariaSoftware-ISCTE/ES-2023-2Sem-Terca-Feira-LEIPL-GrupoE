package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

/**
 * Classe responsável por representar um calendário de aulas. Utiliza a
 * biblioteca CalendarFX para criar e gerenciar as entradas do calendário.
 */

public class Calendario {
    private static Calendar<Aula> calendario;

    /**
     * Construtor da classe Calendario. Recebe um objeto Horario e cria um
     * calendário de aulas com base nas informações contidas no horário.
     * 
     * @param horario objeto Horario contendo as informações das aulas a serem
     *                adicionadas ao calendário
     */
    public Calendario(Horario horario) {
	calendario = new Calendar<>("Calendar");
	addHorarioAoCalendario(horario);
    }

    /**
     * Adiciona as aulas contidas em um objeto Horario ao calendário.
     * 
     * @param horario objeto Horario contendo as informações das aulas a serem
     *                adicionadas ao calendário
     */
    public void addHorarioAoCalendario(Horario horario) {
	for (Aula aula : horario.getAulas()) {
	    Entry<Aula> entry = new Entry<>(aula.getUC());
	    entry.setUserObject(aula);
	    entry.setInterval(aula.getHoraInicio(), aula.getHoraFim());
	    calendario.addEntry(entry);
	}
    }

    /**
     * Retorna o calendário de aulas.
     * 
     * @return objeto Calendar<Aula> contendo as aulas adicionadas ao calendário
     */
    public Calendar<Aula> getCalendar() {
	return calendario;
    }
}
