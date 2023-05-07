package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Vitor Teixeira Classe responsável por criar a interface para a
 *         criação de um novo horário.
 */
public class InterfaceCriarNovoHorario {

    static Horario horarios = new Horario();

    static Stage stage = new Stage();

    /**
     * Cria a cena da interface para criar um novo horário.
     *
     * @return a cena criada
     */
    public static Scene criarInterface() {

	horarios = Calendario.getHorario();

	List<String> listaUCs = horarios.listaUCs();

	// Lista de opções para o dropdown
	ObservableList<String> opcoes = FXCollections.observableList(listaUCs);

	// Cria o ListView com as opções
	ListView<String> listView = new ListView<>(opcoes);

	// Permite que o usuário selecione várias opções
	listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();

	// Imprime as strings selecionadas no console

	// Cria o botão "Adicionar UC"
	Button btnAdicionarUC = new Button("Adicionar UC");

	btnAdicionarUC.setOnAction(event -> {
	    List<String> aulasEscolhidas = new ArrayList<>();

	    for (String item : selectedItems) {
		aulasEscolhidas.add(item);
	    }

	    // Chamar o teu método aqui
	    Horario horario = CriarNovoHorario.criarHorario(horarios, aulasEscolhidas);
	    aulasEscolhidas = null;

	    Calendario.getCalendar().clear();
	    stage.close();
	    Calendario.addHorarioAoCalendario(horario);
	});

	// Cria uma VBox e adiciona o ListView e o botão a ela
	VBox vbox = new VBox(10);
	vbox.setPadding(new Insets(10));
	vbox.getChildren().addAll(listView, btnAdicionarUC);

	// Cria um StackPane e adiciona a VBox a ele
	StackPane root = new StackPane();
	root.getChildren().add(vbox);

	// Cria a cena com o StackPane e define o tamanho
	return new Scene(root, 200, 200);
    }

    /**
     * Mostra a interface para criar um novo horário.
     *
     * @param horario o horário existente
     */
    public static void mostrarInterface(Horario horario) {
	horarios = horario;

	Scene scene = criarInterface();

	// Define o título da janela e exibe
	stage.setTitle("Escolhe as unidades curriculares:");
	stage.setScene(scene);
	stage.show();
    }
}
