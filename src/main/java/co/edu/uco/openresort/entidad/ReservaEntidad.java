package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class ReservaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private HabitacionEntidad habitacion;
    @ManyToOne
    private PlanEntidad plan;
    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaRealizacion;
    private int adultos;
    private int ninos;
    private String numeroHabitacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pais;
    private String celular;
    private String identificacion;
}
