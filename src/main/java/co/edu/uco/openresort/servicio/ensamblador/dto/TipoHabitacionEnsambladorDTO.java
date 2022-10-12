package co.edu.uco.openresort.servicio.ensamblador.dto;


import co.edu.uco.openresort.dominio.TipoHabitacionDominio;
import co.edu.uco.openresort.dto.TipoHabitacionDTO;


import java.util.ArrayList;

public class TipoHabitacionEnsambladorDTO {
    public static TipoHabitacionDominio ensamblarDominio(TipoHabitacionDTO tipoHabitacionDTO){
        TipoHabitacionDominio tipoHabitacionDominio = new TipoHabitacionDominio();

        tipoHabitacionDominio.setId(tipoHabitacionDTO.getId());
        tipoHabitacionDominio.setNombre(tipoHabitacionDTO.getNombre());
        tipoHabitacionDominio.setDescripcion(tipoHabitacionDTO.getDescripcion());
        tipoHabitacionDominio.setCapacidadAdultos(tipoHabitacionDTO.getCapacidadAdultos());
        tipoHabitacionDominio.setCapacidadNinos(tipoHabitacionDTO.getCapacidadNinos());
        tipoHabitacionDominio.setPrecioDiaSol(tipoHabitacionDTO.getPrecioDiaSol());
        tipoHabitacionDominio.setPrecioNoche(tipoHabitacionDTO.getPrecioNoche());


        return tipoHabitacionDominio;
    }

    public static TipoHabitacionDTO ensamblarDTO(TipoHabitacionDominio tipoHabitacionDominio){
        TipoHabitacionDTO tipoHabitacionDto = new TipoHabitacionDTO();

        tipoHabitacionDto.setId(tipoHabitacionDominio.getId());
        tipoHabitacionDto.setNombre(tipoHabitacionDominio.getNombre());
        tipoHabitacionDto.setDescripcion(tipoHabitacionDominio.getDescripcion());
        tipoHabitacionDto.setCapacidadAdultos(tipoHabitacionDominio.getCapacidadAdultos());
        tipoHabitacionDto.setCapacidadNinos(tipoHabitacionDominio.getCapacidadNinos());
        tipoHabitacionDto.setPrecioDiaSol(tipoHabitacionDominio.getPrecioDiaSol());
        tipoHabitacionDto.setPrecioNoche(tipoHabitacionDominio.getPrecioNoche());

        return tipoHabitacionDto;
    }

    public static ArrayList<TipoHabitacionDTO> ensamblarListaDTO(ArrayList<TipoHabitacionDominio> listatipoHabitacionDominio){
        ArrayList<TipoHabitacionDTO> listatipoHabitacionDTO = new ArrayList<>();

        for(TipoHabitacionDominio tipoHabitacionDominio : listatipoHabitacionDominio){
            listatipoHabitacionDTO.add(ensamblarDTO(tipoHabitacionDominio));
        }

        return listatipoHabitacionDTO;
    }
}
