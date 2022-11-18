package co.edu.uco.openresort.servicio.ensamblador;

import co.edu.uco.openresort.dto.TagDTO;
import co.edu.uco.openresort.entidad.TagEntidad;

import java.util.ArrayList;

public class TagEnsamblador {

    public static TagEntidad ensamblarEntidad(TagDTO tagDTO){
        TagEntidad tagEntidad = new TagEntidad();

        tagEntidad.setIdentificador(tagDTO.getIdentificador());

        return tagEntidad;
    }
    public static TagDTO ensamblarDTO(TagEntidad tagEntidad){
        TagDTO tagDto = new TagDTO();

        tagDto.setIdentificador(tagEntidad.getIdentificador());

        return tagDto;
    }

    public static ArrayList<TagDTO> ensamblarListaDTO(ArrayList<TagEntidad> listaTagEntidad){
        ArrayList<TagDTO> listaTagDto = new ArrayList<>();

        for(TagEntidad tagEntidad : listaTagEntidad){
            listaTagDto.add(ensamblarDTO(tagEntidad));
        }
        return listaTagDto;
    }
}
