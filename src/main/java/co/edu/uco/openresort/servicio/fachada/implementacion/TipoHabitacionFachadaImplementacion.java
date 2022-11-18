package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.TipoHabitacionDTO;
import co.edu.uco.openresort.servicio.ensamblador.TipoHabitacionEnsamblador;
import co.edu.uco.openresort.servicio.fachada.TipoHabitacionFachada;
import co.edu.uco.openresort.servicio.servicio.TipoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoHabitacionFachadaImplementacion implements TipoHabitacionFachada {

    @Autowired
    private TipoHabitacionServicio tipoHabitacionServicio;

    @Override
    public ArrayList<TipoHabitacionDTO> consultar() {
        return TipoHabitacionEnsamblador.ensamblarListaDTO(tipoHabitacionServicio.consultar());
    }

    @Override
    public TipoHabitacionDTO registrar(TipoHabitacionDTO tipoHabitacionDTO) {
        return TipoHabitacionEnsamblador.ensamblarDTO(tipoHabitacionServicio.registrar(TipoHabitacionEnsamblador.ensamblarEntidad(tipoHabitacionDTO)));
    }

    @Override
    public void eliminar(int id) {
        tipoHabitacionServicio.eliminar(id);
    }
}
