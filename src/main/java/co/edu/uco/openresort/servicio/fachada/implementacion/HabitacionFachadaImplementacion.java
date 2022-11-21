package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.servicio.ensamblador.HabitacionEnsamblador;
import co.edu.uco.openresort.servicio.fachada.HabitacionFachada;
import co.edu.uco.openresort.servicio.servicio.HabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HabitacionFachadaImplementacion implements HabitacionFachada {

    @Autowired
    private HabitacionServicio habitacionServicio;

    @Override
    public ArrayList<HabitacionDTO> consultar() {
        return HabitacionEnsamblador.ensamblarListaDTO(habitacionServicio.consultar());
    }

    @Override
    public HabitacionDTO registrar(HabitacionDTO habitacionDTO) {
        return HabitacionEnsamblador.ensamblarDTO(habitacionServicio.registrar(HabitacionEnsamblador.ensamblarEntidad(habitacionDTO)));
    }

    @Override
    public void eliminar(int id) {
        habitacionServicio.eliminar(id);
    }

    @Override
    public String darAcceso(long idTag, int idHabitacion) {
        return habitacionServicio.darAcceso(idTag,idHabitacion);
    }

    @Override
    public ArrayList<HabitacionDTO> consultarPorTag(long identificador) {
        return HabitacionEnsamblador.ensamblarListaDTO(habitacionServicio.consultarPorTag(identificador));
    }

    @Override
    public boolean tieneAcceso(long idTag, int idHabitacion) {
        return habitacionServicio.tieneAcceso(idTag,idHabitacion);
    }
}
