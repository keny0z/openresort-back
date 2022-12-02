package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.PlanEntidad;
import co.edu.uco.openresort.repositorio.PlanRepositorio;
import co.edu.uco.openresort.servicio.servicio.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlanServicioImplementacion implements PlanServicio {

    @Autowired
    private PlanRepositorio planRepositorio;

    @Override
    public ArrayList<PlanEntidad> consultar() {
        return (ArrayList<PlanEntidad>) planRepositorio.findAll();
    }

    @Override
    public PlanEntidad registrar(PlanEntidad planEntidad) {
        return planRepositorio.save(planEntidad);
    }

    @Override
    public void eliminar(int id) {
        planRepositorio.deleteById(id);
    }
}
