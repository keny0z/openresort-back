package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.dto.HotelDTO;
import co.edu.uco.openresort.servicio.fachada.HotelFachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
public class HotelControlador {
   /* @Autowired
    HotelServicio hotelServicio;

    @GetMapping()
    public ArrayList<HotelEntidad> consultar(){
        return hotelServicio.consultar();
    }

    @PostMapping()
    public HotelEntidad registrar(@RequestBody HotelEntidad hotelEntidad){
        return hotelServicio.registrar(hotelEntidad);
    }*/

    @Autowired
    private HotelFachada hotelFachada;

    @GetMapping
    public ArrayList<HotelDTO> consultar(){
        return hotelFachada.consultar();
    }
}
