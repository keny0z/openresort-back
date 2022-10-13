package co.edu.uco.openresort.servicio.ensamblador.entidad;



import co.edu.uco.openresort.dominio.HabitacionDominio;
import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.dominio.TipoHabitacionDominio;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public class HabitacionEnsambladorEntidad {

    public static HabitacionDominio ensamblarDominio(HabitacionEntidad habitacionEntidad){
        HabitacionDominio habitacionDominio = new HabitacionDominio();
        HotelDominio hotelDominio = new HotelDominio();
        TipoHabitacionDominio tipoHabitacionDominio = new TipoHabitacionDominio();
        habitacionDominio.setHotel(hotelDominio);
        habitacionDominio.setTipo(tipoHabitacionDominio);

        habitacionDominio.setId(habitacionEntidad.getId());
        habitacionDominio.getHotel().setId(habitacionEntidad.getHotel().getId());
        habitacionDominio.getTipo().setId(habitacionEntidad.getTipo().getId());
        habitacionDominio.setNumero(habitacionEntidad.getNumero());
        habitacionDominio.setDisponible(habitacionEntidad.isDisponible());

        return habitacionDominio;
    }

    public static HabitacionEntidad ensamblarEntidad(HabitacionDominio habitacionDominio){
        HabitacionEntidad habitacionEntidad = new HabitacionEntidad();
        HotelEntidad hotelEntidad = new HotelEntidad();
        TipoHabitacionEntidad tipoHabitacionEntidad = new TipoHabitacionEntidad();
        habitacionEntidad.setHotel(hotelEntidad);
        habitacionEntidad.setTipo(tipoHabitacionEntidad);

        habitacionEntidad.setId(habitacionDominio.getId());
        habitacionEntidad.getHotel().setId(habitacionDominio.getHotel().getId());
        habitacionEntidad.getTipo().setId(habitacionDominio.getTipo().getId());
        habitacionEntidad.setNumero(habitacionDominio.getNumero());
        habitacionEntidad.setDisponible(habitacionDominio.isDisponible());

        return habitacionEntidad;
    }

    public static ArrayList<HabitacionDominio> ensamblarListaDominio(ArrayList<HabitacionEntidad> listaHabitacionEntidad){
        ArrayList<HabitacionDominio> listaHabitacionDominio = new ArrayList<>();

        for (HabitacionEntidad habitacionEntidad: listaHabitacionEntidad){
            listaHabitacionDominio.add(ensamblarDominio(habitacionEntidad));
        }

        return listaHabitacionDominio;
    }
}
