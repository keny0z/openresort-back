package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.entidad.PlanEntidad;

import java.util.ArrayList;

public interface PlanServicio {

    ArrayList<PlanEntidad> consultar();
    PlanEntidad registrar(PlanEntidad planEntidad);
    void eliminar(int id);

}
