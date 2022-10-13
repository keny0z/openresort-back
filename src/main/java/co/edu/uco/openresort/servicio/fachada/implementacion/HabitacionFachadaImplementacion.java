package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.servicio.ensamblador.dto.HabitacionEnsambladorDTO;
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
        return HabitacionEnsambladorDTO.ensamblarListaDTO(habitacionServicio.consultar());
    }

    @Override
    public HabitacionDTO registrar(HabitacionDTO habitacionDTO) {
        return HabitacionEnsambladorDTO.ensamblarDTO(habitacionServicio.registrar(HabitacionEnsambladorDTO.ensamblarDominio(habitacionDTO)));
    }

    @Override
    public void eliminar(int id) {
        habitacionServicio.eliminar(id);
    }
}
