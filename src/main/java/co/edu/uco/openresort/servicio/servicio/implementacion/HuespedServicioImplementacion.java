package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.HuespedEntidad;
import co.edu.uco.openresort.repositorio.HuespedRepositorio;
import co.edu.uco.openresort.servicio.servicio.HuespedServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HuespedServicioImplementacion implements HuespedServicio {


    @Autowired
    private HuespedRepositorio huespedRepositorio;
/*    @Autowired
    private ReservaRepositorio reservaRepositorio;*/


    @Override
    public ArrayList<HuespedEntidad> consultar() {
        return (ArrayList<HuespedEntidad>) huespedRepositorio.findAll();
    }

    @Override
    public HuespedEntidad registrar(HuespedEntidad huespedEntidad) {
        return huespedRepositorio.save(huespedEntidad);
    }

    @Override
    public void eliminar(int id) {
        huespedRepositorio.deleteById(id);
    }


}