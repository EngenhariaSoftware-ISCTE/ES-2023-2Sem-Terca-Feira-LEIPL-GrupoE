package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;

import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvParaEstrutura {
	
	//Método para ler ficheiro CVS e colocar na estrutura Horário
	public static Horario lerCSVParaEstrutura (String locationCSVFile) throws CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(locationCSVFile))) {
			
			List<String[]> r = reader.readAll();
			
			Horario h = new Horario();

			for(int i = 1; i < r.size(); i++) {
				
				Aula a = new Aula();
				
				if(r.get(i)[10] == "") {
					a.setLotacao(0);
				}
				else {
					a.setLotacao(Integer.parseInt(r.get(i)[10]));
				}
				a.setCurso(r.get(i)[0]);
				a.setUC(r.get(i)[1]);
				a.setTurno(r.get(i)[2]);
				a.setTurma(r.get(i)[3]);
				a.setInscritos(Integer.parseInt(r.get(i)[4]));
				a.setDia(r.get(i)[5]);
				a.setHora_inicio(r.get(i)[6]);
				a.setHora_fim(r.get(i)[7]);
				a.setData(r.get(i)[8]);
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
	
	
	/*public static List<String[]> readCSVFile (String locationCSVFile) throws CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(locationCSVFile))) {
			
			List<String[]> r = reader.readAll();
	      
			return r;
	      
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
	/*public static Horario estruturaComCSV (List<String[]> r) {
		Horario h = new Horario();

		for(int i = 1; i < r.size(); i++) {
			
			Aula a = new Aula();
			
			if(r.get(i)[10] == "") {
				a.setLotacao(0);
			}
			else {
				a.setLotacao(Integer.parseInt(r.get(i)[10]));
			}
			a.setCurso(r.get(i)[0]);
			a.setUC(r.get(i)[1]);
			a.setTurno(r.get(i)[2]);
			a.setTurma(r.get(i)[3]);
			a.setInscritos(Integer.parseInt(r.get(i)[4]));
			a.setDia(r.get(i)[5]);
			a.setHora_inicio(r.get(i)[6]);
			a.setHora_fim(r.get(i)[7]);
			a.setData(r.get(i)[8]);
			a.setSala(r.get(i)[9]);
			h.adicionaAula(a);

			//System.out.println("iteração: " + i + " " + a);

		}
		return h;
	}*/
	
}
