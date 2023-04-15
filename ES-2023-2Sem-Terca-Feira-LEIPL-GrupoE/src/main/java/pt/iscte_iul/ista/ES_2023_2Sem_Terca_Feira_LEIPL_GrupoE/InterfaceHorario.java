package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;


public class InterfaceHorario {
		private static Calendar<Aula> calendar;	 
		
		
		public InterfaceHorario (Horario horario) {
			calendar = new Calendar<Aula>("Calendar");		
			addHorarioAoCalendario(horario);
		}
				
		public void addHorarioAoCalendario(Horario horario) {
			
			 for (Aula aula : horario.getAulas()) {
				 Entry<Aula> entry = new Entry<>(aula.getUC());
			        entry.setUserObject(aula);
			        entry.setInterval(aula.getHoraInicio(),aula.getHoraFim() );
			        calendar.addEntry(entry);
		        }
		}
		
		public Calendar<Aula> getCalendar() {
			return calendar;
		}
}
