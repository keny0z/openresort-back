package co.edu.uco.openresort.excepcion;

public class ExcepcionValorObligatorio extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionValorObligatorio(String mensaje) {
        super(mensaje);
    }
}
