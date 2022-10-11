package co.edu.uco.openresort.servicio.fachada;

import co.edu.uco.openresort.dto.HotelDTO;

import java.util.ArrayList;

public interface HotelFachada {

    ArrayList<HotelDTO> consultar();
    HotelDTO registrar(HotelDTO hotelDTO);
    HotelDTO editar(HotelDTO hotelDTO);
    void eliminar(int id);

}
