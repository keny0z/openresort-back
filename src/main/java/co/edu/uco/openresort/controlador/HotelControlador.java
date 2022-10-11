package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.HotelDTO;
import co.edu.uco.openresort.servicio.fachada.HotelFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
public class HotelControlador {

    @Autowired
    private HotelFachada hotelFachada;

    @GetMapping
    public ArrayList<HotelDTO> consultar(){
        return hotelFachada.consultar();
    }

    @PostMapping
    public HotelDTO registrar(@RequestBody HotelDTO hotelDTO){
        return hotelFachada.registrar(hotelDTO);
    }

    @DeleteMapping(path = "{id}")
    public void eliminar(@PathVariable("id") int id){
        hotelFachada.eliminar(id);
    }

}
