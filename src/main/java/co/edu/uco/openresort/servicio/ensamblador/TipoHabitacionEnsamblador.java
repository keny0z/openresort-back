package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.TipoHabitacionDTO;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;

import java.util.ArrayList;

public class TipoHabitacionEnsamblador {

    public static TipoHabitacionEntidad ensamblarEntidad(TipoHabitacionDTO tipoHabitacionDTO){
        TipoHabitacionEntidad tipoHabitacionEntidad = new TipoHabitacionEntidad();

        tipoHabitacionEntidad.setId(tipoHabitacionDTO.getId());
        tipoHabitacionEntidad.setNombre(tipoHabitacionDTO.getNombre());
        tipoHabitacionEntidad.setDescripcion(tipoHabitacionDTO.getDescripcion());
        tipoHabitacionEntidad.setCapacidadAdultos(tipoHabitacionDTO.getCapacidadAdultos());
        tipoHabitacionEntidad.setCapacidadNinos(tipoHabitacionDTO.getCapacidadNinos());
        tipoHabitacionEntidad.setPrecioNoche(tipoHabitacionDTO.getPrecioNoche());

        return tipoHabitacionEntidad;
    }
    public static TipoHabitacionDTO ensamblarDTO(TipoHabitacionEntidad tipoHabitacionEntidad){
        TipoHabitacionDTO tipoHabitacionDto = new TipoHabitacionDTO();

        tipoHabitacionDto.setId(tipoHabitacionEntidad.getId());
        tipoHabitacionDto.setNombre(tipoHabitacionEntidad.getNombre());
        tipoHabitacionDto.setDescripcion(tipoHabitacionEntidad.getDescripcion());
        tipoHabitacionDto.setCapacidadAdultos(tipoHabitacionEntidad.getCapacidadAdultos());
        tipoHabitacionDto.setCapacidadNinos(tipoHabitacionEntidad.getCapacidadNinos());
        tipoHabitacionDto.setPrecioNoche(tipoHabitacionEntidad.getPrecioNoche());

        return tipoHabitacionDto;
    }

    public static ArrayList<TipoHabitacionDTO> ensamblarListaDTO(ArrayList<TipoHabitacionEntidad> listaTipoHabitacionEntidad){
        ArrayList<TipoHabitacionDTO> listaTipoHabitacionDTO = new ArrayList<>();

        for(TipoHabitacionEntidad tipoHabitacionEntidad : listaTipoHabitacionEntidad){
            listaTipoHabitacionDTO.add(ensamblarDTO(tipoHabitacionEntidad));
        }

        return listaTipoHabitacionDTO;
    }
}
