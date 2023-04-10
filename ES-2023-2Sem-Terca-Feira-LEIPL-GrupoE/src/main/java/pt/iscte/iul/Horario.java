package pt.iscte.iul;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Gera um horário que é uma lista de objetos Aula.
 * Possui métodos para adicionar e remover obj Aula.
 * Possui métodos para ordenar o Horário com base nos diversos argumentos da classe Aula
 * Possui métodos para filtrar Auila por dia, mês e ano.
 * Possui ainda um getter do horário.
 * 	
 * */
public class Horario {
    private List<Aula> aulas;

    public Horario() {
        this.aulas = new ArrayList<>();
    }

    // Adiciona uma aula ao horário
    public void adicionaAula(Aula aula) {
        this.aulas.add(aula);
    }

    // Remove uma aula do horário
    public void removeAula(Aula aula) {
        this.aulas.remove(aula);
    }

    // Ordena as aulas por nome
    public void ordenaPorNome() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getNome));
    }

    // Ordena as aulas por curso
    public void ordenaPorCurso() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getCurso));
    }

    // Ordena as aulas por turno
    public void ordenaPorTurno() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getTurno));
    }

    // Ordena as aulas por turma
    public void ordenaPorTurma() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getTurma));
    }

    // Ordena as aulas por número de inscritos
    public void ordenaPorInscritos() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getInscritos));
    }

    // Ordena as aulas por dia
    public void ordenaPorDia() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getDia));
    }

    // Ordena as aulas por hora de início
    public void ordenaPorHoraInicio() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getHora_inicio));
    }

    // Ordena as aulas por hora de fim
    public void ordenaPorHoraFim() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getHora_fim));
    }

    // Ordena as aulas por data
    public void ordenaPorData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     //   Collections.sort(this.aulas, Comparator.comparing(aula -> LocalDate.parse(aula.getData(), formatter)));
    }

    // Ordena as aulas por sala
    public void ordenaPorSala() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getSala));
    }

    // Ordena as aulas por lotação
    public void ordenaPorLotacao() {
        Collections.sort(this.aulas, Comparator.comparing(Aula::getLotacao));
    }

    // Filtra as aulas por dia
    public List<Aula> filtraPorDia(String dia) {
        List<Aula> aulasDia = new ArrayList<>();
        for (Aula aula : this.aulas) {
            if (aula.getDia().equals(dia)) {
                aulasDia.add(aula);
            }
        }
        return aulasDia;
    }

    // Filtra as aulas por semana
    public List<Aula> filtraPorSemana(int semana) {
        List<Aula> aulasSemana = new ArrayList<>();
        for (Aula aula : this.aulas) {
            int semanaAula = Integer.parseInt(aula.getDia().substring(7));
            if (semanaAula == semana) {
                aulasSemana.add(aula);
            }
        }
        return aulasSemana;
    }

    // Filtra as aulas por mês
    public List<Aula> filtraPorMes(int mes) {
        List<Aula> aulasMes = new ArrayList<>();
        for (Aula aula : this.aulas) {
          /*  int mesAula = Integer.parseInt(aula.getData().substring(3, 5));
            if (mesAula == mes) {
                aulasMes.add(aula);
            }*/
        }
        return aulasMes;
    }

    // Retorna todas as aulas do horário
    public List<Aula> getAulas() {
        return this.aulas;
    }
}


