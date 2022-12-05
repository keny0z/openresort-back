package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class ReservaDTO {

    private int id;
    private int idHotel;
    private int idTipoHabitacion;
    private int idPlan;
    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaRealizacion;
    private int adultos;
    private int ninos;
    private String numeroHabitacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pais;
    private String celular;
    private String identificacion;
    private String codigo;

}
