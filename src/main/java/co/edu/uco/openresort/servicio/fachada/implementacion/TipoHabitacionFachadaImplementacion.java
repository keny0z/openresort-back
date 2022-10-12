package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.TipoHabitacionDTO;
import co.edu.uco.openresort.servicio.ensamblador.dto.TipoHabitacionEnsambladorDTO;
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
        return TipoHabitacionEnsambladorDTO.ensamblarListaDTO(tipoHabitacionServicio.consultar());
    }

    @Override
    public TipoHabitacionDTO registrar(TipoHabitacionDTO tipoHabitacionDTO) {
        return TipoHabitacionEnsambladorDTO.ensamblarDTO(tipoHabitacionServicio.registrar(TipoHabitacionEnsambladorDTO.ensamblarDominio(tipoHabitacionDTO)));
    }

    @Override
    public void eliminar(int id) {
        tipoHabitacionServicio.eliminar(id);
    }
}
