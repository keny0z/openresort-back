package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class ConsultaDisponibilidadDTO {

    //falta agregar fechaLlegada, fechaSalida, adultos y ninos para poder consumir la reserva facil desde el front
    private DisponibilidadDTO consulta;
    private int idTipoHabitacion;
    private String nombre;
    private String descripcion;
    private int capacidadAdultos;
    private int capacidadNinos;
    private ArrayList<ConsultaDisponibilidadPlanDTO> planes;
}
