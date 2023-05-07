package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

/**
 * @author Tatiana Classe responsável pela interface gráfica de carregamento de
 *         arquivos.
 */
public class InterfaceCarregamentoFicheiros {
    static Ficheiro ficheiros = null;
    static Stage popup = null;
    static VBox root = null;

    /**
     * 
     * Cria a janela pop-up para carregamento de arquivos.
     * 
     * @param ficheiro Objeto Ficheiro a ser utilizado na interface gráfica.
     */
    public static void createPopup(Ficheiro ficheiro) {
	ficheiros = ficheiro;
	popup = new Stage();
	popup.initModality(Modality.APPLICATION_MODAL); // Define como modal
	popup.setScene(createScene());
	popup.showAndWait(); // Mostra e espera a janela ser fechada
    }

    /**
     * 
     * Cria a cena da janela pop-up.
     * 
     * @return Cena da janela pop-up.
     */
    private static Scene createScene() {
	root = new VBox(10); // 10 é a distância entre os elementos
	root.setAlignment(Pos.CENTER); // Alinha os elementos no centro
	root.getChildren().addAll(createTitleLabel(), createRemoteFilesButton(), createLocalFilesButton(),
		createWebCalButton(), createBackButton());
	return new Scene(root, 300, 200);
    }

    /**
     * 
     * Cria o rótulo de título da janela pop-up.
     * 
     * @return Rótulo de título da janela pop-up.
     */
    private static Label createTitleLabel() {
	return new Label("Carregar Arquivo");
    }

    /**
     * 
     * Cria o botão para seleção de webcal.
     * 
     * @return Botão para seleção de arquivos remotos.
     */

    private static Button createWebCalButton() {
	Button remoteFilesButton = new Button("Webcal");
	remoteFilesButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
	remoteFilesButton.setOnAction(event -> {
	    // Método para transformar de webcal para horário
	    // adicionarHorarioAoCalendario(Horario)
	    // closePopup
	});
	return remoteFilesButton;
    }

    /**
     * 
     * Cria o botão para seleção de arquivos remotos.
     * 
     * @return Botão para seleção de arquivos remotos.
     */
    private static Button createRemoteFilesButton() {
	Button remoteFilesButton = new Button("Ficheiros remotos");
	remoteFilesButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
	remoteFilesButton.setOnAction(event -> createTextInputDialog());
	return remoteFilesButton;
    }

    /**
     * 
     * Cria o diálogo de entrada de texto para inserção de URLs.
     * 
     * @return Diálogo de entrada de texto para inserção de URLs.
     */
    private static TextInputDialog createTextInputDialog() {
	TextInputDialog dialog = new TextInputDialog();
	dialog.setTitle("Ficheiros remotos");
	dialog.setContentText("Insira o URL:");

	Optional<String> result = dialog.showAndWait();
	result.ifPresent(url -> {
	    try {
		actionButton(url);
	    } catch (CsvException e) {
		Error.setError("Error", e.getMessage());
	    }
	});

	return dialog;
    }

    /**
     * 
     * Realiza a ação do botão de carregamento de arquivos remotos.
     * 
     * @param s URL do arquivo a ser carregado.
     * @throws CsvException Exceção em caso de erro na leitura do arquivo CSV.
     */
    private static void actionButton(String s) throws CsvException {
	try {
	    URL url = new URL(s);
	    String path = "";
	    HttpURLConnection hr = (HttpURLConnection) url.openConnection();
	    if (s.startsWith("http") && s.contains("raw")) {
		InputStream im = hr.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(im, StandardCharsets.UTF_8));
		if (url.getPath().endsWith("json")) {
		    path = "horario.json";
		    salvar(br, path);
		} else if (url.getPath().endsWith("csv")) {
		    path = "horario.csv";
		    salvar(br, path);
		}
		Horario horario = lerHorario(path);
		adicionarHorarioAoCalendario(horario);
		fecharPopup();
		Files.deleteIfExists(Paths.get(path));
		im.close();
	    } else {
		Error.setError("Url inválido!", "Url Inválido!");
	    }
	} catch (Exception e) {
	    Error.setError("Url inválido", e.getMessage());
	}
    }

    /**
     * 
     * Método que salva um arquivo a partir de um BufferedReader.
     * 
     * @param br   o BufferedReader que será utilizado para ler o arquivo
     * @param path o caminho do arquivo que será salvo
     * @throws IOException se houver um erro de entrada/saída
     */
    private static void salvar(BufferedReader br, String path) throws IOException {
	try (FileOutputStream fo = new FileOutputStream(path);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo, StandardCharsets.UTF_8))) {

	    String line = br.readLine();
	    while (line != null) {
		bw.write(line);
		bw.newLine();
		line = br.readLine();
	    }
	} catch (Exception e) {
	    Error.setError("Error", e.getMessage());
	}
    }

    /**
     * 
     * Método que lê um arquivo contendo horários e retorna uma instância da classe
     * Horario.
     * 
     * @param path o caminho do arquivo a ser lido
     * @return uma instância da classe Horario
     * @throws IOException  se houver um erro de entrada/saída
     * @throws CsvException se houver um erro ao ler um arquivo CSV
     */
    private static Horario lerHorario(String path) throws IOException, CsvException {
	Horario horario = new Horario();
	if (path.endsWith("json")) {
	    List<Aula> aulas = ConversorJson.carregarDeArquivoJSON(path);
	    aulas.forEach(a -> horario.adicionaAula(a));
	} else if (path.endsWith("csv")) {
	    Horario horarios = ConversorCSV.lerCSVParaEstrutura(path);
	    horarios.getAulas().forEach(horario::adicionaAula);

	}
	return horario;
    }

    /**
     * Método que adiciona um horário ao calendário da aplicação.
     * 
     * @param horario o horário a ser adicionado
     */
    private static void adicionarHorarioAoCalendario(Horario horario) {
	// Limpa o calendário
	Calendario.getCalendar().clear();
	// Adiciona horário ao calendário
	Calendario.addHorarioAoCalendario(horario);
    }

    /**
     * Método que fecha a janela pop-up atual.
     */
    private static void fecharPopup() {
	popup.close();
    }

    /**
     * Método que cria um botão para carregar arquivos locais.
     * 
     * @return o botão criado
     */
    private static Button createLocalFilesButton() {
	ficheiros.setStage(popup);
	Button localFilesButton = ficheiros.getLoadButton();
	localFilesButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
	return localFilesButton;
    }

    /**
     * Método que cria um botão "Voltar" para fechar a janela pop-up atual.
     * 
     * @return o botão criado
     */
    private static Button createBackButton() {
	Button backButton = new Button("Voltar");
	backButton.setMaxSize(Double.MAX_VALUE * 0.5, Double.MAX_VALUE * 0.5);
	backButton.setOnAction(event -> closePopup());
	return backButton;
    }

    /**
     * Método que fecha a janela pop-up atual.
     */
    public static void closePopup() {
	popup.close();
    }
}
