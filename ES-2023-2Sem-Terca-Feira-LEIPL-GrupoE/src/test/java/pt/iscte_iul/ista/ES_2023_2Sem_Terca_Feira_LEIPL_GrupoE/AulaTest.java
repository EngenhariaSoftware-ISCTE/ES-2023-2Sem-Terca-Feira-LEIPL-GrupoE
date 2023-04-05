/**
 * 
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author LMV
 *
 */
class AulaTest {

	/**
	 * @throws java.lang.Exception
	 */
	
		private static Aula aula;
		
	 	@BeforeAll
	    public static void setUpBeforeClass() throws Exception {
	        // Inicialização de recursos comuns a todos os testes
	 		aula = new Aula("Engenharia", "Matemática",  "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	    }
	    
	    @AfterAll
	    public static void tearDownAfterClass() throws Exception {
	        // Liberação de recursos comuns a todos os testes
	    }
	    
	    @BeforeEach
	    public void setUp() throws Exception {
	        // Inicialização de recursos específicos para cada teste
	    	//aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	    }
	    
	    @AfterEach
	    public void tearDown() throws Exception {
	        // Liberação de recursos específicos para cada teste
	    }
	    
	

	    @Test
	    void testGetNome() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("Matemática", aula.getNome());
	    }

	    @Test
	    void testGetCurso() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("Engenharia", aula.getCurso());
	    }

	    @Test
	    void testGetTurno() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("Manhã", aula.getTurno());
	    }

	    @Test
	    void testGetTurma() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("A1", aula.getTurma());
	    }

	    @Test
	    void testGetInscritos() {
	        Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals(30, aula.getInscritos());
	    }

	    @Test
	    void testGetDia() {
	       // Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("Segunda", aula.getDia());
	    }

	    @Test
	    void testGetHoraInicio() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("08:00", aula.getHoraInicio());
	    }

	    @Test
	    void testGetHoraFim() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);
	        assertEquals("10:00", aula.getHoraFim());
	    }

	    @Test
	    void testGetData() {
	        //Aula aula = new Aula("Matemática", "Engenharia", "Manhã", "A1", 30, "Segunda", "08:00", "10:00", "02/04/2023", "Sala 1", 50);	
	    }
}
