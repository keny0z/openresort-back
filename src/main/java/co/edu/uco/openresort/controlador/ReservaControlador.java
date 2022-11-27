package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.servicio.fachada.ReservaFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/reserva")
public class ReservaControlador {

    @Autowired
    private ReservaFachada reservaFachada;

    @PostMapping("/disponibilidad/habitacion")
    public ArrayList<HabitacionDTO> consultarDisponibilidadHabitaciones(@RequestBody DisponibilidadDTO disponibilidadDTO){
        return reservaFachada.consultarDisponibilidadHabitaciones(disponibilidadDTO);
    }
}
