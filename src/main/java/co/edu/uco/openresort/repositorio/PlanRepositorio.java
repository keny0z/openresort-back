package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.PlanEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepositorio extends CrudRepository<PlanEntidad,Integer> {
}
