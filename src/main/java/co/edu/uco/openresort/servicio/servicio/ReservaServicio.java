package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.dto.RespuestaDisponibilidadDTO;
import co.edu.uco.openresort.dto.ConsultaDisponibilidadDTO;
import co.edu.uco.openresort.dto.ReservaDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.io.IOException;
import java.util.ArrayList;

public interface ReservaServicio {
    ArrayList<HabitacionEntidad> consultarDisponibilidadHabitaciones(ConsultaDisponibilidadDTO disponibilidadDTO);

    ArrayList<TipoHabitacionEntidad> consultarDisponibilidadTipoHabitacion(ConsultaDisponibilidadDTO disponibilidadDTO);

    ReservaEntidad reservar(ReservaDTO reservaDTO) throws IOException;

    ArrayList<ReservaEntidad> consultar();

    ArrayList<RespuestaDisponibilidadDTO> obtenerListaDisponibilidad(ConsultaDisponibilidadDTO disponibilidadDTO);
}
