/**
 * 
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.*;

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
	    static void setUpBeforeClass() throws Exception {
	        // Inicialização de recursos comuns a todos os testes
	    }
	    
	 	/**
		 * @throws java.lang.Exception
		 */
	    @AfterAll
	    static void tearDownAfterClass() throws Exception {
	        // Libertação de recursos comuns a todos os testes
	    }
	    
	    /**
		 * @throws java.lang.Exception
		 */
	    @BeforeEach
	    void setUp() throws Exception {
	        // Inicialização de recursos específicos para cada teste
	    }
	    
	    /**
		 * @throws java.lang.Exception
		 */
	    @AfterEach
	    void tearDown() throws Exception {
	        // Libertação de recursos específicos para cada teste
	    }
	    
	    private static LocalTime timeStart = LocalTime.of(8, 0,0);
	    private static LocalTime nTimeStart = LocalTime.of(9, 0,0);
	    private static LocalTime timeEnd = LocalTime.of(10, 0,0);
	    private static LocalTime nTimeEnd = LocalTime.of(11, 0,0);
	    private static LocalDate date = LocalDate.of(2023,04,03);
	    private static LocalDate nDate = LocalDate.of(2023,04,05);
	    
	    
	    private static Aula aula = new Aula ("Engenharia", "Matemática",  "Manhã", "A1", 30, "Segunda",timeStart ,timeEnd , date, "Sala 1", 50);
		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getNome()}.
		 */
	    @Test
	    void testGetNome() {
	        assertEquals("Matemática", aula.getUC());
	    }

	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setNome(java.lang.String)}.
		 */
	    @Test
	    void testSetNome() {
	    	aula.setUC("Português");
	    	 assertEquals("Português", aula.getUC());
	    }
	    
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getCurso()}.
		 */
	    @Test
	    void testGetCurso() {
	    	System.out.println("getCurso");
	    	System.out.println(aula.getCurso());
	        assertEquals("Engenharia", aula.getCurso());
	    }

	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setCurso(java.lang.String)}.
		 */
	    @Test
	    void testSetCurso() {
	    	aula.setCurso("Ciências");
	    	assertEquals("Ciências", aula.getCurso());
	    }
	    
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getTurno()}.
		 */
	    @Test
	    void testGetTurno() {
	        assertEquals("Manhã", aula.getTurno());
	    }

	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setTurno(java.lang.String)}.
		 */
	    @Test
		void testSetTurno() {
			aula.setTurno("Tarde");
			assertEquals("Tarde", aula.getTurno());
		}
	    
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getTurma()}.
		 */
	    @Test
	    void testGetTurma() {
	        assertEquals("A1", aula.getTurma());
	    }

		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setTurma(java.lang.String)}.
		 */
		@Test
		void testSetTurma() {
			aula.setTurma("A2");
			 assertEquals("A2", aula.getTurma());
		}
		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getInscritos()}.
		 */
	    @Test
	    void testGetInscritos() {
	        assertEquals(30, aula.getInscritos());
	    }

	    
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setInscritos(int)}.
		 */
		@Test
		void testSetInscritos() {
			aula.setInscritos(20);
			assertEquals(20, aula.getInscritos());
		}
	    	    
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getDia()}.
		 */
	    @Test
	    void testGetDia() {
	        assertEquals("Segunda", aula.getDia());
	    }

	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setDia(java.lang.String)}.
		 */
		@Test
		void testSetDia() {
			aula.setDia("Terça");
			assertEquals("Terça", aula.getDia());
		}
	    
	    
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getHoraInicio()}.
		 */
	    @Test
	    void testGetHoraInicio() {
	        assertEquals(timeStart, aula.getHoraInicio());
	    }

	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setHoraInicio(java.lang.String)}.
		 */
		@Test
		void testSetHoraInicio() {
			aula.setHoraInicio(nTimeStart);
			assertEquals(nTimeStart, aula.getHoraInicio());
		}
		
		
	    
		
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setHoraFim(java.lang.String)}.
		 */
		@Test
		void testSetHoraFim() {
			aula.setHoraFim(nTimeEnd);
			assertEquals(nTimeEnd, aula.getHoraFim());
		}
		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getHoraFim()}.
		 */
	    @Test
	    void testGetHoraFim() {
	        assertEquals(nTimeEnd, aula.getHoraFim());
	    }

		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getData()}.
		 */
	    @Test
	    void testGetData() {
	    	assertEquals(date, aula.getData());
	    }
	    
	    /**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setData(java.lang.String)}.
		 */
		@Test
		void testSetData() {
			aula.setData(nDate);
			assertEquals(nDate, aula.getData());
		}
		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getSala()}.
		 */
		@Test
		void testGetSala() {
			assertEquals("Sala 1", aula.getSala());
		}

		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setSala(java.lang.String)}.
		 */
		@Test
		void testSetSala() {
			aula.setSala("Sala 2");
			assertEquals("Sala 2", aula.getSala());
		}
		
		

		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#setLotacao(int)}.
		 */
		@Test
		void testSetLotacao() {
			aula.setLotacao(40);
			assertEquals(40, aula.getLotacao());
		}

		
		/**
		 * Test method for {@link pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.Aula#getLotacao()}.
		 */
		@Test
		void testGetLotacao() {
			assertEquals(40, aula.getLotacao());
		}
		
}
