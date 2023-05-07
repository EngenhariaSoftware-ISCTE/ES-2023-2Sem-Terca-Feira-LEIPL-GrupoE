package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Error {

    public static void setError(String header, String e) {
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("Erro");
	alert.setHeaderText(header);
	alert.setContentText(e);
	alert.showAndWait();
    }
}
