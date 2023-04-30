package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.opencsv.exceptions.CsvException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InterfaceCarregamentoFicheiros {
    static Ficheiro ficheiros = null;
    static Stage popup = null;
    static VBox root = null;
    
    public static void createPopup(Ficheiro ficheiro) {
	ficheiros = ficheiro;
        popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL); // Define como modal
        popup.setScene(createScene());
        popup.showAndWait(); // Mostra e espera a janela ser fechada
    }

    private static Scene createScene() {
	root = new VBox(10); // 10 é a distância entre os elementos
        root.setAlignment(Pos.CENTER); // Alinha os elementos no centro
        root.getChildren().addAll(createTitleLabel(), createRemoteFilesButton(),
                createLocalFilesButton(), createBackButton());
        return new Scene(root, 300, 200);
    }

    private static Label createTitleLabel() {
        return new Label("Carregar Arquivo");
    }

    private static Button createRemoteFilesButton() {
	    Button remoteFilesButton = new Button("Ficheiros remotos");
	    remoteFilesButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);

	   
	    remoteFilesButton.setOnAction(event -> {
		createTextInputDialog();
	    });
	    return remoteFilesButton;
	}
    
    private static TextInputDialog createTextInputDialog () {
	 TextInputDialog dialog = new TextInputDialog();
	        dialog.setTitle("Ficheiros remotos");
	       // dialog.setHeaderText(null);
	        dialog.setContentText("Insira o URL:");

	        Optional<String> result = dialog.showAndWait();
	        result.ifPresent(url -> {
	            try {
			actionButton(url);
		    } catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
	         /*   try {
			ConversorJson.carregarDeArquivoJSON(url);
		    } catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }*/
	        });
	        
	        return dialog;
    }

    
    private static void actionButton(String s) throws CsvException {
	try {
	    URL url = new URL(s);
	    
	    HttpURLConnection hr =(HttpURLConnection) url.openConnection();
	    if(hr.getResponseCode() == 200) {
		InputStream im = hr.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(im));
		FileOutputStream fo = null;
		if(url.getPath().endsWith("json")) {
		    fo = new FileOutputStream("e://horario.json");
		}
		if(url.getPath().endsWith("csv")) {
		    fo = new FileOutputStream("e://horario.csv");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
		String line = br.readLine();
		while(line!=null) {
		   // System.out.println(line);
		    bw.write(line);
		    bw.newLine();
		    line = br.readLine();
		}
		 bw.close();
		 im.close();
		 fo.close();
	    }
	    
	    if(url.getPath().endsWith("json")) {
		Horario horario = new Horario();
		  List<Aula> aulasTeste =  ConversorJson.carregarDeArquivoJSON("e://horario.json");
		   aulasTeste.forEach(a -> horario.adicionaAula(a));
		   ficheiros.getInterfaceHorario().addHorarioAoCalendario(horario);
			
		}
		if(url.getPath().endsWith("csv")) {
		    Horario horario = ConversorCSV.lerCSVParaEstrutura("e://horario.csv");
		    horario.ordenaPorData();
		    System.out.println(horario);
		    ficheiros.getInterfaceHorario().addHorarioAoCalendario(horario);
		}
		
		popup.close();
		Files.deleteIfExists(Paths.get("e://horario.json"));
		Files.deleteIfExists(Paths.get("e://horario.csv"));
	}catch(Exception e) {
	    System.out.println(e.getMessage());
	}
	   


    }

    private static Button createLocalFilesButton() {
	ficheiros.setStage(popup);
	Button localFilesButton = ficheiros.getLoadButton();
	
	localFilesButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
        return localFilesButton;
    }

    private static Button createBackButton() {
        Button backButton = new Button("Voltar");
        backButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
        backButton.setOnAction(event -> {
            closePopup();
        });
        return backButton;
    }

    public static void closePopup() {
        //Stage stage = (Stage) createBackButton().getScene().getWindow(); // Obtém a janela atual
        popup.close(); // Fecha a janela atual
    }
}
