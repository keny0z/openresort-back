package co.edu.uco.openresort.excepcion;

public class ExcepcionReservaNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionReservaNoExiste(String mensaje) {
        super(mensaje);
    }
}
