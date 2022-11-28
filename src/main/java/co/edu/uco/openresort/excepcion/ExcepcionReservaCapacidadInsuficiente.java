package co.edu.uco.openresort.excepcion;

public class ExcepcionReservaCapacidadInsuficiente extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionReservaCapacidadInsuficiente(String mensaje) {
        super(mensaje);
    }
}
