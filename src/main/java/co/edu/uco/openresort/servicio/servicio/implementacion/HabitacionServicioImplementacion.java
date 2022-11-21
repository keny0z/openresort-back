package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.TagEntidad;
import co.edu.uco.openresort.excepcion.*;
import co.edu.uco.openresort.repositorio.HabitacionRepositorio;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import co.edu.uco.openresort.repositorio.TagRepositorio;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.servicio.HabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HabitacionServicioImplementacion implements HabitacionServicio {

    private static final String MENSAJE_HOTEL_NO_EXISTE = "El hotel no existe";
    private static final String MENSAJE_TIPO_HABITACION_NO_EXISTE = "El tipo de habitacion no existe";
    private static final String MENSAJE_NUMERO_HABITACION_REPETIDO = "Ya existe una habitación con el número ingresado, intente con un número distinto";
    private static final String MENSAJE_HABITACION_NO_EXISTE = "La habitacion ingresada no existe, intente con una distinta";



    @Autowired
    private HabitacionRepositorio habitacionRepositorio;
    @Autowired
    private HotelRepositorio hotelRepositorio;
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    @Autowired
    private TagRepositorio tagRepositorio;



    @Override
    public ArrayList<HabitacionEntidad> consultar() {
        return (ArrayList<HabitacionEntidad>) habitacionRepositorio.findAll();
    }

    @Override
    public HabitacionEntidad registrar(HabitacionEntidad habitacionEntidad) {
        garantizarHotelExiste(habitacionEntidad.getHotel().getId());
        garantizarTipoHabitacionExiste(habitacionEntidad.getTipo().getId());
        garantizarNumeroNoRepetido(habitacionEntidad.getNumero());
        return habitacionRepositorio.save(habitacionEntidad);
    }

    @Override
    public void eliminar(int id) {
        garantizarHabitacionExiste(id);
        habitacionRepositorio.deleteById(id);
    }

    @Override
    public void darAcceso(long idTag, int idHabitacion) {

        garantizarHabitacionExiste(idHabitacion);

        Optional<HabitacionEntidad> habitacionEntidad = habitacionRepositorio.findById(idHabitacion);
        TagEntidad tagEntidad = new TagEntidad();
        tagEntidad.setIdentificador(idTag);
        habitacionEntidad.get().getTagsConAcceso().add(tagEntidad);

        tagRepositorio.save(tagEntidad);
        habitacionRepositorio.save(habitacionEntidad.get());
    }

    @Override
    public ArrayList<HabitacionEntidad> consultarPorTag(long identificador) {
        return habitacionRepositorio.findByTagsConAcceso_Identificador(identificador);
    }

    @Override
    public boolean tieneAcceso(long idTag, int idHabitacion) {
        garantizarHabitacionExiste(idHabitacion);

        ArrayList<HabitacionEntidad> habitaciones = consultarPorTag(idTag);
        if(habitaciones.contains(habitacionRepositorio.findById(idHabitacion).get())){
            return true;
        }else {
            return false;
        }

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

    private void garantizarNumeroNoRepetido(String numero){
        if(habitacionRepositorio.existsByNumero(numero)){
            throw new ExcepcionHabitacionNumeroRepetido(MENSAJE_NUMERO_HABITACION_REPETIDO);
        }
    }

    private void garantizarHabitacionExiste(int id){
        if(habitacionRepositorio.existsById(id)==false){
            throw new ExcepcionHabitacionNoExiste(MENSAJE_HABITACION_NO_EXISTE);
        }
    }
}
