package co.edu.uco.openresort.excepcion;

public class ExcepcionHotelNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionHotelNoExiste(String mensaje) {
        super(mensaje);
    }
}
