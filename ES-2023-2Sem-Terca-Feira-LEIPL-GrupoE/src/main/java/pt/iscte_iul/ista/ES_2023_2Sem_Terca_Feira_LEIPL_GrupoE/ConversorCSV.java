package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import com.opencsv.CSVWriter;
import java.text.SimpleDateFormat;

import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class ConversorCSV {
	
/**
 * 	//Método para ler ficheiro CVS e colocar na estrutura Horário
 * @param locationCSVFile
 * @return
 * @throws CsvException
 */
	public static Horario lerCSVParaEstrutura (String locationCSVFile) throws CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(locationCSVFile))) {
			
			List<String[]> r = reader.readAll();
			
			Horario h = new Horario();
			
			System.out.println("Comecei a ler o ficheiro");

			for(int i = 1; i < r.size(); i++) {
				
				Aula a = new Aula();
				
				if(r.get(i)[10] == "") {
					a.setLotacao(0);
				}
				else {
					a.setLotacao(Integer.parseInt(r.get(i)[10]));
				}
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String data = r.get(i)[8];
				LocalDate localDate = LocalDate.parse(data, formatter);
				
				a.setCurso(r.get(i)[0]);
				a.setUC(r.get(i)[1]);
				a.setTurno(r.get(i)[2]);
				a.setTurma(r.get(i)[3]);
				a.setInscritos(Integer.parseInt(r.get(i)[4]));
				a.setDia(r.get(i)[5]);
				a.setHora_inicio(LocalTime.parse(r.get(i)[6]));
				a.setHora_fim(LocalTime.parse(r.get(i)[7]));
				a.setData(localDate);
				a.setSala(r.get(i)[9]);
				h.adicionaAula(a);

				System.out.println("iteração: " + i + " " + a);

			}
			return h;
	      
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
/**
 * 	//Método para escrever ficheiro CSV
 * @param h
 * @param fileName
 */
	public static void escreveCSV(Horario h, String fileName) {
		
		String[] cabecalho = {"Curso", "Unidade Curricular", "Turno", "Turma", "Inscritos",
				"Dia", "Hora Início", "Hora Fim", "Data", "Sala"};
		
		List<String[]> list = new ArrayList<>();
		list.add(cabecalho);
		
		for(int i = 0; i < h.getAulas().size(); i++) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        //String date = "16/08/2016";
	        //LocalDate localDate = LocalDate.parse(date, formatter);
	        //h.getAulas().get(i).getData().toString()
	        
			String lotacao = "";
			if(h.getAulas().get(i).getLotacao() != 0 )
				 lotacao = Integer.toString(h.getAulas().get(i).getLotacao());
			
			String[] a = {h.getAulas().get(i).getCurso(),h.getAulas().get(i).getUC(),
					h.getAulas().get(i).getTurno(),h.getAulas().get(i).getTurma(),
					Integer.toString(h.getAulas().get(i).getInscritos()),h.getAulas().get(i).getDia(),
					h.getAulas().get(i).getHora_inicio().toString().concat(":00"),h.getAulas().get(i).getHora_fim().toString().concat(":00"),
					formatter.format(h.getAulas().get(i).getData()),h.getAulas().get(i).getSala(),
					lotacao};
			
			list.add(a);
		}
		
		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(list);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
