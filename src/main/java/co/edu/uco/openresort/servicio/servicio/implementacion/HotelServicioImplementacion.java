package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class HotelServicioImplementacion implements co.edu.uco.openresort.servicio.servicio.HotelServicio {

    @Autowired
    private HotelRepositorio hotelRepositorio;


    @Override
    public ArrayList<HotelEntidad> consultar() {
        return (ArrayList<HotelEntidad>) hotelRepositorio.findAll();
    }

    @Override
    public HotelEntidad registrar(HotelEntidad hotelEntidad) {
        return hotelRepositorio.save(hotelEntidad);
    }

    @Override
    public void eliminar(int id) {
        hotelRepositorio.deleteById(id);
    }

}
