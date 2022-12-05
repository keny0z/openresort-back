package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HuespedDTO {
    private int id;
    private int idReserva;
    private String codigoReserva;
    private long identificadorTag;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private LocalDate fechaNacimiento;
    private String pais;

}
