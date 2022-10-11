package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.dominio.HotelDominio;

import java.util.ArrayList;

public interface HotelServicio {

    ArrayList<HotelDominio> consultar();
    HotelDominio registrar(HotelDominio hotelDominio);
    HotelDominio editar(HotelDominio hotelDominio);
    void eliminar(HotelDominio hotelDominio);

}
