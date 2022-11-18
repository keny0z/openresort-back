package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.HabitacionDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.HotelEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public class HabitacionEnsamblador {

    public static HabitacionEntidad ensamblarEntidad(HabitacionDTO habitacionDTO){
        HabitacionEntidad habitacionEntidad = new HabitacionEntidad();
        HotelEntidad hotelEntidad = new HotelEntidad();
        TipoHabitacionEntidad tipoHabitacionEntidad = new TipoHabitacionEntidad();
        habitacionEntidad.setHotel(hotelEntidad);
        habitacionEntidad.setTipo(tipoHabitacionEntidad);

        habitacionEntidad.setId(habitacionDTO.getId());
        habitacionEntidad.getHotel().setId(habitacionDTO.getIdHotel());
        habitacionEntidad.getTipo().setId(habitacionDTO.getIdTipo());
        habitacionEntidad.setNumero(habitacionDTO.getNumero());
        habitacionEntidad.setDisponible(habitacionDTO.isDisponible());

        return habitacionEntidad;
    }
    public static HabitacionDTO ensamblarDTO(HabitacionEntidad habitacionEntidad){
        HabitacionDTO habitacionDto = new HabitacionDTO();

        habitacionDto.setId(habitacionEntidad.getId());
        habitacionDto.setIdHotel(habitacionEntidad.getHotel().getId());
        habitacionDto.setIdTipo(habitacionEntidad.getTipo().getId());
        habitacionDto.setNumero(habitacionEntidad.getNumero());
        habitacionDto.setDisponible(habitacionEntidad.isDisponible());

        return habitacionDto;
    }

    public static ArrayList<HabitacionDTO> ensamblarListaDTO(ArrayList<HabitacionEntidad> listaHabitacionEntidad){
        ArrayList<HabitacionDTO> listaHabitacionDTO = new ArrayList<>();

        for(HabitacionEntidad habitacionEntidad : listaHabitacionEntidad){
            listaHabitacionDTO.add(ensamblarDTO(habitacionEntidad));
        }

        return listaHabitacionDTO;
    }
}
