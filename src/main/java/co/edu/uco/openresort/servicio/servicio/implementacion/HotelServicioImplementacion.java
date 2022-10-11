package co.edu.uco.openresort.servicio.servicio.implementacion;


import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import co.edu.uco.openresort.servicio.ensamblador.entidad.HotelEnsambladorEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class HotelServicioImplementacion implements co.edu.uco.openresort.servicio.servicio.HotelServicio {

    @Autowired
    private HotelRepositorio hotelRepositorio;


    @Override
    public ArrayList<HotelDominio> consultar() {
        return HotelEnsambladorEntidad.ensamblarListaDominio((ArrayList<HotelEntidad>) hotelRepositorio.findAll());
    }

    @Override
    public HotelDominio registrar(HotelDominio hotelDominio) {
        return HotelEnsambladorEntidad.ensamblarDominio(hotelRepositorio.save(HotelEnsambladorEntidad.ensamblarEntidad(hotelDominio)));
    }

    @Override
    public HotelDominio editar(HotelDominio hotelDominio) {
        return null;
    }

    @Override
    public void eliminar(int id) {
        hotelRepositorio.deleteById(id);
    }


    /*@Autowired
    HotelRepositorio hotelRepositorio;


    public HotelEntidad registrar(HotelEntidad hotelEntidad){
        return hotelRepositorio.save(hotelEntidad);
    }

    public ArrayList<HotelEntidad> consultar(){
        return (ArrayList<HotelEntidad>) hotelRepositorio.findAll();
    }*/

}
