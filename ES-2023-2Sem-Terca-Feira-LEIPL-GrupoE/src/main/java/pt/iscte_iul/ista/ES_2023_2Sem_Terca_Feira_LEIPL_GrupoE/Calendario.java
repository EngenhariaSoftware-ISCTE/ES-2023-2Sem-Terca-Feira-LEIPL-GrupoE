package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;

/**
 * @author Tatiana Clim Classe responsável por representar um calendário de
 *         aulas. Utiliza a biblioteca CalendarFX para criar e gerenciar as
 *         entradas do calendário.
 */

public class Calendario {
    private static Calendar<Aula> calendar = new Calendar<>("Calendar");

    private static List<Aula> getSobrelotacaoSobreposicao(Horario horario) {
	List<Aula> aulasEmSobreposicao = horario.getAulasEmSobreposicao();
	List<Aula> aulasSobrelotadas = horario.getAulasComLotacaoEsgotada();

	List<Aula> aulasConcatenadas = new ArrayList<>();

	// Adicionar todas as aulasEmSobreposicao à lista concatenada
	aulasConcatenadas.addAll(aulasEmSobreposicao);

	// Converter aulasSobrelotadas em um HashSet para remover duplicatas
	Set<Aula> setAulasSobrelotadas = new HashSet<>(aulasSobrelotadas);

	// Adicionar as aulasSobrelotadas à lista concatenada, ignorando duplicatas
	aulasConcatenadas.addAll(setAulasSobrelotadas);

	// Opcional: converter aulasConcatenadas de volta para uma lista, se necessário
	return new ArrayList<>(aulasConcatenadas);
    }

    /**
     * Adiciona as aulas contidas em um objeto Horario ao calendário.
     * 
     * @param horario objeto Horario contendo as informações das aulas a serem
     *                adicionadas ao calendário
     */
    public static void addHorarioAoCalendario(Horario horario) {
	List<Aula> aulas = getSobrelotacaoSobreposicao(horario);

	for (Aula aula : horario.getAulas()) {

	    Entry<Aula> entry = new Entry<>(aula.displayEntry());
	    entry.setUserObject(aula);
	    entry.changeStartDate(aula.getData());
	    entry.changeEndDate(aula.getData());
	    entry.setInterval(aula.getHoraInicio(), aula.getHoraFim());

	    if (!aulas.isEmpty() && aulas.contains(aula)) {
		entry.getStyleClass().add("minha-classe-de-estilo");
	    } else {
		entry.getStyleClass().add("classe-padrao");
	    }

	    calendar.addEntry(entry);
	}
    }

    /**
     * Retorna o calendário de aulas.
     * 
     * @return objeto Calendar contendo as aulas adicionadas ao calendário
     */
    public static Calendar<Aula> getCalendar() {
	return calendar;
    }
}
