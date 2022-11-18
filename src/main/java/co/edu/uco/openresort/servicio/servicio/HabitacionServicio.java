package co.edu.uco.openresort.servicio.servicio;



import co.edu.uco.openresort.entidad.HabitacionEntidad;

import java.util.ArrayList;

public interface HabitacionServicio {

    ArrayList<HabitacionEntidad> consultar();
    HabitacionEntidad registrar(HabitacionEntidad habitacionEntidad);
    void eliminar(int id);

    void darAcceso(long idTag, int idHabitacion);

    //consulta las habitaciones que pueden ser accedidas con un tag en especifico
    ArrayList<HabitacionEntidad> consultarPorTag(long identificador);


}
