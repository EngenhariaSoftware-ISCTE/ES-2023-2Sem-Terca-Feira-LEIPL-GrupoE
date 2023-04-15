package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.text.ParseException;

import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.*;

public class App extends Application {

    @Override
    public void start(Stage stage) throws ParseException {
        BorderPane root = new BorderPane();
        CalendarView calendarView = new CalendarView();       

        root.setCenter(calendarView);
        
     // Cria um calendário
        Horario horario = new Horario();
        InterfaceHorario verHorario = new InterfaceHorario(horario);
        
        
     // Adiciona o calendário ao CalendarView
        CalendarSource calendarSource = new CalendarSource("My Calendars");
        calendarSource.getCalendars().addAll(verHorario.getCalendar());
        calendarView.getCalendarSources().addAll(calendarSource);
        
      //Não deixa o utilizador criar novos eventos no calendário
        EventHandler<MouseEvent> handler = MouseEvent::consume;
        calendarView.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Monthly Calendar Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





