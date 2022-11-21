package co.edu.uco.openresort.excepcion;

public class ExcepcionTipoHabitacionNombreRepetido extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionTipoHabitacionNombreRepetido(String mensaje) {
        super(mensaje);
    }
}
