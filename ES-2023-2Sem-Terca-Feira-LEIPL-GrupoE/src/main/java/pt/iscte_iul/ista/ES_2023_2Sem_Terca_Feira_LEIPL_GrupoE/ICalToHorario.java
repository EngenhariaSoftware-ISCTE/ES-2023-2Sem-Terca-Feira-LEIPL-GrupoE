package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe ICalToHorario que converte um objeto Calendar (ical4j) em um objeto Horario.
 */
public class ICalToHorario {

    /**
     * Converte um objeto Calendar (ical4j) em um objeto Horario.
     *
     * @param calendar Objeto Calendar do ical4j
     * @return Objeto Horario convertido
     */
    public static Horario convertCalendarToHorario(Calendar calendar) {
        Horario horario = new Horario();

        for (Component component : calendar.getComponents()) {
            if (component instanceof VEvent) {
                VEvent event = (VEvent) component;
                Aula aula = convertEventToAula(event);
                horario.adicionaAula(aula);
            }
        }

        return horario;
    }

    /**
     * Converte um objeto VEvent (ical4j) em um objeto Aula.
     *
     * @param event Objeto VEvent do ical4j
     * @return Objeto Aula convertido
     */
    private static Aula convertEventToAula(VEvent event) {
        String summary = event.getProperty("SUMMARY").isPresent() ? event.getProperty("SUMMARY").get().getValue() : "";
        String location = event.getProperty("LOCATION").isPresent() ? event.getProperty("LOCATION").get().getValue() : "";
        Instant dtStart = event.getStartDate().isPresent() ? (Instant) event.getStartDate().get().getDate() : null;
        Instant dtEnd = event.getEndDate().isPresent() ? (Instant) event.getEndDate().get().getDate() : null;
        String description = event.getProperty("DESCRIPTION").isPresent() ? event.getProperty("DESCRIPTION").get().getValue() : "";


        String uc = summary != null ? summary : "";
        String sala = location != null ? location : "";
        LocalDateTime dataInicio = dtStart != null ? dtStart.atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
        LocalDateTime dataFim = dtEnd != null ? dtEnd.atZone(ZoneId.systemDefault()).toLocalDateTime() : null;

        Aula aula = new Aula();



        //Default visto que a informação não está disponível no iCal
        aula.setCurso("NA");
        aula.setInscritos(0);
        aula.setLotacao(30);
        aula.setTurma("NA");

        aula.setUC(uc);
        aula.setTurno(getTurnoFromDescription(description));
        aula.setDia(getDiaSemana(dataInicio));
        aula.setData(dataInicio != null ? dataInicio.toLocalDate() : null);
        aula.setHoraInicio(dataInicio != null ? dataInicio.toLocalTime() : null);
        aula.setHoraFim(dataFim != null ? dataFim.toLocalTime() : null);
        aula.setSala(sala);


        return aula;
    }

    /**
     * Obtém o dia da semana de um objeto LocalDateTime.
     *
     * @param data Objeto LocalDateTime com a data desejada
     * @return String com a abreviação do dia da semana em português
     */
    private static String getDiaSemana(LocalDateTime data) {
        if (data == null) {
            return "";
        }
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        Map<DayOfWeek, String> dayOfWeekMap = new HashMap<>();
        dayOfWeekMap.put(DayOfWeek.MONDAY, "Seg");
        dayOfWeekMap.put(DayOfWeek.TUESDAY, "Ter");
        dayOfWeekMap.put(DayOfWeek.WEDNESDAY, "Qua");
        dayOfWeekMap.put(DayOfWeek.THURSDAY, "Qui");
        dayOfWeekMap.put(DayOfWeek.FRIDAY, "Sex");
        dayOfWeekMap.put(DayOfWeek.SATURDAY, "Sab");
        dayOfWeekMap.put(DayOfWeek.SUNDAY, "Dom");

        return dayOfWeekMap.get(dayOfWeek);
    }


    /**
     * Obtém o turno de uma descrição de evento.
     *
     * @param description String com a descrição do evento
     * @return String com o turno extraído da descrição
     */
    private static String getTurnoFromDescription(String description) {
        Pattern pattern = Pattern.compile("Turno:\\s*(\\S+)");
        Matcher matcher = pattern.matcher(description);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return "";
    }

}
