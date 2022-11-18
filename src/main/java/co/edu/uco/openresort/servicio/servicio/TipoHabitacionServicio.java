package co.edu.uco.openresort.servicio.servicio;


import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public interface TipoHabitacionServicio {

    ArrayList<TipoHabitacionEntidad> consultar();
    TipoHabitacionEntidad registrar(TipoHabitacionEntidad tipoHabitacionEntidad);
    void eliminar(int id);
}
