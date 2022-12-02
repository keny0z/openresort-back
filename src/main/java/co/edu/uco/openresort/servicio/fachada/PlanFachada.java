package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.PlanDTO;

import java.util.ArrayList;

public interface PlanFachada {

    ArrayList<PlanDTO> consultar();
    PlanDTO registrar(PlanDTO planDTO);
    void eliminar(int id);
}
