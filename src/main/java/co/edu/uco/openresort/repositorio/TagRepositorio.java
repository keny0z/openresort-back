package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.TagEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TagRepositorio extends CrudRepository<TagEntidad, Long> {
    ArrayList<TagEntidad> findByHabitacionesConAcceso_Id(int id);
}
