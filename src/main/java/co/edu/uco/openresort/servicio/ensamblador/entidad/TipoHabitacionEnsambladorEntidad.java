package co.edu.uco.openresort.servicio.ensamblador.entidad;



import co.edu.uco.openresort.dominio.TipoHabitacionDominio;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public class TipoHabitacionEnsambladorEntidad {
    public static TipoHabitacionDominio ensamblarDominio(TipoHabitacionEntidad tipoHabitacionEntidad){
        TipoHabitacionDominio tipoHabitacionDominio = new TipoHabitacionDominio();

        tipoHabitacionDominio.setId(tipoHabitacionEntidad.getId());
        tipoHabitacionDominio.setNombre(tipoHabitacionEntidad.getNombre());
        tipoHabitacionDominio.setDescripcion(tipoHabitacionEntidad.getDescripcion());
        tipoHabitacionDominio.setCapacidadAdultos(tipoHabitacionEntidad.getCapacidadAdultos());
        tipoHabitacionDominio.setCapacidadNinos(tipoHabitacionEntidad.getCapacidadNinos());
        tipoHabitacionDominio.setPrecioDiaSol(tipoHabitacionEntidad.getPrecioDiaSol());
        tipoHabitacionDominio.setPrecioNoche(tipoHabitacionEntidad.getPrecioNoche());

        return tipoHabitacionDominio;
    }

    public static TipoHabitacionEntidad ensamblarEntidad(TipoHabitacionDominio tipoHabitacionDominio){
        TipoHabitacionEntidad tipoHabitacionEntidad = new TipoHabitacionEntidad();

        tipoHabitacionEntidad.setId(tipoHabitacionDominio.getId());
        tipoHabitacionEntidad.setNombre(tipoHabitacionDominio.getNombre());
        tipoHabitacionEntidad.setDescripcion(tipoHabitacionDominio.getDescripcion());
        tipoHabitacionEntidad.setCapacidadAdultos(tipoHabitacionDominio.getCapacidadAdultos());
        tipoHabitacionEntidad.setCapacidadNinos(tipoHabitacionDominio.getCapacidadNinos());
        tipoHabitacionEntidad.setPrecioDiaSol(tipoHabitacionDominio.getPrecioDiaSol());
        tipoHabitacionEntidad.setPrecioNoche(tipoHabitacionDominio.getPrecioNoche());

        return tipoHabitacionEntidad;
    }

    public static ArrayList<TipoHabitacionDominio> ensamblarListaDominio(ArrayList<TipoHabitacionEntidad> listatipoHabitacionEntidad){
        ArrayList<TipoHabitacionDominio> listatipoHabitacionDominio = new ArrayList<>();

        for (TipoHabitacionEntidad tipoHabitacionEntidad: listatipoHabitacionEntidad){
            listatipoHabitacionDominio.add(ensamblarDominio(tipoHabitacionEntidad));
        }

        return listatipoHabitacionDominio;
    }
}
