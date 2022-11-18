package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dto.HotelDTO;
import co.edu.uco.openresort.servicio.ensamblador.HotelEnsamblador;
import co.edu.uco.openresort.servicio.fachada.HotelFachada;
import co.edu.uco.openresort.servicio.servicio.HotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class HotelFachadaImplementacion implements HotelFachada {

    @Autowired
    private HotelServicio hotelServicio;


    @Override
    public ArrayList<HotelDTO> consultar() {
        return HotelEnsamblador.ensamblarListaDTO(hotelServicio.consultar());
    }

    @Override
    public HotelDTO registrar(HotelDTO hotelDTO) {
        return HotelEnsamblador.ensamblarDTO(hotelServicio.registrar(HotelEnsamblador.ensamblarEntidad(hotelDTO)));
    }

    @Override
    public void eliminar(int id) {
        hotelServicio.eliminar(id);
    }
}
