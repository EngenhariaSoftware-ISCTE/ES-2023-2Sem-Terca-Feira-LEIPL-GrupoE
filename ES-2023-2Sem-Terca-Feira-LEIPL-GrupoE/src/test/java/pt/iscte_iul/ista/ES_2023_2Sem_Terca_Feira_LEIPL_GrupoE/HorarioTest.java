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
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * @author LMV
 *
 */
class HorarioTest {

	private Horario horario;
    private Aula aula1;
    private Aula aula2;

    @BeforeEach
    void setUp() {
        horario = new Horario();
        aula1 = new Aula("Engenharia", "Matemática", "Manhã", "A", 20,"terça" , "08:00", "10:00", "2023-04-02", "Sala 1", 30);
        aula2 = new Aula("Engenharia", "Matemática", "Manhã", "A", 20,"quarta" , "08:00", "10:00", "2023-04-02", "Sala 1", 30);
        horario.adicionaAula(aula1);
        horario.adicionaAula(aula2);
    }

    @Test
    @DisplayName("Teste adicionaAula")
    void testAdicionaAula() {
        Aula aula3 = new Aula("Engenharia", "Matemática", "Manhã", "B", 20,"terça" , "08:00", "10:00", "2023-04-02", "Sala 1", 30);
        horario.adicionaAula(aula3);
        List<Aula> aulas = horario.getAulas();
        assertEquals(3, aulas.size());
        assertTrue(aulas.contains(aula3));
    }

    @Test
    @DisplayName("Teste removeAula")
    void testRemoveAula() {
        horario.removeAula(aula1);
        List<Aula> aulas = horario.getAulas();
        assertEquals(1, aulas.size());
        assertFalse(aulas.contains(aula1));
    }

    @Test
    @DisplayName("Teste ordenaPorNome")
    void testOrdenaPorNome() {
        horario.ordenaPorNome();
        List<Aula> aulas = horario.getAulas();
        assertEquals(aula1, aulas.get(0));
        assertEquals(aula2, aulas.get(1));
    }

    @Test
    @DisplayName("Teste ordenaPorInscritos")
    void testOrdenaPorInscritos() {
        horario.ordenaPorInscritos();
        List<Aula> aulas = horario.getAulas();
       assertEquals(aula2, aulas.get(0));
        assertEquals(aula1, aulas.get(1));
    }

    @Test
    @DisplayName("Teste filtraPorSemana")
    void testFiltraPorSemana() {
        List<Aula> aulas = horario.filtraPorSemana(13);
        assertEquals(2, aulas.size());
        assertTrue(aulas.contains(aula1));
        assertTrue(aulas.contains(aula2));
        aulas = horario.filtraPorSemana(14);
        assertEquals(0, aulas.size());
    }

    @Test
    @DisplayName("Teste filtraPorMes")
    void testFiltraPorMes() {
        List<Aula> aulas = horario.filtraPorMes(4);
        assertEquals(2, aulas.size());
        assertTrue(aulas.contains(aula1));
        assertTrue(aulas.contains(aula2));
        aulas = horario.filtraPorMes(5);
        assertEquals     (0, aulas.size());
}

@Test
@DisplayName("Teste filtraPorDia")
void testFiltraPorDia() {
    List<Aula> aulas = horario.filtraPorDia("2023-04-02");
    assertEquals(2, aulas.size());
    assertTrue(aulas.contains(aula1));
    assertTrue(aulas.contains(aula2));
    aulas = horario.filtraPorDia("2023-04-03");
    assertEquals(0, aulas.size());
}

@Test
@DisplayName("Teste ordenaPorTurno")
void testOrdenaPorTurno() {
    horario.ordenaPorTurno();
    List<Aula> aulas = horario.getAulas();
    assertEquals(aula1, aulas.get(0));
    assertEquals(aula2, aulas.get(1));
}

@Test
@DisplayName("Teste ordenaPorLotação")
void testOrdenaPorLotação() {
    horario.ordenaPorCurso();
    List<Aula> aulas = horario.getAulas();
    assertEquals(aula1, aulas.get(1));
    assertEquals(aula2, aulas.get(0));
}
}
