package co.edu.uco.openresort.servicio.ensamblador.entidad;

import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.entidad.HotelEntidad;

import java.util.ArrayList;

public class HotelEnsambladorEntidad {

    public static HotelDominio ensamblarDominio(HotelEntidad hotelEntidad){
        HotelDominio hotelDominio = new HotelDominio();
        hotelDominio.setNombre(hotelEntidad.getNombre());
        return hotelDominio;
    }

    public static HotelEntidad ensamblarEntidad(HotelDominio hotelDominio){
        HotelEntidad hotelEntidad = new HotelEntidad();
        hotelEntidad.setId(hotelDominio.getId());
        hotelEntidad.setNombre(hotelDominio.getNombre());
        return hotelEntidad;
    }

    public static ArrayList<HotelDominio> ensamblarListaDominio(ArrayList<HotelEntidad> listaHotelEntidad){
        ArrayList<HotelDominio> listaHotelDominio = new ArrayList<>();
        for (HotelEntidad hotelEntidad: listaHotelEntidad){
            listaHotelDominio.add(ensamblarDominio(hotelEntidad));
        }
        return listaHotelDominio;
    }
}
