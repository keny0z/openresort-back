package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.dto.ConsultaDisponibilidadDTO;
import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.dto.ReservaDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.io.IOException;
import java.util.ArrayList;

public interface ReservaServicio {
    ArrayList<HabitacionEntidad> consultarDisponibilidadHabitaciones(DisponibilidadDTO disponibilidadDTO);

    ArrayList<TipoHabitacionEntidad> consultarDisponibilidadTipoHabitacion(DisponibilidadDTO disponibilidadDTO);

    ReservaEntidad reservar(ReservaDTO reservaDTO) throws IOException;

    ArrayList<ReservaEntidad> consultar();

    ArrayList<ConsultaDisponibilidadDTO> obtenerListaDisponibilidad(DisponibilidadDTO disponibilidadDTO);
}
