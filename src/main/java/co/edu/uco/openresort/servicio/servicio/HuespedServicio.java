package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.entidad.HuespedEntidad;

import java.util.ArrayList;

public interface HuespedServicio {

    ArrayList<HuespedEntidad> consultar();
    HuespedEntidad registrar(HuespedEntidad huespedEntidad);
    void eliminar(int id);
}
