package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class TipoHabitacionDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private int capacidadAdultos;
    private int capacidadNinos;
    private BigDecimal precioDiaSol;
    private BigDecimal precioNoche;
}
