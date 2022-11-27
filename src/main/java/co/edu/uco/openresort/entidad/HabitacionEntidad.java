package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private boolean disponible; //para indicar si tiene o no tiene una reserva en el momento

    @ManyToMany
    @JoinTable(name="habitacion_tags_con_acceso",
            joinColumns=@JoinColumn(name="habitacion_id"),
            inverseJoinColumns=@JoinColumn(name="tag_con_acceso_id"))
    private Set<TagEntidad> tagsConAcceso;
}
