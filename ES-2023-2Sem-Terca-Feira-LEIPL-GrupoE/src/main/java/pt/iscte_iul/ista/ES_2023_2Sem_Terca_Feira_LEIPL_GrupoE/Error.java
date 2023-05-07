package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author Tatiana Clim Classe utilitária para exibir mensagens de erro em um
 *         diálogo de alerta.
 */
public class Error {

    /**
     * Exibe um diálogo de alerta de erro com o cabeçalho e a mensagem
     * especificados.
     *
     * @param header  o cabeçalho do diálogo de alerta
     * @param message a mensagem de erro a ser exibida
     */
    public static void setError(String header, String message) {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Erro");
	alert.setHeaderText(header);
	alert.setContentText(message);
	alert.showAndWait();
    }
}
