package co.edu.uco.openresort.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HotelDTO {
    private int id;
    private String nombre;
    private BigDecimal precioNoche;
}
