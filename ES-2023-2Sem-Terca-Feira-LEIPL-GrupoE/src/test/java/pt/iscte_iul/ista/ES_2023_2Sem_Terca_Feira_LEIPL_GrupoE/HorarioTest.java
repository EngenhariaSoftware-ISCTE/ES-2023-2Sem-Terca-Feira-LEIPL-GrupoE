/**
 * 
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author LMV
 *
 */
class HorarioTest {

    private static LocalTime timeStart1 = LocalTime.of(8, 0, 0);
    private static LocalTime timeStart2 = LocalTime.of(9, 0, 0);
    private static LocalTime timeStart3 = LocalTime.of(10, 0, 0);
    private static LocalTime timeEnd1 = LocalTime.of(10, 0, 0);
    private static LocalTime timeEnd2 = LocalTime.of(11, 0, 0);
    private static LocalDate date1 = LocalDate.of(2023, 04, 03);
    private static LocalDate date2 = LocalDate.of(2023, 04, 03);
    private static LocalDate date3 = LocalDate.of(2023, 04, 03);

    private static Horario horario = new Horario();

    private static Aula aula1 = new Aula("Curso1", "UC1", "T2", "A3", 30, "Segunda", timeStart3, timeEnd1, date3,
	    "Sala 1", 20);
    private static Aula aula2 = new Aula("Curso2", "UC2", "T1", "A1", 30, "Terça", timeStart2, timeEnd1, date2,
	    "Sala 2", 30);
    private static Aula aula3 = new Aula("Curso3", "UC3", "T3", "A2", 20, "Quarta", timeStart1, timeEnd2, date1,
	    "Sala 3", 40);

    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
	horario.adicionaAula(aula1);
	horario.adicionaAula(aula2);
	horario.adicionaAula(aula3);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    public void tearDown() throws Exception {

    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#adicionaAula(pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula)}.
     */
    @Test
    public void testAdicionaAula() {
	Aula aula = new Aula("Engenharia", "Inglês", "Manhã", "A1", 30, "Segunda", timeStart3, timeEnd1, date1,
		"Sala 3", 50);
	horario.adicionaAula(aula);
	assertTrue(horario.getAulas().contains(aula));
	horario.removeAula(aula);
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#removeAula(pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula)}.
     */
    @Test
    public void testRemoveAula() {
	Aula aula = horario.getAulas().get(0);
	horario.removeAula(aula);
	assertFalse(horario.getAulas().contains(aula));
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorUC()}.
     */
    @Test
    public void testOrdenaPorUC() {
	horario.ordenaPorUC();
	assertEquals("UC1", horario.getAulas().get(0).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorCurso()}.
     */
    @Test
    public void testOrdenaPorCurso() {
	horario.ordenaPorCurso();
	assertEquals("Curso1", horario.getAulas().get(0).getCurso());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorTurno()}.
     */
    @Test
    public void testOrdenaPorTurno() {
	horario.ordenaPorTurno();
	assertEquals("T1", horario.getAulas().get(0).getTurno());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorTurma()}.
     */
    @Test
    public void testOrdenaPorTurma() {
	horario.ordenaPorTurma();
	assertEquals("A1", horario.getAulas().get(0).getTurma());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorInscritos()}.
     */
    @Test
    public void testOrdenaPorInscritos() {
	horario.ordenaPorInscritos();
	assertEquals(20, horario.getAulas().get(0).getInscritos());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorDia()}.
     */
    @Test
    public void testOrdenaPorDia() {
	horario.ordenaPorDia();
	assertEquals("UC3", horario.getAulas().get(0).getUC());
	assertEquals("UC1", horario.getAulas().get(1).getUC());
	assertEquals("UC2", horario.getAulas().get(2).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorHoraInicio()}.
     */
    @Test
    public void testOrdenaPorHoraInicio() {
	horario.ordenaPorHoraInicio();
	assertEquals("UC3", horario.getAulas().get(0).getUC());
	assertEquals("UC2", horario.getAulas().get(1).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorHoraFim()}.
     */
    @Test
    public void testOrdenaPorHoraFim() {
	horario.ordenaPorHoraFim();
	assertEquals("UC1", horario.getAulas().get(0).getUC());
	assertEquals("UC2", horario.getAulas().get(1).getUC());

    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorData()}.
     */
    @Test
    public void testOrdenaPorData() {
	horario.ordenaPorData();
	assertEquals("UC1", horario.getAulas().get(0).getUC());
	assertEquals("UC2", horario.getAulas().get(1).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorSala()}.
     */
    @Test
    public void testOrdenaPorSala() {
	horario.ordenaPorSala();
	assertEquals("UC1", horario.getAulas().get(0).getUC());
	assertEquals("UC2", horario.getAulas().get(1).getUC());

    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#ordenaPorLotacao()}.
     */
    @Test
    public void testOrdenaPorLotacao() {
	horario.ordenaPorLotacao();
	assertEquals("UC1", horario.getAulas().get(0).getUC());
	assertEquals("UC2", horario.getAulas().get(1).getUC());
	assertEquals("UC3", horario.getAulas().get(2).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#filtraPorDia(java.time.LocalDate)}.
     */
    @Test
    public void testFiltraPorDia() {
	List<Aula> aulasDoDia = horario.filtraPorDia(date2);
	assertEquals(2, aulasDoDia.size());
	assertEquals("UC1", aulasDoDia.get(0).getUC());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#filtraPorSemana(java.time.LocalDate, java.time.LocalDate)}.
     */
    @Test
    public void testFiltraPorSemana() {
	List<Aula> aulasDaSemana = horario.filtraPorSemana(date2, date3);
	assertEquals(3, aulasDaSemana.size());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#filtraPorMes(int)}.
     */
    @Test
    public void testFiltraPorMes() {
	List<Aula> aulasDoMes = horario.filtraPorMes(4);
	assertEquals(2, aulasDoMes.size());
    }

    /**
     * Test method for
     * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Horario#filtraPorMes(int)}.
     */
    @Test
    public void testMostraTodasUCs() {
	List<String> ucsEsperadas = new ArrayList<>();
	ucsEsperadas.add("UC1");
	ucsEsperadas.add("UC2");
	ucsEsperadas.add("UC3");

	List<String> ucsObtidas = horario.listaUCs();
	assertEquals(ucsEsperadas, ucsObtidas);
    }
}
