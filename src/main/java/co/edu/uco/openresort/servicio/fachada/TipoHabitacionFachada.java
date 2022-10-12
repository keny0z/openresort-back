package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.TipoHabitacionDTO;

import java.util.ArrayList;

public interface TipoHabitacionFachada {

    ArrayList<TipoHabitacionDTO> consultar();
    TipoHabitacionDTO registrar(TipoHabitacionDTO tipoHabitacionDTO);
    void eliminar(int id);
}
