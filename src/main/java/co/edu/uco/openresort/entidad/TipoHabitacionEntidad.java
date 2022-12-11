package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    @Column(name="cap_adultos")
    private int capacidadAdultos;
    @Column(name="cap_ninos")
    private int capacidadNinos;
    @Column(name="pre_nch")
    private BigDecimal precioNoche;

}
