package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RespuestaDisponibilidadPlanDTO {
    private int idPlan;
    private String nombre;
    private String descripcion;
    private BigDecimal precioTotal;
}
