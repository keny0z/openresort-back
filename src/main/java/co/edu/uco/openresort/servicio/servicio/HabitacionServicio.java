package co.edu.uco.openresort.servicio.servicio;



import co.edu.uco.openresort.dominio.HabitacionDominio;

import java.util.ArrayList;

public interface HabitacionServicio {

    ArrayList<HabitacionDominio> consultar();
    HabitacionDominio registrar(HabitacionDominio habitacionDominio);
    void eliminar(int id);
}
