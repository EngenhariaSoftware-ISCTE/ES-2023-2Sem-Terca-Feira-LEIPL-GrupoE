/**
 * Pacote principal do projeto ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE.
 */
package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Scanner;

import com.calendarfx.view.CalendarView;
import com.opencsv.exceptions.CsvException;

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
     * @throws IOException 
     * @throws CsvException 
     */
    @Override
    public void start(Stage primaryStage) throws ParseException, IOException, CsvException {
        Horario horario = new Horario();
        BorderPane root = new BorderPane();

        // Cria um calendário
        Calendario interfaceHorario = new Calendario(horario);
        CalendarView calendarView = VistaCalendario.createCalendarView(interfaceHorario, primaryStage);
        
        // Cria uma conexão para a URL
        /*   URL url = new URL("https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=tcnaa@iscte.pt&password=KKhqWD3uKUkmptLLf0jivJafrvugF6likWmi7eYwDGhpz54QlyXfpqwZL9svInGtsAbKeQTm3N7vXAs2ZaNJOWZxy2XghclTcVNajX6OOWDVO6brA5SxMEuHgDI90z7C");
        // Lê os dados da URL
        Scanner scanner = new Scanner(url.openStream());
        String content = scanner.useDelimiter("\\Z").next();
      	//  ConversorCSV.lerCSVParaEstrutura(content);
        // Horario hor = ConversorCSV.lerCSVParaEstrutura(content);
        // System.out.println("CSV" +hor.getAulas().get(0));
        scanner.close();*/
        
     // Cria um arquivo temporário CSV
       // File tempFile = File.createTempFile("temp", ".csv");

        // Escreve o conteúdo do content no arquivo temporário
        //FileWriter writer = new FileWriter(tempFile);
        //writer.write(content);
        //writer.close();

        // Chama a função lerCSVParaEstrutura passando o caminho do arquivo temporário
       // Horario h = ConversorCSV.lerCSVParaEstrutura(tempFile.getAbsolutePath());

        // Imprime o resultado
      //  System.out.println(content);

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
