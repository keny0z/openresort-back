package co.edu.uco.openresort.excepcion;

public class ExcepcionTipoHabitacionNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionTipoHabitacionNoExiste(String mensaje) {
        super(mensaje);
    }
}
