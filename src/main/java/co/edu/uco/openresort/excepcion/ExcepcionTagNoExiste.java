package co.edu.uco.openresort.excepcion;

public class ExcepcionTagNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionTagNoExiste(String mensaje) {
        super(mensaje);
    }
}
