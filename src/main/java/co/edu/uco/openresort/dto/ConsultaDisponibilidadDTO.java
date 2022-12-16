package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaDisponibilidadDTO {
    private int idHotel;
    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaSalida;
    private int adultos;
    private int ninos;

}
