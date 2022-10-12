package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.TipoHabitacionDTO;
import co.edu.uco.openresort.servicio.fachada.TipoHabitacionFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("habitacion/tipo")
public class TipoHabitacionControlador {

    @Autowired
    private TipoHabitacionFachada tipoHabitacionFachada;

    @GetMapping
    public ArrayList<TipoHabitacionDTO> consultar(){
        return tipoHabitacionFachada.consultar();
    }

    @PostMapping
    public TipoHabitacionDTO registrar(@RequestBody TipoHabitacionDTO tipoHabitacionDTO){
        return tipoHabitacionFachada.registrar(tipoHabitacionDTO);
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable("id") int id){
        tipoHabitacionFachada.eliminar(id);
    }
}
