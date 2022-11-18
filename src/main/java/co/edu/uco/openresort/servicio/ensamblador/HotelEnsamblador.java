package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.HotelDTO;
import co.edu.uco.openresort.entidad.HotelEntidad;

import java.util.ArrayList;

public class HotelEnsamblador {

    public static HotelEntidad ensamblarEntidad(HotelDTO hotelDTO){
        HotelEntidad hotelEntidad = new HotelEntidad();

        hotelEntidad.setId(hotelDTO.getId());
        hotelEntidad.setNombre(hotelDTO.getNombre());

        return hotelEntidad;
    }
    public static HotelDTO ensamblarDTO(HotelEntidad hotelEntidad){
        HotelDTO hotelDto = new HotelDTO();

        hotelDto.setId(hotelEntidad.getId());
        hotelDto.setNombre(hotelEntidad.getNombre());

        return hotelDto;
    }

    public static ArrayList<HotelDTO> ensamblarListaDTO(ArrayList<HotelEntidad> listaHotelEntidad){
        ArrayList<HotelDTO> listaHotelDTO = new ArrayList<>();

        for(HotelEntidad hotelEntidad : listaHotelEntidad){
            listaHotelDTO.add(ensamblarDTO(hotelEntidad));
        }

        return listaHotelDTO;
    }
}
