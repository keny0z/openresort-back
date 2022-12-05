package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.HuespedEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedRepositorio extends CrudRepository<HuespedEntidad,Integer> {
}
