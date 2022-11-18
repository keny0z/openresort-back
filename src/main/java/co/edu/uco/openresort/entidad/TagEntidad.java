package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class TagEntidad {

    @Id
    private long identificador;

    @ManyToMany
    @JoinTable(name="habitacion_tags_con_acceso",
            joinColumns=@JoinColumn(name="tag_con_acceso_id"),
            inverseJoinColumns=@JoinColumn(name="habitacion_id"))
    private Set<HabitacionEntidad> habitacionesConAcceso;
}
