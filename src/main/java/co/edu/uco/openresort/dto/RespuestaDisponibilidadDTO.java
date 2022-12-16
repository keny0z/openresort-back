package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class RespuestaDisponibilidadDTO {

    //falta agregar fechaLlegada, fechaSalida, adultos y ninos para poder consumir la reserva facil desde el front
    private ConsultaDisponibilidadDTO consulta;
    private int idTipoHabitacion;
    private String nombre;
    private String descripcion;
    private int capacidadAdultos;
    private int capacidadNinos;
    private ArrayList<RespuestaDisponibilidadPlanDTO> planes;
}
