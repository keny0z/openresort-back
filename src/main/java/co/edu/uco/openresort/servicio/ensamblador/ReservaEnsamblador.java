package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.ReservaDTO;
import co.edu.uco.openresort.entidad.ReservaEntidad;

import java.util.ArrayList;

public class ReservaEnsamblador {

    //ReservaEntidad --> ReservaDTO
    public static ReservaDTO ensamblarDTO(ReservaEntidad reservaEntidad){

        ReservaDTO reservaDTO = new ReservaDTO();

        reservaDTO.setId(reservaEntidad.getId());
        reservaDTO.setIdHotel(reservaEntidad.getHabitacion().getHotel().getId());
        reservaDTO.setIdTipoHabitacion(reservaEntidad.getHabitacion().getTipo().getId());
        reservaDTO.setIdPlan(reservaEntidad.getPlan().getId());
        reservaDTO.setFechaLlegada(reservaEntidad.getFechaLlegada());
        reservaDTO.setFechaSalida(reservaEntidad.getFechaSalida());
        reservaDTO.setFechaRealizacion(reservaEntidad.getFechaRealizacion());
        reservaDTO.setAdultos(reservaEntidad.getAdultos());
        reservaDTO.setNinos(reservaEntidad.getNinos());
        reservaDTO.setNumeroHabitacion(reservaEntidad.getNumeroHabitacion());
        reservaDTO.setNombres(reservaEntidad.getNombres());
        reservaDTO.setApellidos(reservaEntidad.getApellidos());
        reservaDTO.setCorreo(reservaEntidad.getCorreo());
        reservaDTO.setPais(reservaEntidad.getPais());
        reservaDTO.setCelular(reservaEntidad.getCelular());
        reservaDTO.setIdentificacion(reservaEntidad.getIdentificacion());
        reservaDTO.setFechaNacimiento(reservaEntidad.getFechaNacimiento());
        reservaDTO.setCodigo(reservaEntidad.getCodigo());

        return reservaDTO;
    }

    public static ArrayList<ReservaDTO> ensamblarListaDTO(ArrayList<ReservaEntidad> listaReservaEntidad){
        ArrayList<ReservaDTO> listaReservaDTO = new ArrayList<>();

        for(ReservaEntidad reservaEntidad : listaReservaEntidad){
            listaReservaDTO.add(ensamblarDTO(reservaEntidad));
        }

        return listaReservaDTO;
    }
}
