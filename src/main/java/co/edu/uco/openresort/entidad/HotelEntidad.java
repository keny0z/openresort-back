package co.edu.uco.openresort.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class HotelEntidad {
    @Id
    private int id;
    private String nombre;
}
