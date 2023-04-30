package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

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

public class InterfaceCriarNovoHorario {
	
	static Horario horarios = null;

    public static Scene criarInterface() {
	
	List<String> listaUCs = horarios.listaUCs();
        // Lista de opções para o dropdown
        ObservableList<String> opcoes = FXCollections.observableList(listaUCs);

        // Cria o ListView com as opções
        ListView<String> listView = new ListView<>(opcoes);

        // Permite que o usuário selecione várias opções
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Cria o botão "Adicionar UC"
        Button btnAdicionarUC = new Button("Adicionar UC");
        
        btnAdicionarUC.setOnAction(event -> {
		//Chamar o teu método aqui
        	CriarNovoHorario.criarHorario(horarios, listaUCs);
	    });

        // Cria uma VBox e adiciona o ListView e o botão a ela
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(listView, btnAdicionarUC);

        // Cria um StackPane e adiciona a VBox a ele
        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        // Cria a cena com o StackPane e define o tamanho
        Scene scene = new Scene(root, 200, 200);

        return scene;
    }

    public static void mostrarInterface(Horario horario) {
	horarios = horario;
	Stage stage = new Stage();
        Scene scene = criarInterface();

        // Define o título da janela e exibe
        stage.setTitle("Dropdown com seleção múltipla e botão");
        stage.setScene(scene);
        stage.show();
    }	

}
