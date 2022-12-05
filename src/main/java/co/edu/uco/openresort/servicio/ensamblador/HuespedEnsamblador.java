package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.HuespedDTO;
import co.edu.uco.openresort.entidad.HuespedEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TagEntidad;

import java.util.ArrayList;

public class HuespedEnsamblador {

    public static HuespedEntidad ensamblarEntidad(HuespedDTO huespedDTO){


        ReservaEntidad reservaEntidad = new ReservaEntidad();
        reservaEntidad.setId(huespedDTO.getIdReserva());
        reservaEntidad.setCodigo(huespedDTO.getCodigoReserva());

        TagEntidad tagEntidad = new TagEntidad();
        tagEntidad.setIdentificador(huespedDTO.getIdentificadorTag());


        HuespedEntidad huespedEntidad = new HuespedEntidad();
        huespedEntidad.setId(huespedDTO.getId());
        huespedEntidad.setReserva(reservaEntidad);
        huespedEntidad.setTag(tagEntidad);
        huespedEntidad.setNombres(huespedDTO.getNombres());
        huespedEntidad.setApellidos(huespedDTO.getApellidos());
        huespedEntidad.setIdentificacion(huespedDTO.getIdentificacion());
        huespedEntidad.setFechaNacimiento(huespedDTO.getFechaNacimiento());
        huespedEntidad.setPais(huespedDTO.getPais());

        return huespedEntidad;
    }

    public static HuespedDTO ensamblarDTO(HuespedEntidad huespedEntidad){

        HuespedDTO huespedDTO = new HuespedDTO();

        huespedDTO.setId(huespedEntidad.getId());
        huespedDTO.setIdReserva(huespedEntidad.getReserva().getId());
        huespedDTO.setCodigoReserva(huespedEntidad.getReserva().getCodigo());
        huespedDTO.setIdentificadorTag(huespedEntidad.getTag().getIdentificador());
        huespedDTO.setNombres(huespedEntidad.getNombres());
        huespedDTO.setApellidos(huespedEntidad.getApellidos());
        huespedDTO.setIdentificacion(huespedEntidad.getIdentificacion());
        huespedDTO.setFechaNacimiento(huespedEntidad.getFechaNacimiento());
        huespedDTO.setPais(huespedEntidad.getPais());

        return  huespedDTO;
    }

    public static ArrayList<HuespedDTO> ensamblarListaDTO(ArrayList<HuespedEntidad> listaHuespedEntidad){
        ArrayList<HuespedDTO> listaHuespedDTO = new ArrayList<>();

        for(HuespedEntidad huespedEntidad : listaHuespedEntidad){
            listaHuespedDTO.add(ensamblarDTO(huespedEntidad));
        }

        return listaHuespedDTO;
    }
}
