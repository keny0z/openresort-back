package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.HuespedDTO;
import co.edu.uco.openresort.servicio.ensamblador.HuespedEnsamblador;
import co.edu.uco.openresort.servicio.fachada.HuespedFachada;
import co.edu.uco.openresort.servicio.servicio.HuespedServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HuespedFachadaImplementacion implements HuespedFachada {

    @Autowired
    private HuespedServicio huespedServicio;

    @Override
    public ArrayList<HuespedDTO> consultar() {
        return HuespedEnsamblador.ensamblarListaDTO(huespedServicio.consultar());
    }

    @Override
    public HuespedDTO registrar(HuespedDTO huespedDTO) {
        return HuespedEnsamblador.ensamblarDTO(huespedServicio.registrar(HuespedEnsamblador.ensamblarEntidad(huespedDTO)));
    }

    @Override
    public void eliminar(int id) {
        huespedServicio.eliminar(id);

    }
}
