package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.HuespedDTO;

import java.util.ArrayList;

public interface HuespedFachada {
    ArrayList<HuespedDTO> consultar();
    HuespedDTO registrar(HuespedDTO huespedDTO);
    void eliminar(int id);
}
