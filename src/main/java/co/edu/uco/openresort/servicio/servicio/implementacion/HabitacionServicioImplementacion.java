package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.dominio.HabitacionDominio;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.excepcion.ExcepcionHotelNoExiste;
import co.edu.uco.openresort.excepcion.ExcepcionTipoHabitacionNoExiste;
import co.edu.uco.openresort.repositorio.HabitacionRepositorio;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.ensamblador.entidad.HabitacionEnsambladorEntidad;
import co.edu.uco.openresort.servicio.servicio.HabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HabitacionServicioImplementacion implements HabitacionServicio {

    private static final String MENSAJE_HOTEL_NO_EXISTE = "El hotel no existe";
    private static final String MENSAJE_TIPO_HABITACION_NO_EXISTE = "El tipo de habitacion no existe";

    @Autowired
    private HabitacionRepositorio habitacionRepositorio;
    @Autowired
    private HotelRepositorio hotelRepositorio;
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;



    @Override
    public ArrayList<HabitacionDominio> consultar() {
        return HabitacionEnsambladorEntidad.ensamblarListaDominio((ArrayList<HabitacionEntidad>) habitacionRepositorio.findAll());
    }

    @Override
    public HabitacionDominio registrar(HabitacionDominio habitacionDominio) {
        garantizarHotelExiste(habitacionDominio.getHotel().getId());
        garantizarTipoHabitacionExiste(habitacionDominio.getTipo().getId());
        return HabitacionEnsambladorEntidad.ensamblarDominio(habitacionRepositorio.save(HabitacionEnsambladorEntidad.ensamblarEntidad(habitacionDominio)));
    }

    @Override
    public void eliminar(int id) {
        habitacionRepositorio.deleteById(id);
    }

    private void garantizarHotelExiste(int id){
        if(hotelRepositorio.existsById(id)==false){
            throw new ExcepcionHotelNoExiste(MENSAJE_HOTEL_NO_EXISTE);
        }
    }

    private void garantizarTipoHabitacionExiste(int id){
        if(tipoHabitacionRepositorio.existsById(id)==false){
            throw new ExcepcionTipoHabitacionNoExiste(MENSAJE_TIPO_HABITACION_NO_EXISTE);
        }
    }
}
