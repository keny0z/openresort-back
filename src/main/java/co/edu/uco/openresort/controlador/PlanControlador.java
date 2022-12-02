package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.PlanDTO;
import co.edu.uco.openresort.servicio.fachada.PlanFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/plan")
public class PlanControlador {

    @Autowired
    private PlanFachada planFachada;

    @GetMapping
    public ArrayList<PlanDTO> consultar(){
        return planFachada.consultar();
    }

    @PostMapping
    public PlanDTO registrar(@RequestBody PlanDTO planDTO){
        return planFachada.registrar(planDTO);
    }

    @DeleteMapping(path = "{id}")
    public void  eliminar(@PathVariable("id") int id){
        planFachada.eliminar(id);
    }
}
