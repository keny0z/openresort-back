package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.dominio.HabitacionDominio;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.repositorio.HabitacionRepositorio;
import co.edu.uco.openresort.servicio.ensamblador.entidad.HabitacionEnsambladorEntidad;
import co.edu.uco.openresort.servicio.servicio.HabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HabitacionServicioImplementacion implements HabitacionServicio {

    @Autowired
    private HabitacionRepositorio habitacionRepositorio;


    @Override
    public ArrayList<HabitacionDominio> consultar() {
        return HabitacionEnsambladorEntidad.ensamblarListaDominio((ArrayList<HabitacionEntidad>) habitacionRepositorio.findAll());
    }

    @Override
    public HabitacionDominio registrar(HabitacionDominio habitacionDominio) {
        return HabitacionEnsambladorEntidad.ensamblarDominio(habitacionRepositorio.save(HabitacionEnsambladorEntidad.ensamblarEntidad(habitacionDominio)));
    }

    @Override
    public void eliminar(int id) {
        habitacionRepositorio.deleteById(id);
    }
}
