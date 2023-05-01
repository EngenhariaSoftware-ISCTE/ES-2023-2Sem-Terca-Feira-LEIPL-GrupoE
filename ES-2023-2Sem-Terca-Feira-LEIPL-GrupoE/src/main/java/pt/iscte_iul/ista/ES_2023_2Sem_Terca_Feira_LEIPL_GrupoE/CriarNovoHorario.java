package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.util.List;

/**
 * 
 * @author Vítor Hugo Ferreira Teixeira 
 * Classe responsável por implementar
 * método de criação de novo horário de acordo com escolha de ucs por
 * parte de aluno
 */

public class CriarNovoHorario {

	/**
	 * 
	 * @param hor - recebe um Horário com todas as aulas de todas as ucs
	 * @param ucs - recebe uma lista com as ucs escolhidas pelo(a) aluno(a)
	 * @return h - retorna um horário com as aulas das usc escolhidas pelo(a)
	 *         aluno(a)
	 */

	// Personalizar horario segundo escolha da UC
	public static Horario criarHorario(Horario hor, List<String> ucs) {

		Horario h = new Horario();

		for (int i = 0; i < ucs.size(); i++) {

			for (int j = 0; j < hor.getAulas().size(); j++) {

				if (ucs.get(i).equalsIgnoreCase(hor.getAulas().get(j).getUC())) {
					h.adicionaAula(hor.getAulas().get(j));
					// System.out.println(j);
				}
			}
		}

		return h;
	}

}
