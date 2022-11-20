package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.excepcion.ExcepcionHotelNoExiste;
import co.edu.uco.openresort.excepcion.ExcepcionHotelNombreRepetido;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class HotelServicioImplementacion implements co.edu.uco.openresort.servicio.servicio.HotelServicio {

    private static final String MENSAJE_NOMBRE_HOTEL_REPETIDO = "Ya existe un hotel con el nombre ingresado, intente con un nombre distinto";
    private static final String MENSAJE_HOTEL_ELIMINAR_NO_EXISTE = "El hotel que está intentando eliminar no existe, intente con uno distinto";


    @Autowired
    private HotelRepositorio hotelRepositorio;


    @Override
    public ArrayList<HotelEntidad> consultar() {
        return (ArrayList<HotelEntidad>) hotelRepositorio.findAll();
    }

    @Override
    public HotelEntidad registrar(HotelEntidad hotelEntidad) {
        garantizarNombreNoRepetido(hotelEntidad.getNombre());
        return hotelRepositorio.save(hotelEntidad);
    }

    @Override
    public void eliminar(int id) {
        garantizarHotelExiste(id);
        hotelRepositorio.deleteById(id);
    }

    private void garantizarNombreNoRepetido(String nombre){
        if(hotelRepositorio.existsByNombre(nombre)){
            throw new ExcepcionHotelNombreRepetido(MENSAJE_NOMBRE_HOTEL_REPETIDO);
        }
    }

    private void garantizarHotelExiste(int id){
        if(hotelRepositorio.existsById(id)==false){
            throw new ExcepcionHotelNoExiste(MENSAJE_HOTEL_ELIMINAR_NO_EXISTE);
        }
    }

}
