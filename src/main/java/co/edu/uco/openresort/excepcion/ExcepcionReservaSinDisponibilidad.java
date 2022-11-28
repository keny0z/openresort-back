package co.edu.uco.openresort.excepcion;

public class ExcepcionReservaSinDisponibilidad extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionReservaSinDisponibilidad(String mensaje) {
        super(mensaje);
    }
}
