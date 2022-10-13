package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitacionDTO {

    private int id;
    private int idHotel;
    private int idTipo;
    private String numero;
    private boolean disponible;
}
