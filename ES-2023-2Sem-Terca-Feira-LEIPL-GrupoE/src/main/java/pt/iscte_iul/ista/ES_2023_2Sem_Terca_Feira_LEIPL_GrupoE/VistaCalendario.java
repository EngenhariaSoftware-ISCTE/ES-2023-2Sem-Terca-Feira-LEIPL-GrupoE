package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.time.temporal.WeekFields;

import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Tatiana Clim Classe responsável por criar a vista do calendário, onde
 *         é possível visualizar as aulas agendadas. Utiliza a biblioteca
 *         CalendarFX para gerar o calendário e os seus componentes.
 */

public class VistaCalendario {
    /**
     * Cria e retorna a vista do calendário para ser exibida na interface gráfica.
     * 
     * @param interfaceHorario o objeto que contém as aulas a serem exibidas no
     *                         calendário
     * @param stage            o palco principal da aplicação
     * @return o objeto CalendarView que representa a vista do calendário
     * 
     */
    public static CalendarView createCalendarView(Calendario interfaceHorario, Stage stage) {
	CalendarView calendarView = new CalendarView();
	// Adiciona o calendário ao CalendarView
	CalendarSource calendarSource = new CalendarSource("My Calendars");
	calendarSource.getCalendars().addAll(Calendario.getCalendar());
	calendarView.getCalendarSources().addAll(calendarSource);

	// Não deixa o utilizador criar novos eventos no calendário
	calendarView.addEventFilter(MouseEvent.MOUSE_CLICKED, MouseEvent::consume);

	Ficheiro ficheiro = new Ficheiro(stage, interfaceHorario, new Horario());

	// Obtém as referências aos botões
	Button loadButton = new Button("Carregar Ficheiro");
	Button exportButton = ficheiro.getExportButton();

	// Novo botão para criar novo horário criado pelo(a) aluno(a)
	Button criarNovoHorario = new Button("Criar Horário");
	criarNovoHorario.setOnAction(event -> {
	    if (ficheiro.getHorario().getAulas().isEmpty()) {
		Error.setError("Erro", "Tem de carregar um ficheiro primeiro!");
	    } else {
		InterfaceCriarNovoHorario.mostrarInterface(ficheiro.getHorario());
	    }
	});

	ToolBar customToolbar = new ToolBar(loadButton, exportButton, criarNovoHorario);

	loadButton.setOnAction(event -> InterfaceCarregamentoFicheiros.createPopup(ficheiro));

	// Adiciona a barra de ferramentas personalizada ao cabeçalho do CalendarView
	calendarView.setHeader(customToolbar);

	// desabilita o botão de calendários
	calendarView.setShowAddCalendarButton(false);
	calendarView.setCalendarVisibility(null, false);

	// Semana comeca com segunda-feira
	calendarView.weekFieldsProperty().set(WeekFields.ISO);

	return calendarView;
    }
}
