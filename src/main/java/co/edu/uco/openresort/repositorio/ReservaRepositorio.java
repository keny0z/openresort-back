package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.ReservaEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ReservaRepositorio extends CrudRepository<ReservaEntidad,Integer> {

    ArrayList<ReservaEntidad> findByHabitacion_Id(int id);
    boolean existsByCodigo(String codigo);
    ReservaEntidad findByCodigo(String codigo);
}
