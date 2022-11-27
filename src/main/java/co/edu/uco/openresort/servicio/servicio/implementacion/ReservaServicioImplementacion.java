package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.repositorio.HabitacionRepositorio;
import co.edu.uco.openresort.repositorio.ReservaRepositorio;
import co.edu.uco.openresort.servicio.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Service
public class ReservaServicioImplementacion implements ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;


    @Override
    public ArrayList<HabitacionEntidad> consultarDisponibilidad(DisponibilidadDTO disponibilidadDTO) {

        //1. filtrar de todas las habitaciones del hotel seleccionado
        ArrayList<HabitacionEntidad> habitacionesHotel = buscarHabitacionesPorHotelId(disponibilidadDTO.getIdHotel());

        //2. filtrar las habitaciones que tienen capacidad suficiente
        ArrayList<HabitacionEntidad> habitacionesConCapacidad = buscarHabitacionesConCapacidad(disponibilidadDTO.getAdultos(),disponibilidadDTO.getNinos(),habitacionesHotel);

        //3. filtrar las habitaciones que tienen disponibilidad
        ArrayList<HabitacionEntidad> habitacionesDisponibles = buscarHabitacionesDisponibles(disponibilidadDTO.getFechaLLegada(),disponibilidadDTO.getFechaSalida(),habitacionesConCapacidad);

        for (HabitacionEntidad habitacionEntidad : habitacionesDisponibles) {
            System.out.println(habitacionEntidad.getId());
        }


        return habitacionesDisponibles;
    }

    private ArrayList<ReservaEntidad> buscarReservasPorHabitacionId(int id){
        return reservaRepositorio.findByHabitacion_Id(id);
    }

    private ArrayList<HabitacionEntidad> buscarHabitacionesPorHotelId(int id){
        return habitacionRepositorio.findByHotel_Id(id);
    }

    private ArrayList<HabitacionEntidad> buscarHabitacionesDisponibles(LocalDateTime fechaLlegada, LocalDateTime fechaSalida, ArrayList<HabitacionEntidad> habitacionesEntidad){
        ArrayList<HabitacionEntidad> habitacionesDisponibles = new ArrayList<>();
        for (HabitacionEntidad habitacionEntidad:habitacionesEntidad) {

            if(buscarReservasPorHabitacionId(habitacionEntidad.getId()).isEmpty()){ //si no tiene reservas entonces esta disponible
                habitacionesDisponibles.add(habitacionEntidad);
            }else if(estaDisponible(fechaLlegada,fechaSalida,habitacionEntidad)){ //si tiene reservas entonces hay que verificar que no este reservada para las fechas deseadas
                habitacionesDisponibles.add(habitacionEntidad);
            }
        }
        return habitacionesDisponibles;
    }

    private ArrayList<HabitacionEntidad> buscarHabitacionesConCapacidad(int adultos,int ninos,ArrayList<HabitacionEntidad> habitacionesEntidad){
        ArrayList<HabitacionEntidad> habitacionesConCapacidad = new ArrayList<>();

        for (HabitacionEntidad habitacionEntidad:habitacionesEntidad) {
            if(habitacionEntidad.getTipo().getCapacidadAdultos()>=adultos && habitacionEntidad.getTipo().getCapacidadNinos()>=ninos){
                habitacionesConCapacidad.add(habitacionEntidad);
            }
        }
        return habitacionesConCapacidad;
    }

    //https://stackoverflow.com/questions/325933/determine-whether-two-date-ranges-overlap?page=1&tab=scoredesc#tab-top
    private Boolean estaDisponible(LocalDateTime fechaLlegada, LocalDateTime fechaSalida, HabitacionEntidad habitacionEntidad){
        Boolean disponible = true;
        ArrayList<ReservaEntidad> reservasEntidad = buscarReservasPorHabitacionId(habitacionEntidad.getId());

        for (ReservaEntidad reservaEntidad:reservasEntidad) {
            if ( (reservaEntidad.getFechaLlegada().isBefore(fechaSalida) || reservaEntidad.getFechaLlegada().isEqual(fechaSalida)) && (reservaEntidad.getFechaSalida().isAfter(fechaLlegada) || reservaEntidad.getFechaSalida().isEqual(fechaLlegada)) ){
                disponible = false;
            }
        }

        return disponible;
    }


}
