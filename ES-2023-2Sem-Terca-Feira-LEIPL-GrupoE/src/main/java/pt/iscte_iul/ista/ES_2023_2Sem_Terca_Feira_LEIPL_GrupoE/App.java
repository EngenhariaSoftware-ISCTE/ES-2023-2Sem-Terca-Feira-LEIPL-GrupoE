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
 * Classe principal do projeto que inicializa a interface gráfica do usuário.
 * 
 * @author Tatiana Clim
 */
public class App extends Application {

    /**
     * Inicia a interface gráfica do usuário.
     *
     * @param primaryStage o palco primário da aplicação
     * @throws ParseException se ocorrer um erro de análise ao iniciar a interface
     *                        gráfica
     * @throws IOException    se ocorrer um erro de I/O ao iniciar a interface
     *                        gráfica
     * @throws CsvException   se ocorrer um erro ao manipular o arquivo CSV
     */
    @Override
    public void start(Stage primaryStage) throws ParseException, IOException, CsvException {
	BorderPane root = new BorderPane();
	Calendario calendar = new Calendario();

	// Cria um calendário
	CalendarView calendarView = VistaCalendario.createCalendarView(calendar, primaryStage);

	root.setCenter(calendarView);

	Scene scene = new Scene(root, 800, 600);
	scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
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
