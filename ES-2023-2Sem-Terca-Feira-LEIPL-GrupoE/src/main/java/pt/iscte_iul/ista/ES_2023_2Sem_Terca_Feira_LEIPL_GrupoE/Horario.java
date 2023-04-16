package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *@autor Luis Viriato
 * Gera um horário que é uma lista de objetos Aula.
 * Possui métodos para adicionar e remover obj Aula.
 * Possui métodos para ordenar o Horário com base nos diversos argumentos da classe Aula
 * Possui métodos para filtrar Auila por dia, mês e ano.
 * Possui ainda um getter do horário.
 * 	
 * */

public class Horario {
    private List<Aula> horario;

    public Horario() {
        this.horario = new ArrayList<>();
    }

    
    
    // Adiciona uma aula ao horário
    public void adicionaAula(Aula aula) {
        this.horario.add(aula);
    }

    // Remove uma aula do horário
    public void removeAula(Aula aula) {
        this.horario.remove(aula);
    }

    // Ordena aulas por uc
    public void ordenaPorUC() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getUC));
    }

    // Ordena aulas por curso
    public void ordenaPorCurso() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getCurso));
    }

    // Ordena aulas por turno
    public void ordenaPorTurno() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getTurno));
    }

    // Ordena aulas por turma
    public void ordenaPorTurma() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getTurma));
    }

    // Ordena aulas por número de inscritos
    public void ordenaPorInscritos() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getInscritos));
    }

    // Ordena aulas por dia
    public void ordenaPorDia() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getDia));
    }

    // Ordena aulas por hora de início
    public void ordenaPorHoraInicio() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getHoraInicio));
    }

    // Ordena aulas por hora de fim
    public void ordenaPorHoraFim() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getHoraFim));
    }

    // Ordena aulas por data
    public void ordenaPorData() {
    	Collections.sort(this.horario, Comparator.comparing(Aula::getData));
    }

    // Ordena aulas por sala
    public void ordenaPorSala() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getSala));
    }

    // Ordena aulas por lotação
    public void ordenaPorLotacao() {
        Collections.sort(this.horario, Comparator.comparing(Aula::getLotacao));
    }

 // Filtra as aulas por um dia específico
    public List<Aula> filtraPorDia(LocalDate dia) {
        List<Aula> aulasDoDia = new ArrayList<>();
        for (Aula aula : this.horario) {
            if (aula.getData().equals(dia)) {
                aulasDoDia.add(aula);
            }
        }
        return aulasDoDia;
    }

    // Filtra as aulas por uma semana específica
    public List<Aula> filtraPorSemana(LocalDate inicioSemana, LocalDate fimSemana) {
        List<Aula> aulasDaSemana = new ArrayList<>();
        for (Aula aula : this.horario) {
            if (aula.getData().isAfter(inicioSemana.minusDays(1)) && aula.getData().isBefore(fimSemana.plusDays(1))) {
                aulasDaSemana.add(aula);
            }
        }
        return aulasDaSemana;
    }
    
    // Filtra as aulas por um mês específico
    public List<Aula> filtraPorMes(int mes) {
        List<Aula> aulasDoMes = new ArrayList<>();
        for (Aula aula : this.horario) {
            if (aula.getData().getMonthValue() == mes) {
                aulasDoMes.add(aula);
            }
        }
        return aulasDoMes;
    }
   
    // Retorna todas as aulas do horário
    public List<Aula> getAulas() {
        return this.horario;
    }

}

