package co.edu.uco.openresort.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitacionDominio {

    private int id;
    private HotelDominio hotel;
    private TipoHabitacionDominio tipo;
    private String numero;
    private boolean disponible;
}
