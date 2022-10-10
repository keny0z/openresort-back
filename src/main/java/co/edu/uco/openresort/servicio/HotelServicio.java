package co.edu.uco.openresort.servicio;


import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class HotelServicio {

    @Autowired
    HotelRepositorio hotelRepositorio;


    public HotelEntidad registrar(HotelEntidad hotelEntidad){
        return hotelRepositorio.save(hotelEntidad);
    }

    public ArrayList<HotelEntidad> consultar(){
        return (ArrayList<HotelEntidad>) hotelRepositorio.findAll();
    }

}
