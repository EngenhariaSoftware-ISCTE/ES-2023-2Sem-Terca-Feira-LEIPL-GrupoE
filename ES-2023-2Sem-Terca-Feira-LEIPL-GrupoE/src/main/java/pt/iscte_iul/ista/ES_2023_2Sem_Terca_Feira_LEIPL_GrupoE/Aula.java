package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Gera um objeto Aula
 * Contém métodos getters e setters para todos os parâmetros
 * 
 * */

public class Aula {
    private String uc;
    private String curso;
    private String turno;
    private String turma;
    private int inscritos;
    private String dia; 
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private LocalDate data;
    private String sala;
    private int lotacao;

    // Construtor da classe Aula
    public Aula(String curso, String uc, String turno, String turma, int inscritos, String dia, LocalTime horaInicio, LocalTime horaFim, LocalDate data, String sala, int lotacao) {
        this.uc = uc;
        this.curso = curso;
        this.turno = turno;
        this.turma = turma;
        this.inscritos = inscritos;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.data = data;
        this.sala = sala;
        this.lotacao = lotacao;
    }

    // Getters e Setters para os atributos
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getUC() {
        return uc;
    }

    public void setUC(String uc) {
        this.uc = uc;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime hora_inicio) {
        this.horaInicio = hora_inicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime hora_fim) {
        this.horaFim = hora_fim;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
}