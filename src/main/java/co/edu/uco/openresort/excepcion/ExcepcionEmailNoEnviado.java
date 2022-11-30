package co.edu.uco.openresort.excepcion;

public class ExcepcionEmailNoEnviado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionEmailNoEnviado(String mensaje) {
        super(mensaje);
    }
}
