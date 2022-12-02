package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.PlanDTO;
import co.edu.uco.openresort.entidad.PlanEntidad;

import java.util.ArrayList;

public class PlanEnsamblador {

    public static PlanEntidad ensamblarEntidad(PlanDTO planDTO){
        PlanEntidad planEntidad = new PlanEntidad();

        planEntidad.setId(planDTO.getId());
        planEntidad.setNombre(planDTO.getNombre());
        planEntidad.setDescripcion(planDTO.getDescripcion());
        planEntidad.setPrecioAdulto(planDTO.getPrecioAdulto());
        planEntidad.setPrecioNino(planDTO.getPrecioNino());
        return planEntidad;
    }

    public static PlanDTO ensamblarDTO(PlanEntidad planEntidad){
        PlanDTO planDTO = new PlanDTO();

        planDTO.setId(planEntidad.getId());
        planDTO.setNombre(planEntidad.getNombre());
        planDTO.setDescripcion(planEntidad.getDescripcion());
        planDTO.setPrecioAdulto(planEntidad.getPrecioAdulto());
        planDTO.setPrecioNino(planEntidad.getPrecioNino());

        return planDTO;
    }

    public static ArrayList<PlanDTO> ensamblarListaDTO(ArrayList<PlanEntidad> listaPlanEntidad){
        ArrayList<PlanDTO> listaPlanDTO = new ArrayList<>();

        for(PlanEntidad planEntidad : listaPlanEntidad){
            listaPlanDTO.add(ensamblarDTO(planEntidad));
        }

        return listaPlanDTO;
    }
}
