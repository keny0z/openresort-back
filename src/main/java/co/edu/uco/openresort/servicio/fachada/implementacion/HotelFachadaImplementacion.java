package co.edu.uco.openresort.servicio.fachada.implementacion;

import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.dto.HotelDTO;
import co.edu.uco.openresort.servicio.ensamblador.dto.HotelEnsambladorDTO;
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
        return HotelEnsambladorDTO.ensamblarListaDTO(hotelServicio.consultar()) ;
    }

    @Override
    public HotelDTO registrar(HotelDTO hotelDTO) {
        return HotelEnsambladorDTO.ensamblarDTO(hotelServicio.registrar(HotelEnsambladorDTO.ensamblarDominio(hotelDTO)));
    }

    @Override
    public HotelDTO editar(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public void eliminar(HotelDTO hotelDTO) {

    }
}
