package co.edu.uco.openresort.dominio;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TipoHabitacionDominio {

    private int id;
    private String nombre;
    private String descripcion;
    private int capacidadAdultos;
    private int capacidadNinos;
    private BigDecimal precioDiaSol;
    private BigDecimal precioNoche;
}
