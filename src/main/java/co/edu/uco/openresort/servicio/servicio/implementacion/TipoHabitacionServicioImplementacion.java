package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.dominio.TipoHabitacionDominio;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.ensamblador.entidad.TipoHabitacionEnsambladorEntidad;
import co.edu.uco.openresort.servicio.servicio.TipoHabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoHabitacionServicioImplementacion implements TipoHabitacionServicio {

    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    @Override
    public ArrayList<TipoHabitacionDominio> consultar() {
        return TipoHabitacionEnsambladorEntidad.ensamblarListaDominio((ArrayList<TipoHabitacionEntidad>) tipoHabitacionRepositorio.findAll());
    }

    @Override
    public TipoHabitacionDominio registrar(TipoHabitacionDominio tipoHabitacionDominio) {
        return TipoHabitacionEnsambladorEntidad.ensamblarDominio(tipoHabitacionRepositorio.save(TipoHabitacionEnsambladorEntidad.ensamblarEntidad(tipoHabitacionDominio)));
    }

    @Override
    public void eliminar(int id) {
        tipoHabitacionRepositorio.deleteById(id);
    }
}
