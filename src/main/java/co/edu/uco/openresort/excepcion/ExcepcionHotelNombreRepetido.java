package co.edu.uco.openresort.excepcion;

public class ExcepcionHotelNombreRepetido extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionHotelNombreRepetido(String mensaje) {
        super(mensaje);
    }
}
