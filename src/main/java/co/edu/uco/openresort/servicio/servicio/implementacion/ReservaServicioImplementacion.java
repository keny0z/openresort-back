package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.dto.DisponibilidadDTO;
import co.edu.uco.openresort.dto.ReservaDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.excepcion.*;
import co.edu.uco.openresort.repositorio.HabitacionRepositorio;
import co.edu.uco.openresort.repositorio.HotelRepositorio;
import co.edu.uco.openresort.repositorio.ReservaRepositorio;
import co.edu.uco.openresort.repositorio.TipoHabitacionRepositorio;
import co.edu.uco.openresort.servicio.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ReservaServicioImplementacion implements ReservaServicio {

    private static final String MENSAJE_HOTEL_NO_EXISTE = "El hotel no existe";
    private static final String MENSAJE_TIPO_HABITACION_NO_EXISTE = "El tipo de habitacion no existe";
    private static final String MENSAJE_HOTEL_SIN_HABITACIONES = "El hotel no tiene habitaciones registradas";
    private static final String MENSAJE_RESERVA_CAPACIDAD_INSUFICIENTE = "No existen habitaciones con capacidad suficiente";
    private static final String MENSAJE_RESERVA_HABITACIONES_NO_DISPONIBLES = "No hay disponibilidad de habitaciones para las fechas seleccionadas";
    private static final String MENSAJE_TIPO_HABITACION_NO_DISPONIBLE_EN_HOTEL = "El tipo de habitacion seleccionado no está disponible en el hotel seleccionado";

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;
    @Autowired
    private HotelRepositorio hotelRepositorio;
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;


    @Override
    public ArrayList<HabitacionEntidad> consultarDisponibilidadHabitaciones(DisponibilidadDTO disponibilidadDTO) {

        garantizarHotelExiste(disponibilidadDTO.getIdHotel());


        //1. filtrar de todas las habitaciones del hotel seleccionado
        ArrayList<HabitacionEntidad> habitacionesHotel = buscarHabitacionesPorHotelId(disponibilidadDTO.getIdHotel());

        if(habitacionesHotel.size()==0){
            throw new ExcepcionHabitacionNoExiste(MENSAJE_HOTEL_SIN_HABITACIONES);
        }

        //2. filtrar las habitaciones que tienen capacidad suficiente
        ArrayList<HabitacionEntidad> habitacionesConCapacidad = buscarHabitacionesConCapacidad(disponibilidadDTO.getAdultos(),disponibilidadDTO.getNinos(),habitacionesHotel);

        if(habitacionesConCapacidad.size()==0){
            throw new ExcepcionReservaCapacidadInsuficiente(MENSAJE_RESERVA_CAPACIDAD_INSUFICIENTE);
        }

        //3. filtrar las habitaciones que tienen disponibilidad
        ArrayList<HabitacionEntidad> habitacionesDisponibles = buscarHabitacionesDisponibles(disponibilidadDTO.getFechaLLegada(),disponibilidadDTO.getFechaSalida(),habitacionesConCapacidad);

        if(habitacionesDisponibles.size()==0){
            throw new ExcepcionReservaSinDisponibilidad(MENSAJE_RESERVA_HABITACIONES_NO_DISPONIBLES);
        }

        return habitacionesDisponibles;
    }

    @Override
    public ArrayList<TipoHabitacionEntidad> consultarDisponibilidadTipoHabitacion(DisponibilidadDTO disponibilidadDTO) {
        ArrayList<HabitacionEntidad> habitacionesDisponibles = consultarDisponibilidadHabitaciones(disponibilidadDTO);
        ArrayList<TipoHabitacionEntidad> tipoHabitaciones = new ArrayList<>();
        for (HabitacionEntidad habitacionEntidad:habitacionesDisponibles) {
            if(!tipoHabitaciones.contains(habitacionEntidad.getTipo())){
                tipoHabitaciones.add(habitacionEntidad.getTipo());
            }

        }
        return tipoHabitaciones;
    }

    @Override
    public ReservaEntidad reservar(ReservaDTO reservaDTO) {

        garantizarHotelExiste(reservaDTO.getIdHotel());
        garantizarTipoHabitacionExiste(reservaDTO.getIdTipoHabitacion());

        DisponibilidadDTO disponibilidadDTO = new DisponibilidadDTO();

        disponibilidadDTO.setIdHotel(reservaDTO.getIdHotel());
        disponibilidadDTO.setFechaLLegada(reservaDTO.getFechaLlegada());
        disponibilidadDTO.setFechaSalida(reservaDTO.getFechaSalida());
        disponibilidadDTO.setAdultos(reservaDTO.getAdultos());
        disponibilidadDTO.setNinos(reservaDTO.getNinos());

        // 1. buscar disponibilidad de habitaciones sin tener en cuenta el tipo de habitacion
        ArrayList<HabitacionEntidad> habitacionesDisponibles = consultarDisponibilidadHabitaciones(disponibilidadDTO);

        // 2. filtrar habitaciones por tipo
        ArrayList<HabitacionEntidad> habitacionesDisponiblesTipo = buscarHabitacionesPorTipo(reservaDTO.getIdTipoHabitacion(),habitacionesDisponibles);

        if(habitacionesDisponiblesTipo.size()==0){
            throw new ExcepcionHabitacionNoExiste(MENSAJE_TIPO_HABITACION_NO_DISPONIBLE_EN_HOTEL);
        }


        ReservaEntidad reservaEntidad = new ReservaEntidad();

        reservaEntidad.setHabitacion(habitacionesDisponiblesTipo.get(0));
        reservaEntidad.setNumeroHabitacion(reservaEntidad.getHabitacion().getNumero());

        reservaEntidad.setAdultos(reservaDTO.getAdultos());
        reservaEntidad.setNinos(reservaDTO.getNinos());
        reservaEntidad.setFechaLlegada(reservaDTO.getFechaLlegada());
        reservaEntidad.setFechaSalida(reservaDTO.getFechaSalida());


        reservaEntidad.setNombres(reservaDTO.getNombres());
        reservaEntidad.setApellidos(reservaDTO.getApellidos());
        reservaEntidad.setCorreo(reservaDTO.getCorreo());
        reservaEntidad.setPais(reservaDTO.getPais());
        reservaEntidad.setCelular(reservaDTO.getCelular());
        reservaEntidad.setIdentificacion(reservaDTO.getIdentificacion());

        reservaEntidad.setFechaRealizacion(LocalDateTime.now());


        return reservaRepositorio.save(reservaEntidad);
    }

    @Override
    public ArrayList<ReservaEntidad> consultar() {
        return (ArrayList<ReservaEntidad>) reservaRepositorio.findAll();
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

    private ArrayList<HabitacionEntidad> buscarHabitacionesPorTipo(int idTipo, ArrayList<HabitacionEntidad> habitacionesEntidad){
        ArrayList<HabitacionEntidad> habitacionesTipo = new ArrayList<>();

        for (HabitacionEntidad habitacionEntidad:habitacionesEntidad){
            if (habitacionEntidad.getTipo().getId()==idTipo){
                habitacionesTipo.add(habitacionEntidad);
            }
        }

        return  habitacionesTipo;
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

    private void garantizarHotelExiste(int id){
        if(hotelRepositorio.existsById(id)==false){
            throw new ExcepcionHotelNoExiste(MENSAJE_HOTEL_NO_EXISTE);
        }
    }

    private void garantizarTipoHabitacionExiste(int id){
        if(tipoHabitacionRepositorio.existsById(id)==false){
            throw new ExcepcionTipoHabitacionNoExiste(MENSAJE_TIPO_HABITACION_NO_EXISTE);
        }
    }




}
