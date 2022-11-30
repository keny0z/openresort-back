package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.*;

import java.io.IOException;
import java.util.ArrayList;

public interface ReservaFachada {
    ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(DisponibilidadDTO disponibilidadDTO);
    ArrayList<TipoHabitacionDTO> consultarDisponibilidadTipoHabitacion(DisponibilidadDTO disponibilidadDTO);
    ReservaDTO reservar(ReservaDTO reservaDTO) throws IOException;
    ArrayList<ReservaDTO> consultar();

}
