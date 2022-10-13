package co.edu.uco.openresort.servicio.ensamblador.dto;


import co.edu.uco.openresort.dominio.HabitacionDominio;
import co.edu.uco.openresort.dominio.HotelDominio;
import co.edu.uco.openresort.dominio.TipoHabitacionDominio;
import co.edu.uco.openresort.dto.HabitacionDTO;

import java.util.ArrayList;

public class HabitacionEnsambladorDTO {

    public static HabitacionDominio ensamblarDominio(HabitacionDTO habitacionDTO){
        HabitacionDominio habitacionDominio = new HabitacionDominio();
        HotelDominio hotelDominio = new HotelDominio();
        TipoHabitacionDominio tipoHabitacionDominio = new TipoHabitacionDominio();
        habitacionDominio.setHotel(hotelDominio);
        habitacionDominio.setTipo(tipoHabitacionDominio);

        habitacionDominio.setId(habitacionDTO.getId());
        habitacionDominio.getHotel().setId(habitacionDTO.getIdHotel());
        habitacionDominio.getTipo().setId(habitacionDTO.getIdTipo());
        habitacionDominio.setNumero(habitacionDTO.getNumero());
        habitacionDominio.setDisponible(habitacionDTO.isDisponible());

        return habitacionDominio;
    }

    public static HabitacionDTO ensamblarDTO(HabitacionDominio habitacionDominio){
        HabitacionDTO habitacionDto = new HabitacionDTO();

        habitacionDto.setId(habitacionDominio.getId());
        habitacionDto.setIdHotel(habitacionDominio.getHotel().getId());
        habitacionDto.setIdTipo(habitacionDominio.getTipo().getId());
        habitacionDto.setNumero(habitacionDominio.getNumero());
        habitacionDto.setDisponible(habitacionDominio.isDisponible());

        return habitacionDto;
    }

    public static ArrayList<HabitacionDTO> ensamblarListaDTO(ArrayList<HabitacionDominio> listaHabitacionDominio){
        ArrayList<HabitacionDTO> listaHabitacionDTO = new ArrayList<>();

        for(HabitacionDominio habitacionDominio : listaHabitacionDominio){
            listaHabitacionDTO.add(ensamblarDTO(habitacionDominio));
        }

        return listaHabitacionDTO;
    }
}
