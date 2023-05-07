package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.util.List;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

/**
 * @autor Tatiana Clim Classe responsável por representar um calendário de
 *        aulas. Utiliza a biblioteca CalendarFX para criar e gerenciar as
 *        entradas do calendário.
 */

public class Calendario {
    private static Calendar<Aula> calendar = new Calendar<>("Calendar");

    /**
     * Adiciona as aulas contidas em um objeto Horario ao calendário.
     * 
     * @param horario objeto Horario contendo as informações das aulas a serem
     *                adicionadas ao calendário
     */
    public static void addHorarioAoCalendario(Horario horario) {
	System.out.println(horario.toString());
	for (Aula aula : horario.getAulas()) {

	    Entry<Aula> entry = new Entry<>(aula.getUC());
	    entry.setUserObject(aula);
	    entry.changeStartDate(aula.getData());
	    entry.changeEndDate(aula.getData());
	    entry.setInterval(aula.getHoraInicio(), aula.getHoraFim());

	    List<Aula> aulasEmSobreposicao = horario.getAulasEmSobreposicao();
	    List<Aula> aulasSobrelotadas = horario.getAulasComLotacaoEsgotada();
	    if (!aulasEmSobreposicao.isEmpty() && aulasEmSobreposicao.contains(aula)
		    || !aulasSobrelotadas.isEmpty() && aulasSobrelotadas.contains(aula)) {
		entry.getStyleClass().add("minha-classe-de-estilo");
	    }
	    calendar.addEntry(entry);
	}
    }

    /**
     * Retorna o calendário de aulas.
     * 
     * @return objeto Calendar<Aula> contendo as aulas adicionadas ao calendário
     */
    public static Calendar<Aula> getCalendar() {
	return calendar;
    }
}
