package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "habitacion")
public class HabitacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private HotelEntidad hotel;
    @ManyToOne
    private TipoHabitacionEntidad tipo;
    private String numero;
    private boolean disponible;
}
