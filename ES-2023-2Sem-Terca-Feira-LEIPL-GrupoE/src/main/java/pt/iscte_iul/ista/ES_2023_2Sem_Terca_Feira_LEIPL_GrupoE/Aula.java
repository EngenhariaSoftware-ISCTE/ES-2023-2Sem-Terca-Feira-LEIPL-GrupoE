package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @autor Luis Viriato
 * Classe Aula - Gera um objetos Aula
 * Contém métodos getters e setters para todos os parâmetros
 * 
 * */

/**
 * @author LMV
 *
 */
/**
 * @author LMV
 *
 */
/**
 * @author LMV
 *
 */
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
    
    /**
     * @param curso - curso a que pertence a uc
     * @param uc - Unidade curricular
     * @param turno - Turno a que pertence a uc
     * @param turma- Turma a que pertence a uc.
     * @param inscritos - Numero de inscritos na uc
     * @param dia - Dia da semana 
     * @param horaInicio - hora inicio da aula
     * @param horaFim - hora de fima da aula
     * @param data - data da aula
     * @param sala - Local da aula.
     * @param lotacao -Lotação da sala.
     */
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
    /**
     * @return string curso da uc
     */
    public String getCurso() {
        return curso;
    }

    
    public void setCurso(String curso) {
        this.curso = curso;
    }

   
    /**
     * @return string com a uc
     */
    public String getUC() {
        return uc;
    }

    
    public void setUC(String uc) {
        this.uc = uc;
    }

    /**
     * @return string turno da uc
     */
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return string turma da uc
     */
    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    /**
     * @return numero inscritos na uc
     */
    public int getInscritos() {
        return inscritos;
    }

    public void setInscritos(int inscritos) {
        this.inscritos = inscritos;
    }

    /**
     * @return string dia da semana
     */
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return hora de inicio da aula
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime hora_inicio) {
        this.horaInicio = hora_inicio;
    }

    /**
     * @return hora fim da aula
     */
    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime hora_fim) {
        this.horaFim = hora_fim;
    }

    /**
     * @return Data da aula.
     */
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * @return Sala onde vai decorrer a aula
     */
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * @return lotação da sala.
     */
    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
}
