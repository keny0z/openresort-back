package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.AccesoDTO;
import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.servicio.fachada.HabitacionFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/habtacion")
public class HabitacionControlador {

    @Autowired
    private HabitacionFachada habitacionFachada;

    @GetMapping
    public ArrayList<HabitacionDTO> consultar(){
        return habitacionFachada.consultar();
    }

    @PostMapping
    public HabitacionDTO registrar(@RequestBody HabitacionDTO habitacionDTO){
        return habitacionFachada.registrar(habitacionDTO);
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable("id") int id){
        habitacionFachada.eliminar(id);
    }

    @PostMapping(path = "acceso")
    public void darAcceso(@RequestBody AccesoDTO accesoDTO){
        habitacionFachada.darAcceso(accesoDTO.getIdTag(),accesoDTO.getIdHabitacion());
    }

    @GetMapping(path="/{identificador}")
    public ArrayList<HabitacionDTO> consultarPorTag(@PathVariable("identificador") long identificador){
        return habitacionFachada.consultarPorTag(identificador);
    }
}
