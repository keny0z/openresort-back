package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "titular")
public class TitularEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private ReservaEntidad reserva;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pais;
    private String celular;
    private String identificacion;

}
