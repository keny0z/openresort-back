package co.edu.uco.openresort.excepcion;

public class ExcepcionTagNoDisponible extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionTagNoDisponible(String mensaje) {
        super(mensaje);
    }
}
