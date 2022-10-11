package co.edu.uco.openresort.servicio.ensamblador.dto;

import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.dto.HotelDTO;

import java.util.ArrayList;

public class HotelEnsambladorDTO {

    public static HotelDominio ensamblarDominio(HotelDTO hotelDTO){
        HotelDominio hotelDominio = new HotelDominio();
        hotelDominio.setNombre(hotelDTO.getNombre());
        return hotelDominio;
    }

    public static HotelDTO ensamblarDTO(HotelDominio hotelDominio){
        HotelDTO hotelDto = new HotelDTO();
        hotelDto.setNombre(hotelDominio.getNombre());
        return hotelDto;
    }

    public static ArrayList<HotelDTO> ensamblarListaDTO(ArrayList<HotelDominio> listaHotelDominio){
        ArrayList<HotelDTO> listaHotelDTO = new ArrayList<>();

        for(HotelDominio hotelDominio : listaHotelDominio){
            listaHotelDTO.add(ensamblarDTO(hotelDominio));
        }

        return listaHotelDTO;
    }
}
