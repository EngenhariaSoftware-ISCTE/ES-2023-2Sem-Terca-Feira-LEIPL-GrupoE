package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Luis Viriato Classe Aula - Gera um objetos Aula Contém métodos
 *         getters e setters para todos os parâmetros
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
     * Construtor vazio para possibilitar mais flexibilidade na criação de código
     */
    public Aula() {

    }

    /**
     * @param curso      - curso a que pertence a uc
     * @param uc         - Unidade curricular
     * @param turno      - Turno a que pertence a uc
     * @param turma      - Turma a que pertence a uc.
     * @param inscritos  - Numero de inscritos na uc
     * @param dia        - Dia da semana
     * @param horaInicio - hora inicio da aula
     * @param horaFim    - hora de fima da aula
     * @param data       - data da aula
     * @param sala       - Local da aula.
     * @param lotacao    -Lotação da sala.
     */

    public Aula(String curso, String uc, String turno, String turma, int inscritos, String dia, LocalTime horaInicio,
	    LocalTime horaFim, LocalDate data, String sala, int lotacao) {
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

    /**
     * Define o curso
     *
     * @param curso curso a ser definido
     */
    public void setCurso(String curso) {
	this.curso = curso;
    }

    /**
     * @return string com a uc
     */
    public String getUC() {
	return uc;
    }

    /**
     * Define a unidade curricular.
     *
     * @param uc a unidade curricular a ser definida
     */
    public void setUC(String uc) {
	this.uc = uc;
    }

    /**
     * @return string turno da uc
     */
    public String getTurno() {
	return turno;
    }

    /**
     * Define o turno
     *
     * @param turno turno a ser definido
     */
    public void setTurno(String turno) {
	this.turno = turno;
    }

    /**
     * @return string turma da uc
     */
    public String getTurma() {
	return turma;
    }

    /**
     * Define a turma
     *
     * @param turma turma a ser definida
     */
    public void setTurma(String turma) {
	this.turma = turma;
    }

    /**
     * @return numero inscritos na uc
     */
    public int getInscritos() {
	return inscritos;
    }

    /**
     * Define o número de inscritos
     *
     * @param inscritos o número de inscritos a ser definido
     */
    public void setInscritos(int inscritos) {
	this.inscritos = inscritos;
    }

    /**
     * @return string dia da semana
     */
    public String getDia() {
	return dia;
    }

    /**
     * Define o dia
     *
     * @param dia dia a ser definido
     */
    public void setDia(String dia) {
	this.dia = dia;
    }

    /**
     * @return hora de inicio da aula
     */
    public LocalTime getHoraInicio() {
	return horaInicio;
    }

    /**
     * Define a hora de inicio
     *
     * @param hora_inicio a hora de inicio a ser definida
     */
    public void setHoraInicio(LocalTime hora_inicio) {
	this.horaInicio = hora_inicio;
    }

    /**
     * @return hora fim da aula
     */
    public LocalTime getHoraFim() {
	return horaFim;
    }

    /**
     * Define a hora de fim
     *
     * @param hora_fim a hora de fim a ser definida
     */
    public void setHoraFim(LocalTime hora_fim) {
	this.horaFim = hora_fim;
    }

    /**
     * @return Data da aula.
     */
    public LocalDate getData() {
	return data;
    }

    /**
     * Define a data
     *
     * @param data data a ser definida
     */
    public void setData(LocalDate data) {
	this.data = data;
    }

    /**
     * @return Sala onde vai decorrer a aula
     */
    public String getSala() {
	return sala;
    }

    /**
     * Define a sala
     *
     * @param sala sala a ser definida
     */
    public void setSala(String sala) {
	this.sala = sala;
    }

    /**
     * @return lotação da sala.
     */
    public int getLotacao() {
	return lotacao;
    }

    /**
     * Define a lotação
     *
     * @param lotacao lotação a ser definida
     */
    public void setLotacao(int lotacao) {
	this.lotacao = lotacao;
    }

    /**
     * @return Reescreve o método toString
     */
    @Override
    public String toString() {
	return "Aula [uc=" + uc + ", curso=" + curso + ", turno=" + turno + ", turma=" + turma + ", inscritos="
		+ inscritos + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", data=" + data
		+ ", sala=" + sala + ", lotacao=" + lotacao + "]";
    }

    /**
     * @return a string with the fields from aula.
     */
    public String displayEntry() {
	return uc + ",\n Curso=" + curso + ",\n Turno=" + turno + ",\n Turma=" + turma + ",\n Inscritos=" + inscritos
		+ ",\n Sala=" + sala + ",\n Lotacao=" + lotacao;
    }
}
