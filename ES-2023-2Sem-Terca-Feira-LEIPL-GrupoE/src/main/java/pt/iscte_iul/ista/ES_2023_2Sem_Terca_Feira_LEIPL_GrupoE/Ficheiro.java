package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

/**
 * Classe responsável por gerenciar a escolha e exportação de arquivos CSV e JSON.
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
    private final Horario horario;
    /**
     * Stage utilizado para exibir o FileChooser.
     */
    private final Stage stage;

    /**
     * Construtor da classe Ficheiro.
     * @param stage Stage utilizado para exibir o FileChooser.
     * @param interfaceHorario InterfaceHorario responsável por mostrar o calendário.
     * @param horario Horario que será carregado ou exportado.
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

    /**
     * Retorna um botão que permite carregar um arquivo.
     * @return Button utilizado para carregar um arquivo.
     */
    public Button getLoadButton() {
        Button loadButton = new Button("Carregar arquivo");
        loadButton.setOnAction(new LoadButtonHandler());
        return loadButton;
    }

    /**
     * Retorna um botão que permite exportar um arquivo.
     * @return Button utilizado para exportar um arquivo.
     */
    public Button getExportButton() {
        Button exportButton = new Button("Exportar arquivo");
        exportButton.setOnAction(new ExportButtonHandler());
        return exportButton;
    }

    /**
     * Classe interna que representa o EventHandler para o botão de carregar arquivo.
     */
    private class LoadButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Abre a janela de diálogo para o usuário escolher o arquivo
            File file = fileChooser.showOpenDialog(stage);

	    if (file != null) {
		/*try {
		    // Carrega o horário a partir do arquivo escolhido
		    //horario.carregarHorario(file.getAbsolutePath());
		   
		    // Atualiza o calendário com as informações do horário
		    interfaceHorario.getCalendar().clear();
		    interfaceHorario.addHorarioAoCalendario(horario);
		    throw new NotImplementedException();
		} catch (IOException e) {
		    // Trata o erro de carregamento do arquivo
		    System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
		}*/
	    }
	}
    }

    /**
     * Classe interna que lida com o evento do botão "Exportar arquivo".
     */
    private class ExportButtonHandler implements EventHandler<ActionEvent> {

    	/**
    	 * Manipula o evento do botão "Exportar arquivo".
    	 * Abre a janela de diálogo para o usuário escolher o arquivo a ser exportado.
    	 * 
    	 * @param event o evento do botão "Exportar arquivo"
    	 */
    	@Override
    	public void handle(ActionEvent event) {
    	    // Abre a janela de diálogo para o usuário escolher o arquivo
    	    File file = fileChooser.showSaveDialog(stage);

    	    if (file != null) {
    		/*try {
    		    // Exporta o horário para o arquivo escolhido
    		   // horario.exportarHorario(file.getAbsolutePath());
    		} catch (IOException e) {
    		    // Trata o erro de carregamento do arquivo
    		    System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
    		}*/
    	    }
    	}
    }

}