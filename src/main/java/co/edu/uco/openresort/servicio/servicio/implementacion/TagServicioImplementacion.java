package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.TagEntidad;
import co.edu.uco.openresort.repositorio.TagRepositorio;
import co.edu.uco.openresort.servicio.servicio.TagServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagServicioImplementacion implements TagServicio {

    @Autowired
    private TagRepositorio tagRepositorio;

    @Override
    public ArrayList<TagEntidad> consultar() {
        return (ArrayList<TagEntidad>) tagRepositorio.findAll();
    }

    @Override
    public ArrayList<TagEntidad> consultarPorHabitacion(int id) {
        return tagRepositorio.findByHabitacionesConAcceso_Id(id);
    }
}
