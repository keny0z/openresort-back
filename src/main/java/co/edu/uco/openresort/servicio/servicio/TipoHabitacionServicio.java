package co.edu.uco.openresort.servicio.servicio;


import co.edu.uco.openresort.dominio.TipoHabitacionDominio;

import java.util.ArrayList;

public interface TipoHabitacionServicio {

    ArrayList<TipoHabitacionDominio> consultar();
    TipoHabitacionDominio registrar(TipoHabitacionDominio tipoHabitacionDominio);
    void eliminar(int id);
}
