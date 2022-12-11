package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.entidad.HuespedEntidad;
import co.edu.uco.openresort.excepcion.ExcepcionReservaNoExiste;
import co.edu.uco.openresort.excepcion.ExcepcionTagNoExiste;
import co.edu.uco.openresort.repositorio.HuespedRepositorio;
import co.edu.uco.openresort.repositorio.ReservaRepositorio;
import co.edu.uco.openresort.repositorio.TagRepositorio;
import co.edu.uco.openresort.servicio.servicio.HuespedServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HuespedServicioImplementacion implements HuespedServicio {

    private static final String MENSAJE_RESERVA_CODIGO_NO_EXISTE = "No existe ningina reserva asociada al código ingresado";
    private static final String MENSAJE_TAG_NO_EXISTE = "El tag ingresado no existe";



    @Autowired
    private HuespedRepositorio huespedRepositorio;
    @Autowired
    private ReservaRepositorio reservaRepositorio;
    @Autowired
    private TagRepositorio tagRepositorio;


    @Override
    public ArrayList<HuespedEntidad> consultar() {
        return (ArrayList<HuespedEntidad>) huespedRepositorio.findAll();
    }

    @Override
    public HuespedEntidad registrar(HuespedEntidad huespedEntidad) {
        garantizarReservaExistePorCodigo(huespedEntidad.getReserva().getCodigo());
        garantizarTagExiste(huespedEntidad.getTag().getIdentificador());

        huespedEntidad.setReserva(reservaRepositorio.findByCodigo(huespedEntidad.getReserva().getCodigo()));

        return huespedRepositorio.save(huespedEntidad);
    }

    @Override
    public void eliminar(int id) {
        huespedRepositorio.deleteById(id);
    }

    private void garantizarReservaExistePorCodigo(String codigo){
        if(reservaRepositorio.existsByCodigo(codigo)==false){
            throw new ExcepcionReservaNoExiste(MENSAJE_RESERVA_CODIGO_NO_EXISTE);
        }
    }

    private void garantizarTagExiste(long identificador){
        if (tagRepositorio.existsById(identificador)==false){
            throw new ExcepcionTagNoExiste(MENSAJE_TAG_NO_EXISTE);
        }
    }


}