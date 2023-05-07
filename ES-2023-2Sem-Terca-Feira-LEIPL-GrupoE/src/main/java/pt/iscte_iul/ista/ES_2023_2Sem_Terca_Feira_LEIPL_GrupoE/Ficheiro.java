package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Tatiana Clim Classe responsável por gerir o carregamento e a
 *         exportação de arquivos CSV e JSON.
 */
public class Ficheiro {

    /**
     * Descrição do filtro de arquivos CSV.
     */
    private static final String CSV_DESCRIPTION = "Arquivos CSV (*.csv)";
    /**
     * Extensão do filtro de arquivos CSV.
     */
    private static final String CSV_EXTENSION = "*.csv";
    /**
     * Descrição do filtro de arquivos JSON.
     */
    private static final String JSON_DESCRIPTION = "Arquivos JSON (*.json)";
    /**
     * Extensão do filtro de arquivos JSON.
     */
    private static final String JSON_EXTENSION = "*.json";

    /**
     * FileChooser utilizado para selecionar arquivos.
     */
    private final FileChooser fileChooser = new FileChooser();

    /**
     * InterfaceHorario responsável por mostrar o calendário.
     */
    private final Calendario interfaceHorario;
    /**
     * Horario que será carregado ou exportado.
     */
    private Horario horario;
    /**
     * Stage utilizado para exibir o FileChooser.
     */
    private Stage stage;

    /**
     * Construtor da classe Ficheiro.
     * 
     * @param stage            Stage utilizado para exibir o FileChooser.
     * @param interfaceHorario InterfaceHorario responsável por mostrar o
     *                         calendário.
     * @param horario          Horario que será carregado ou exportado.
     */
    public Ficheiro(Stage stage, Calendario interfaceHorario, Horario horario) {
	this.stage = stage;
	this.interfaceHorario = interfaceHorario;
	this.horario = horario;
	// Configura o filtro para exibir apenas arquivos CSV e JSON
	FileChooser.ExtensionFilter extFilterCSV = new FileChooser.ExtensionFilter(CSV_DESCRIPTION, CSV_EXTENSION);
	FileChooser.ExtensionFilter extFilterJSON = new FileChooser.ExtensionFilter(JSON_DESCRIPTION, JSON_EXTENSION);
	fileChooser.getExtensionFilters().addAll(extFilterCSV, extFilterJSON);
    }

    public void setStage(Stage s) {
	this.stage = s;
    }

    /**
     * Retorna um botão que permite carregar um arquivo.
     * 
     * @return Button utilizado para carregar um arquivo.
     */
    public Button getLoadButton() {
	Button loadButton = new Button("Ficheiros locais");
	loadButton.setOnAction(new LoadButtonHandler());
	return loadButton;
    }

    /**
     * Retorna um botão que permite exportar um arquivo.
     * 
     * @return Button utilizado para exportar um arquivo.
     */
    public Button getExportButton() {
	Button exportButton = new Button("Exportar arquivo");
	exportButton.setOnAction(new ExportButtonHandler());
	return exportButton;
    }

    /**
     * Classe interna que representa o EventHandler para o botão de carregar
     * arquivo.
     */
    private class LoadButtonHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
	    List<Aula> aulas = new ArrayList<>();

	    // Abre a janela de diálogo para o usuário escolher o arquivo
	    File file = fileChooser.showOpenDialog(stage);
	    Calendario.getCalendar().clear();
	    if (file != null) {
		try {

		    if (!horario.getAulas().isEmpty() || Calendario.getCalendar().getUserObject() != null) {
			aulas = horario.getAulas();
			horario.getAulas().removeAll(aulas);
			aulas = null;
		    }

		    // Verifica a extensão do arquivo e chama a função conversora apropriada
		    if (file.getName().endsWith("json")) {
			aulas = ConversorJson.carregarDeArquivoJSON(file.getAbsolutePath());
			aulas.forEach(aula -> horario.adicionaAula(aula));
		    } else if (file.getName().endsWith("csv")) {
			horario = ConversorCSV.lerCSVParaEstrutura(file.getAbsolutePath());
		    } else {
			Error.setError("Erro ao carregar o ficheiro", "Formato de arquivo inválido!");
		    }

		    Calendario.addHorarioAoCalendario(horario);

		    Calendario.getCalendar();
		    stage.close();

		} catch (Exception e) {
		    // Trata o erro de carregamento do arquivo
		    Error.setError("Erro ao carregar o ficheiro", e.getMessage());
		}
	    }
	}
    }

    public Calendario getInterfaceHorario() {
	return interfaceHorario;
    }

    public Horario getHorario() {
	return horario;
    }

    /**
     * Classe interna que lida com o evento do botão "Exportar arquivo".
     */
    private class ExportButtonHandler implements EventHandler<ActionEvent> {

	/**
	 * Manipula o evento do botão "Exportar arquivo". Abre a janela de diálogo para
	 * o usuário escolher o arquivo a ser exportado.
	 * 
	 * @param event o evento do botão "Exportar arquivo"
	 */
	@Override
	public void handle(ActionEvent event) {
	    // Abre a janela de diálogo para o usuário escolher o arquivo
	    File file = fileChooser.showSaveDialog(stage);

	    if (file != null) {
		try {
		    // Verifica a extensão do arquivo e chama a função conversora apropriada
		    if (file.getName().endsWith("json")) {
			ConversorJson.gravarEmArquivoJSON(horario.getAulas(), file.getAbsolutePath());
		    } else if (file.getName().endsWith("csv")) {
			ConversorCSV.escreveCSV(horario, file.getAbsolutePath());
		    } else {
			Error.setError("Error", "Formato de arquivo inválido!");
		    }
		} catch (Exception e) {
		    Error.setError("Error", e.getMessage());
		}
	    }
	}
    }

}