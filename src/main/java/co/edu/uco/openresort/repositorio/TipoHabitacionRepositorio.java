package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepositorio extends CrudRepository<TipoHabitacionEntidad,Integer> {
    boolean existsByNombre(String nombre);
}
