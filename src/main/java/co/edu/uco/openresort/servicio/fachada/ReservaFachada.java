package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.dto.TipoHabitacionDTO;

import java.util.ArrayList;

public interface ReservaFachada {
    ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(DisponibilidadDTO disponibilidadDTO);

}
