package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.HabitacionEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepositorio extends CrudRepository<HabitacionEntidad,Integer> {

}
