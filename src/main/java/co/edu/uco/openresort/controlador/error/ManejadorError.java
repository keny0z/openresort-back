package co.edu.uco.openresort.controlador.error;

import co.edu.uco.openresort.excepcion.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;


@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorError.class);

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {

        CODIGOS_ESTADO.put(ExcepcionHotelNoExiste.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionTipoHabitacionNoExiste.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionHotelNombreRepetido.class.getSimpleName(), HttpStatus.CONFLICT.value());
        CODIGOS_ESTADO.put(ExcepcionTipoHabitacionNombreRepetido.class.getSimpleName(), HttpStatus.CONFLICT.value());
        CODIGOS_ESTADO.put(ExcepcionHabitacionNumeroRepetido.class.getSimpleName(), HttpStatus.CONFLICT.value());
        //-------------------------------
        //el codigo de estado siempre debe ser OK (200) para poder que hardware_api retorne los mensajes de respuesta
        //CODIGOS_ESTADO.put(ExcepcionHabitacionNoExiste.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionHabitacionNoExiste.class.getSimpleName(), HttpStatus.OK.value());
        //-------------------------------
        CODIGOS_ESTADO.put(ExcepcionDarAccesoFallido.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);

            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

            LOGGER_ERROR.error(excepcionNombre, exception);
        }

        return resultado;
    }
}
