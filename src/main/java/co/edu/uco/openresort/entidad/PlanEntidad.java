package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "plan")
public class PlanEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioAdulto;
    private BigDecimal precioNino;
}
