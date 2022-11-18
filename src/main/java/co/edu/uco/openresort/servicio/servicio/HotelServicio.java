package co.edu.uco.openresort.servicio.servicio;

import co.edu.uco.openresort.entidad.HotelEntidad;

import java.util.ArrayList;

public interface HotelServicio {

    ArrayList<HotelEntidad> consultar();
    HotelEntidad registrar(HotelEntidad hotelEntidad);
    void eliminar(int id);

}
