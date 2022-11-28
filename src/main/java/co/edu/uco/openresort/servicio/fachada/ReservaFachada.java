package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.*;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public interface ReservaFachada {
    ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(DisponibilidadDTO disponibilidadDTO);
    ArrayList<TipoHabitacionDTO> consultarDisponibilidadTipoHabitacion(DisponibilidadDTO disponibilidadDTO);
    ReservaDTO reservar(ReservaDTO reservaDTO);

}
