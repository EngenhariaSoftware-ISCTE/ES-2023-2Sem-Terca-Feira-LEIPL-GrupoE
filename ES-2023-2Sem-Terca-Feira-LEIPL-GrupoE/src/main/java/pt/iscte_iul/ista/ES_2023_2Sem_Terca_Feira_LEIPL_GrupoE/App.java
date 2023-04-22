/**
 * Pacote principal do projeto ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.text.ParseException;

import com.calendarfx.view.CalendarView;

/**
 * @autor Tatiana Clim
 * Classe principal do projeto que inicializa a interface gráfica do usuário.
 */
public class App extends Application {

    /**
     * Inicia a interface gráfica do usuário.
     *
     * @param primaryStage o palco primário da aplicação
     * @throws ParseException se ocorrer um erro de análise ao iniciar a interface
     * gráfica
     */
    @Override
    public void start(Stage primaryStage) throws ParseException {
        Horario horario = new Horario();
        BorderPane root = new BorderPane();

        // Cria um calendário
        Calendario interfaceHorario = new Calendario(horario);
        CalendarView calendarView = VistaCalendario.createCalendarView(interfaceHorario, primaryStage);
   
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
        launch(args);
    }
}
