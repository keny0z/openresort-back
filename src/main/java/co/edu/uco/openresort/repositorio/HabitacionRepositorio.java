package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.HabitacionEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HabitacionRepositorio extends CrudRepository<HabitacionEntidad,Integer> {
    ArrayList<HabitacionEntidad> findByTagsConAcceso_Identificador(long identificador);

    boolean existsByNumero(String numero);
    ArrayList<HabitacionEntidad> findByHotel_Id(int id);
}
