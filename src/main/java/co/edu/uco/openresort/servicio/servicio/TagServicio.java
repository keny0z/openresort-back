package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.entidad.TagEntidad;

import java.util.ArrayList;

public interface TagServicio {
    ArrayList<TagEntidad> consultar();
    ArrayList<TagEntidad> consultarPorHabitacion(int id);
}
