package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.servicio.TipoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoHabitacionServicioImplementacion implements TipoHabitacionServicio {

    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    @Override
    public ArrayList<TipoHabitacionEntidad> consultar() {
        return (ArrayList<TipoHabitacionEntidad>) tipoHabitacionRepositorio.findAll();
    }

    @Override
    public TipoHabitacionEntidad registrar(TipoHabitacionEntidad tipoHabitacionEntidad) {
        return tipoHabitacionRepositorio.save(tipoHabitacionEntidad);
    }

    @Override
    public void eliminar(int id) {
        tipoHabitacionRepositorio.deleteById(id);
    }
}
