package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.dto.TipoHabitacionDTO;
import co.edu.uco.openresort.servicio.ensamblador.HabitacionEnsamblador;
import co.edu.uco.openresort.servicio.fachada.ReservaFachada;
import co.edu.uco.openresort.servicio.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservaFachadaImplementacion implements ReservaFachada {

    @Autowired
    ReservaServicio reservaServicio;

    @Override
    public ArrayList<HabitacionDTO> consultarDisponibilidad(DisponibilidadDTO disponibilidadDTO) {
        return HabitacionEnsamblador.ensamblarListaDTO(reservaServicio.consultarDisponibilidad(disponibilidadDTO));

    }
}
