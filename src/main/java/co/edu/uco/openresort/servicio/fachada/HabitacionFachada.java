package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.HabitacionDTO;

import java.util.ArrayList;

public interface HabitacionFachada {

    ArrayList<HabitacionDTO> consultar();
    HabitacionDTO registrar(HabitacionDTO habitacionDTO);
    void eliminar(int id);

    void darAcceso(long idTag, int idHabitacion);

    ArrayList<HabitacionDTO> consultarPorTag(long identificador);
}
