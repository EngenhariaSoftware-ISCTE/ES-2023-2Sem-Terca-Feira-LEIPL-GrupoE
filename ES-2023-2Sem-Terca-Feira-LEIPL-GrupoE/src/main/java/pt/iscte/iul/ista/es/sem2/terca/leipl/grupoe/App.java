package pt.iscte.iul.ista.es.sem2.terca.leipl.grupoe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.calendarfx.view.*;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        CalendarView calendarView = new CalendarView();
        root.setCenter(calendarView);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Monthly Calendar Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





