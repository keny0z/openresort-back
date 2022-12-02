package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlanDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioAdulto;
    private BigDecimal precioNino;
}
