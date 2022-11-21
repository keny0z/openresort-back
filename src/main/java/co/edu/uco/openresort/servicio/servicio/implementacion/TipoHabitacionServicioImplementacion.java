package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.excepcion.ExcepcionHotelNoExiste;
import co.edu.uco.openresort.excepcion.ExcepcionHotelNombreRepetido;
import co.edu.uco.openresort.excepcion.ExcepcionTipoHabitacionNoExiste;
import co.edu.uco.openresort.excepcion.ExcepcionTipoHabitacionNombreRepetido;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.servicio.TipoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoHabitacionServicioImplementacion implements TipoHabitacionServicio {

    private static final String MENSAJE_NOMBRE_TIPO_HABITACION_REPETIDO = "Ya existe un tipo de habitacion con el nombre ingresado, intente con un nombre distinto";
    private static final String MENSAJE_TIPO_HABITACION_ELIMINAR_NO_EXISTE = "El tipo de habitacion que está intentando eliminar no existe, intente con uno distinto";


    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    @Override
    public ArrayList<TipoHabitacionEntidad> consultar() {
        return (ArrayList<TipoHabitacionEntidad>) tipoHabitacionRepositorio.findAll();
    }

    @Override
    public TipoHabitacionEntidad registrar(TipoHabitacionEntidad tipoHabitacionEntidad) {
        garantizarNombreNoRepetido(tipoHabitacionEntidad.getNombre());
        return tipoHabitacionRepositorio.save(tipoHabitacionEntidad);
    }

    @Override
    public void eliminar(int id) {
        garantizarTipoHabitacionExiste(id);
        tipoHabitacionRepositorio.deleteById(id);
    }

    private void garantizarNombreNoRepetido(String nombre){
        if(tipoHabitacionRepositorio.existsByNombre(nombre)){
            throw new ExcepcionTipoHabitacionNombreRepetido(MENSAJE_NOMBRE_TIPO_HABITACION_REPETIDO);
        }
    }

    private void garantizarTipoHabitacionExiste(int id){
        if(tipoHabitacionRepositorio.existsById(id)==false){
            throw new ExcepcionTipoHabitacionNoExiste(MENSAJE_TIPO_HABITACION_ELIMINAR_NO_EXISTE);
        }
    }
}
