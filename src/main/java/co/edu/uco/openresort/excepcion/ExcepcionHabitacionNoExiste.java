package co.edu.uco.openresort.excepcion;

public class ExcepcionHabitacionNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionHabitacionNoExiste(String mensaje) {
        super(mensaje);
    }
}
