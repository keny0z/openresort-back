package co.edu.uco.openresort.controlador;

import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.servicio.HotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
public class HotelControlador {
    @Autowired
    HotelServicio hotelServicio;

    @GetMapping()
    public ArrayList<HotelEntidad> consultar(){
        return hotelServicio.consultar();
    }

    @PostMapping()
    public HotelEntidad registrar(@RequestBody HotelEntidad hotelEntidad){
        return hotelServicio.registrar(hotelEntidad);
    }
}
