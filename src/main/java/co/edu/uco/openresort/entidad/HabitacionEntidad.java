package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "habitacion")
public class HabitacionEntidad {
    @Id
    private int id;
    @ManyToOne
    private HotelEntidad hotel;
    @ManyToOne
    private TipoHabitacionEntidad tipo;
    private String numero;
    private boolean disponible;
}
