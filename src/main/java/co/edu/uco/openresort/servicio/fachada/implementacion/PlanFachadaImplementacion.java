package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.PlanDTO;
import co.edu.uco.openresort.servicio.ensamblador.PlanEnsamblador;
import co.edu.uco.openresort.servicio.fachada.PlanFachada;
import co.edu.uco.openresort.servicio.servicio.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlanFachadaImplementacion  implements PlanFachada {

    @Autowired
    private PlanServicio planServicio;

    @Override
    public ArrayList<PlanDTO> consultar() {
        return PlanEnsamblador.ensamblarListaDTO(planServicio.consultar());
    }

    @Override
    public PlanDTO registrar(PlanDTO planDTO) {
        return PlanEnsamblador.ensamblarDTO(planServicio.registrar(PlanEnsamblador.ensamblarEntidad(planDTO)));
    }

    @Override
    public void eliminar(int id) {
        planServicio.eliminar(id);

    }
}
