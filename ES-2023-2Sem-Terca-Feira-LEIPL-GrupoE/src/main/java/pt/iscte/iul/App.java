package pt.iscte.iul;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.*;

public class App extends Application {

    @Override
    public void start(Stage stage) throws ParseException {
        BorderPane root = new BorderPane();
        CalendarView calendarView = new CalendarView();       

        root.setCenter(calendarView);
        
     // Cria um calendário
        Calendar<Aula> calendar = new Calendar<Aula>("My Calendar");
        
        
        String nome = "Programação Orientada a Objetos";
        String curso = "Ciência da Computação";
        String turno = "Manhã";
        String turma = "Turma A";
        int inscritos = 30;
        String dia = "Segunda-feira";
        String hora_inicio = "08:00";
        LocalTime localTime = LocalTime.parse(hora_inicio);

        String hora_fim = "10:00";
        LocalTime localTime2 = LocalTime.parse(hora_fim);
        Instant now = Instant.now();
        long timestamp = now.getEpochSecond();
        Date data = new Date(timestamp); // 2009-02-14T00:31:30Z
        String sala = "Sala 101";
        int lotacao = 40;
        Aula aula = new Aula(nome, curso, turno, turma, inscritos, dia, hora_inicio, hora_fim, data, sala, lotacao);
        
        // Cria uma entrada (entry) para a aula
       /* Entry<Aula> entry = new Entry<>();
        entry.setTitle(aula.getNome());
        entry.changeStartDate(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        entry.changeStartTime(LocalTime.parse(aula.getHora_inicio()));
        entry.changeEndTime(LocalTime.parse(aula.getHora_fim()));
        entry.setUserObject(aula);*/
        Entry<Aula> entry = new Entry<>(aula.getNome());
        entry.setUserObject(aula);
        entry.setInterval(localTime,localTime2 );
        calendar.addEntry(entry);
        
        
     // Adiciona o calendário ao CalendarView
        CalendarSource calendarSource = new CalendarSource("My Calendars");
        calendarSource.getCalendars().addAll(calendar);
        
        calendarView.getCalendarSources().addAll(calendarSource);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Monthly Calendar Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





