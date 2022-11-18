package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.TagDTO;
import co.edu.uco.openresort.servicio.fachada.TagFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/tag")
public class TagControlador {

    @Autowired
    private TagFachada tagFachada;

    @GetMapping
    public ArrayList<TagDTO> consultar(){
        return tagFachada.consultar();
    }

    @GetMapping(path="/{id}")
    public ArrayList<TagDTO> consultarPorHabitacion(@PathVariable("id") int id){
        return tagFachada.consutarPorHabitacion(id);
    }
}
