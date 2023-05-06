/**
 * 
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author LMV
 *
 */
public class AulaTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// Inicialização de recursos comuns a todos os testes
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		// Libertação de recursos comuns a todos os testes
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		// Inicialização de recursos específicos para cada teste
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		// Libertação de recursos específicos para cada teste
	}

	private static LocalTime timeStart = LocalTime.of(8, 0, 0);
	private static LocalTime nTimeStart = LocalTime.of(8, 0, 0);
	private static LocalTime timeEnd = LocalTime.of(10, 0, 0);
	private static LocalTime nTimeEnd = LocalTime.of(10, 0, 0);
	private static LocalDate date = LocalDate.of(2023, 04, 03);
	private static LocalDate nDate = LocalDate.of(2023, 04, 03);

	private static Aula aula = new Aula("Engenharia", "Português", "Manhã", "A2", 20, "Terça", timeStart, timeEnd,
			date, "Sala 1", 50);

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getNome()}.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Português", aula.getUC());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setNome(java.lang.String)}.
	 */
	@Test
	public void testSetNome() {
		aula.setUC("Português");
		assertEquals("Português", aula.getUC());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getCurso()}.
	 */
	@Test
	public void testGetCurso() {
		System.out.println("getCurso");
		System.out.println(aula.getCurso());
		assertEquals("Engenharia", aula.getCurso());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setCurso(java.lang.String)}.
	 */
	@Test
	public void testSetCurso() {
		aula.setCurso("Engenharia");
		assertEquals("Engenharia", aula.getCurso());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getTurno()}.
	 */
	@Test
	public void testGetTurno() {
		assertEquals("Manhã", aula.getTurno());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setTurno(java.lang.String)}.
	 */
	@Test
	public void testSetTurno() {
		aula.setTurno("Manhã");
		assertEquals("Manhã", aula.getTurno());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getTurma()}.
	 */
	@Test
	public void testGetTurma() {
		assertEquals("A2", aula.getTurma());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setTurma(java.lang.String)}.
	 */
	@Test
	public void testSetTurma() {
		aula.setTurma("A2");
		assertEquals("A2", aula.getTurma());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getInscritos()}.
	 */
	@Test
	public void testGetInscritos() {
		assertEquals(20, aula.getInscritos());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setInscritos(int)}.
	 */
	@Test
	public void testSetInscritos() {
		aula.setInscritos(20);
		assertEquals(20, aula.getInscritos());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getDia()}.
	 */
	@Test
	public void testGetDia() {
		assertEquals("Terça", aula.getDia());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setDia(java.lang.String)}.
	 */
	@Test
	public void testSetDia() {
		aula.setDia("Terça");
		assertEquals("Terça", aula.getDia());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getHoraInicio()}.
	 */
	@Test
	public void testGetHoraInicio() {
		assertEquals(timeStart, aula.getHoraInicio());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setHoraInicio(java.lang.String)}.
	 */
	@Test
	public void testSetHoraInicio() {
		aula.setHoraInicio(nTimeStart);
		assertEquals(nTimeStart, aula.getHoraInicio());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setHoraFim(java.lang.String)}.
	 */
	@Test
	public void testSetHoraFim() {
		aula.setHoraFim(nTimeEnd);
		assertEquals(nTimeEnd, aula.getHoraFim());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getHoraFim()}.
	 */
	@Test
	public void testGetHoraFim() {
		assertEquals(nTimeEnd, aula.getHoraFim());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getData()}.
	 */
	@Test
	public void testGetData() {
		assertEquals(nDate, aula.getData());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setData(java.lang.String)}.
	 */
	@Test
	public void testSetData() {
		aula.setData(nDate);
		assertEquals(nDate, aula.getData());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getSala()}.
	 */
	@Test
	public void testGetSala() {
		assertEquals("Sala 1", aula.getSala());
	}

	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setSala(java.lang.String)}.
	 */
	@Test
	public void testSetSala() {
		aula.setSala("Sala 1");
		assertEquals("Sala 1", aula.getSala());
	}

	
	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getLotacao()}.
	 */
	@Test
	public void testGetLotacao() {
		assertEquals(50, aula.getLotacao());
	}
	
	/**
	 * Test method for
	 * {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setLotacao(int)}.
	 */
	@Test
	public void testSetLotacao() {
		aula.setLotacao(50);
		assertEquals(50, aula.getLotacao());
	}

}
