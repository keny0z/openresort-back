package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.TagDTO;
import co.edu.uco.openresort.servicio.ensamblador.TagEnsamblador;
import co.edu.uco.openresort.servicio.fachada.TagFachada;
import co.edu.uco.openresort.servicio.servicio.TagServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagFachadaImplementacion implements TagFachada {

    @Autowired
    private TagServicio tagServicio;

    @Override
    public ArrayList<TagDTO> consultar() {
        return TagEnsamblador.ensamblarListaDTO(tagServicio.consultar());
    }
}
