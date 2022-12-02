package co.edu.uco.openresort.excepcion;

public class ExcepcionPlanNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionPlanNoExiste(String mensaje) {
        super(mensaje);
    }
}
