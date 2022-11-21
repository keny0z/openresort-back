package co.edu.uco.openresort.excepcion;

public class ExcepcionDarAccesoFallido extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionDarAccesoFallido(String mensaje) {
        super(mensaje);
    }
}
