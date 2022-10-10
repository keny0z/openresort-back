package co.edu.uco.openresort.repositorio;

import co.edu.uco.openresort.entidad.HotelEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepositorio extends CrudRepository<HotelEntidad,Integer> {
}
