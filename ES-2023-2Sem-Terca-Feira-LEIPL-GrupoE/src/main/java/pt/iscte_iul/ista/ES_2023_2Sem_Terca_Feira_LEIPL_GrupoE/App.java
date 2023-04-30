/**
 * Pacote principal do projeto ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.IOException;
import java.text.ParseException;

import com.calendarfx.view.CalendarView;
import com.opencsv.exceptions.CsvException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @autor Tatiana Clim Classe principal do projeto que inicializa a interface
 *        gráfica do usuário.
 */
public class App extends Application {

    /**
     * Inicia a interface gráfica do usuário.
     *
     * @param primaryStage o palco primário da aplicação
     * @throws ParseException se ocorrer um erro de análise ao iniciar a interface
     *                        gráfica
     * @throws IOException
     * @throws CsvException
     */
    @Override
    public void start(Stage primaryStage) throws ParseException, IOException, CsvException {
	BorderPane root = new BorderPane();

	// Cria um calendário
	CalendarView calendarView = VistaCalendario.createCalendarView(new Calendario(), primaryStage);

	root.setCenter(calendarView);

	Scene scene = new Scene(root, 800, 600);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Calendar");
	primaryStage.show();
    }

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args argumentos da linha de comando (não são usados neste projeto)
     */
    public static void main(String[] args) {
	System.setProperty("file.encoding", "UTF-8");
	launch(args);
    }
}
