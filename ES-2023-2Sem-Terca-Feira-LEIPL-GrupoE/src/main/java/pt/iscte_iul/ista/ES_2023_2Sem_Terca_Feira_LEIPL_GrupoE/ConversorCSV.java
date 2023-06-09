package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

/**
 * Classe ConversorCSV - Lê um ficheiro CSV para um objeto Horário e escreve
 * para um ficheiro CSV a partir de um objeto Horário.
 * 
 * ConversorCSV Class - Reads a CSV file into a Horário object and writes to a
 * CSV file from a Horário object.
 * 
 * @author Vítor
 */
public class ConversorCSV {

    /**
     * Método para ler um ficheiro CSV e colocar na estrutura/objeto Horário.
     * 
     * Reads a CSV file and populates the Horário structure/object.
     * 
     * @param locationCSVFile localização do ficheiro CSV
     * @return um objeto Horário preenchido com os dados do ficheiro CSV
     * @throws CsvException se ocorrer um erro ao ler o ficheiro CSV
     */
    public static Horario lerCSVParaEstrutura(String locationCSVFile) throws CsvException {
	try (CSVReader reader = new CSVReader(
		new InputStreamReader(new FileInputStream(locationCSVFile), StandardCharsets.UTF_8))) {

	    List<String[]> r = reader.readAll();

	    Horario h = new Horario();

	    for (int i = 1; i < r.size(); i++) {

		Aula a = new Aula();

		if (r.get(i)[10].equals(""))
		    a.setLotacao(0);

		else
		    a.setLotacao(Integer.parseInt(r.get(i)[10]));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String data = r.get(i)[8];
		if (data.equals("")) {
		    data = "25/12/2023";
		}
		LocalDate localDate = LocalDate.parse(data, formatter);

		a.setCurso(r.get(i)[0]);
		a.setUC(r.get(i)[1]);
		a.setTurno(r.get(i)[2]);
		a.setTurma(r.get(i)[3]);
		a.setInscritos(Integer.parseInt(r.get(i)[4]));
		a.setDia(r.get(i)[5]);
		a.setHoraInicio(LocalTime.parse(r.get(i)[6]));
		a.setHoraFim(LocalTime.parse(r.get(i)[7]));
		a.setData(localDate);
		a.setSala(r.get(i)[9]);
		h.adicionaAula(a);

		// System.out.println("iteração: " + i + " " + a);

	    }
	    return h;

	} catch (IOException e) {
	    Error.setError("CSV error", e.getLocalizedMessage());
	}
	return null;
    }

    /**
     * Método para escrever a partir de um objeto Horário para um ficheiro CSV.
     * 
     * Writes from a Horário object to a CSV file.
     * 
     * @param h        objeto Horário contendo os dados a serem escritos
     * @param fileName nome do ficheiro CSV a ser criado
     */
    public static void escreveCSV(Horario h, String fileName) {

	String[] cabecalho = { "Curso", "Unidade Curricular", "Turno", "Turma", "Inscritos", "Dia", "Hora Início",
		"Hora Fim", "Data", "Sala" };

	List<String[]> list = new ArrayList<>();
	list.add(cabecalho);

	for (int i = 0; i < h.getAulas().size(); i++) {

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String lotacao = h.getAulas().get(i).getLotacao() != 0 ? Integer.toString(h.getAulas().get(i).getLotacao())
		    : "";

	    String[] a = { h.getAulas().get(i).getCurso(), h.getAulas().get(i).getUC(), h.getAulas().get(i).getTurno(),
		    h.getAulas().get(i).getTurma(), Integer.toString(h.getAulas().get(i).getInscritos()),
		    h.getAulas().get(i).getDia(), h.getAulas().get(i).getHoraFim().toString().concat(":00"),
		    h.getAulas().get(i).getHoraFim().toString().concat(":00"),
		    formatter.format(h.getAulas().get(i).getData()), h.getAulas().get(i).getSala(), lotacao };

	    list.add(a);
	}

	try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
	    writer.writeAll(list);
	} catch (IOException e) {
	    Error.setError("CSV error", e.getLocalizedMessage());
	}

    }

}
