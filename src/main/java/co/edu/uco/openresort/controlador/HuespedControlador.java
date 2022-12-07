package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.HuespedDTO;
import co.edu.uco.openresort.servicio.fachada.HuespedFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/huesped")
public class HuespedControlador {

    @Autowired
    private HuespedFachada huespedFachada;

    @GetMapping
    public ArrayList<HuespedDTO> consultar(){
        return huespedFachada.consultar();
    }

    @PostMapping
    public HuespedDTO registrar(@RequestBody HuespedDTO huespedDTO){
        return huespedFachada.registrar(huespedDTO);
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable("id") int id){
        huespedFachada.eliminar(id);
    }

}
