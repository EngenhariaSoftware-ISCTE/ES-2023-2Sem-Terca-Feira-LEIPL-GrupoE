package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe Horario representa um horário que é uma lista de objetos Aula. Possui
 * métodos para adicionar e remover objetos Aula, ordenar o horário com base em
 * diferentes critérios da classe Aula, filtrar aulas por dia, mês e ano, e
 * fornecer acesso às aulas do horário.
 * 
 * @author Luis
 */
public class Horario {

    private List<Aula> horario;

    /**
     * Construtor da classe Horario.
     */
    public Horario() {
	this.horario = new ArrayList<>();
    }

    /**
     * Adiciona uma aula ao horário.
     * 
     * @param aula a aula a ser adicionada
     */
    public void adicionaAula(Aula aula) {
	this.horario.add(aula);
    }

    /**
     * Remove uma aula do horário.
     * 
     * @param aula a aula a ser removida
     */
    public void removeAula(Aula aula) {
	this.horario.remove(aula);
    }

    // Métodos para ordenar o horário com base em diferentes critérios da classe
    // Aula

    /**
     * Ordena as aulas do horário por Unidade Curricular (UC).
     */
    public void ordenaPorUC() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getUC));
    }

    /**
     * Ordena as aulas do horário por Curso.
     */
    public void ordenaPorCurso() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getCurso));
    }

    /**
     * Ordena as aulas do horário por Turno.
     */
    public void ordenaPorTurno() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getTurno));
    }

    /**
     * Ordena as aulas do horário por Turma.
     */
    public void ordenaPorTurma() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getTurma));
    }

    /**
     * Ordena as aulas do horário por número de inscritos.
     */
    public void ordenaPorInscritos() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getInscritos));
    }

    /**
     * Ordena as aulas do horário por dia.
     */
    public void ordenaPorDia() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getDia));
    }

    /**
     * Ordena as aulas do horário por hora de início.
     */
    public void ordenaPorHoraInicio() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getHoraInicio));
    }

    /**
     * Ordena as aulas do horário por hora de fim.
     */
    public void ordenaPorHoraFim() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getHoraFim));
    }

    /**
     * Ordena as aulas do horário por data.
     */
    public void ordenaPorData() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getData));
    }

    /**
     * Ordena as aulas por sala.
     */
    public void ordenaPorSala() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getSala));
    }

    /**
     * Ordena as aulas por lotação.
     */
    public void ordenaPorLotacao() {
	Collections.sort(this.horario, Comparator.comparing(Aula::getLotacao));
    }

    /**
     * Filtra as aulas por um dia específico.
     *
     * @param dia O dia que serve como filtro.
     * @return Uma lista de aulas filtradas por dia.
     */
    public List<Aula> filtraPorDia(LocalDate dia) {
	List<Aula> aulasDoDia = new ArrayList<>();
	for (Aula aula : this.horario) {
	    if (aula.getData().equals(dia)) {
		aulasDoDia.add(aula);
	    }
	}
	return aulasDoDia;
    }

    /**
     * Filtra as aulas por uma semana específica.
     *
     * @param inicioSemana O dia que inicia a semana.
     * @param fimSemana    O dia do fim de semana.
     * @return Uma lista de aulas filtradas por semana.
     */
    public List<Aula> filtraPorSemana(LocalDate inicioSemana, LocalDate fimSemana) {
	List<Aula> aulasDaSemana = new ArrayList<>();
	for (Aula aula : this.horario) {
	    if (aula.getData().isAfter(inicioSemana.minusDays(1)) && aula.getData().isBefore(fimSemana.plusDays(1))) {
		aulasDaSemana.add(aula);
	    }
	}
	return aulasDaSemana;
    }

    /**
     * Filtra as aulas por um mês específico.
     *
     * @param mes O mês que filtra as aulas.
     * @return Uma lista de aulas filtradas por mês.
     */
    public List<Aula> filtraPorMes(int mes) {
	List<Aula> aulasDoMes = new ArrayList<>();
	for (Aula aula : this.horario) {
	    if (aula.getData().getMonthValue() == mes) {
		aulasDoMes.add(aula);
	    }
	}
	return aulasDoMes;
    }

    /**
     * Retorna todas as aulas do horário.
     *
     * @return Uma lista de todas as aulas do horário.
     */
    public List<Aula> getAulas() {
	return this.horario;
    }

    /*
     * Método que reescreve o toString
     */
    @Override
    public String toString() {
	return "Horario [horario=" + horario + "]";
    }

    /**
     * Método que retorna as ucs do horário. feature 4.1 do projeto
     * 
     * @return List com as UCs do horário.
     */
    public List<String> listaUCs() {
	List<String> ucs = new ArrayList<>();
	for (Aula aula : this.getAulas()) {
	    if (!ucs.contains(aula.getUC())) {
		ucs.add(aula.getUC());
	    }
	}
	return ucs;
    }

    /**
     * Retorna uma lista de aulas que estão em sobreposição de horário.
     *
     * @return List uma lista de aulas em sobreposição
     */
    public List<Aula> getAulasEmSobreposicao() {
	List<Aula> aulasEmSobreposicao = new ArrayList<>();
	int totalAulas = horario.size();

	for (int i = 0; i < totalAulas - 1; i++) {
	    Aula aula1 = horario.get(i);

	    for (int j = i + 1; j < totalAulas; j++) {
		Aula aula2 = horario.get(j);

		if (aula1.getData().equals(aula2.getData()) && isIntervaloCruzado(aula1, aula2)) {
		    addAulaToListIfNotPresent(aula1, aulasEmSobreposicao);
		    addAulaToListIfNotPresent(aula2, aulasEmSobreposicao);
		}
	    }
	}

	return aulasEmSobreposicao;
    }

    /**
     * Verifica se o intervalo de tempo de duas aulas está cruzado.
     *
     * @param aula1 a primeira aula
     * @param aula2 a segunda aula
     * @return true se os intervalos de tempo se cruzam, false caso contrário
     */
    private boolean isIntervaloCruzado(Aula aula1, Aula aula2) {
	return aula1.getHoraInicio().isBefore(aula2.getHoraFim()) && aula2.getHoraInicio().isBefore(aula1.getHoraFim());
    }

    /**
     * Adiciona uma aula à lista se ela não estiver presente.
     *
     * @param aula                a aula a ser adicionada
     * @param aulasEmSobreposicao a lista de aulas em sobreposição
     */
    private void addAulaToListIfNotPresent(Aula aula, List<Aula> aulasEmSobreposicao) {
	if (!aulasEmSobreposicao.contains(aula)) {
	    aulasEmSobreposicao.add(aula);
	}
    }

    /**
     * Retorna uma lista contendo todas as aulas que possuem lotação esgotada, ou
     * seja, o número de inscritos é igual à lotação máxima da aula.
     * 
     * @return lista de aulas com lotação esgotada
     */
    public List<Aula> getAulasComLotacaoEsgotada() {
	List<Aula> aulasComLotacaoEsgotada = new ArrayList<>();
	for (Aula aula : horario) {
	    if (aula.getInscritos() >= aula.getLotacao()) {
		aulasComLotacaoEsgotada.add(aula);
	    }
	}
	return aulasComLotacaoEsgotada;
    }

}
