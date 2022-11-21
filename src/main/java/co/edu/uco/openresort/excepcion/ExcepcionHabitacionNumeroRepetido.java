package co.edu.uco.openresort.excepcion;

public class ExcepcionHabitacionNumeroRepetido extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionHabitacionNumeroRepetido(String mensaje) {
        super(mensaje);
    }
}
