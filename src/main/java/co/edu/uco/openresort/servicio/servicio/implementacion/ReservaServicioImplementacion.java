package co.edu.uco.openresort.servicio.servicio.implementacion;

import co.edu.uco.openresort.cliente.EmailCliente;
import co.edu.uco.openresort.dto.RespuestaDisponibilidadPlanDTO;
import co.edu.uco.openresort.dto.ConsultaDisponibilidadDTO;
import co.edu.uco.openresort.dto.RespuestaDisponibilidadDTO;
import co.edu.uco.openresort.dto.ReservaDTO;
import co.edu.uco.openresort.entidad.HabitacionEntidad;
import co.edu.uco.openresort.entidad.PlanEntidad;
import co.edu.uco.openresort.entidad.ReservaEntidad;
import co.edu.uco.openresort.entidad.TipoHabitacionEntidad;
import co.edu.uco.openresort.excepcion.*;
import co.edu.uco.openresort.repositorio.*;
import co.edu.uco.openresort.servicio.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
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
    private static final String MENSAJE_PLAN_NO_EXISTE="El plan seleccionado no existe";

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;
    @Autowired
    private HotelRepositorio hotelRepositorio;
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;
    @Autowired
    private PlanRepositorio planRepositorio;


    //en la firma del metodo debe llegar un objeto Entidad y no un DTO
    @Override
    public ArrayList<HabitacionEntidad> consultarDisponibilidadHabitaciones(ConsultaDisponibilidadDTO disponibilidadDTO) {

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
        ArrayList<HabitacionEntidad> habitacionesDisponibles = buscarHabitacionesDisponibles(disponibilidadDTO.getFechaLlegada(),disponibilidadDTO.getFechaSalida(),habitacionesConCapacidad);

        if(habitacionesDisponibles.size()==0){
            throw new ExcepcionReservaSinDisponibilidad(MENSAJE_RESERVA_HABITACIONES_NO_DISPONIBLES);
        }

        return habitacionesDisponibles;
    }

    //en la firma del metodo debe llegar un objeto Entidad y no un DTO
    @Override
    public ArrayList<TipoHabitacionEntidad> consultarDisponibilidadTipoHabitacion(ConsultaDisponibilidadDTO disponibilidadDTO) {
        ArrayList<HabitacionEntidad> habitacionesDisponibles = consultarDisponibilidadHabitaciones(disponibilidadDTO);
        ArrayList<TipoHabitacionEntidad> tipoHabitaciones = new ArrayList<>();
        for (HabitacionEntidad habitacionEntidad:habitacionesDisponibles) {
            if(!tipoHabitaciones.contains(habitacionEntidad.getTipo())){
                tipoHabitaciones.add(habitacionEntidad.getTipo());
            }

        }
        return tipoHabitaciones;
    }

    //en la firma del metodo debe llegar un objeto Entidad y no un DTO
    @Override
    public ReservaEntidad reservar(ReservaDTO reservaDTO) throws IOException {

        garantizarHotelExiste(reservaDTO.getIdHotel());
        garantizarTipoHabitacionExiste(reservaDTO.getIdTipoHabitacion());
        garantizarPlanExiste(reservaDTO.getIdPlan());

        ConsultaDisponibilidadDTO disponibilidadDTO = new ConsultaDisponibilidadDTO();

        disponibilidadDTO.setIdHotel(reservaDTO.getIdHotel());
        disponibilidadDTO.setFechaLlegada(reservaDTO.getFechaLlegada());
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

        //esto deberia estar en ReservaEnsamblador

        ReservaEntidad reservaEntidad = new ReservaEntidad();
        PlanEntidad planEntidad = new PlanEntidad();
        reservaEntidad.setPlan(planEntidad);

        reservaEntidad.setHabitacion(habitacionesDisponiblesTipo.get(0));
        reservaEntidad.setNumeroHabitacion(reservaEntidad.getHabitacion().getNumero());
        reservaEntidad.getPlan().setId(reservaDTO.getIdPlan());

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
        reservaEntidad.setFechaNacimiento(reservaDTO.getFechaNacimiento());

        //implementar una libreria para generar codigos hash a partir de la identificacion
        reservaEntidad.setCodigo("or-"+reservaDTO.getIdentificacion());

        reservaEntidad.setFechaRealizacion(LocalDateTime.now());

        //String mensaje = reservaEntidad.getNombres()+" "+reservaEntidad.getApellidos()+", "+"Su reserva está confirmada!";
        String mensaje = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div>\n" +
                "      <h1>Felicidades " + reservaEntidad.getNombres() + ", tu reserva ha sido confirmada!</h1> \n" +
                "    </div>\n" +
                "\n" +
                "    <div>\n" +
                "      <h2>Detalles</h2>\n" +
                "    </div>\n" +
                "    \n" +
                "    <div>\n" +
                "      <b>Hotel:</b> " + reservaEntidad.getHabitacion().getHotel().getNombre() +
                "      <b>Tipo de habitación:</b> " + reservaEntidad.getHabitacion().getTipo().getNombre() +
                "      <b>Número de habitación:</b> " +reservaEntidad.getNumeroHabitacion() +
                "      <b>Cantidad de adultos:</b> " +reservaEntidad.getAdultos() +
                "      <b>Cantidad de niños:</b> " +reservaEntidad.getNinos() +
                "      <b>Fecha de llegada:</b> "+reservaEntidad.getFechaLlegada() +
                "      <b>Fecha de salida:</b> "+reservaEntidad.getFechaSalida() +
                "      <b>Codigo:</b> "+ reservaEntidad.getCodigo() +
                "    </div>\n" +
                "\n" +
                "    <footer>\n" +
                "      <b>Fecha de realización de la reserva:</b> "+ reservaEntidad.getFechaRealizacion() +
                "    </footer>\n" +
                "\n" +
                "  </body>\n" +
                "</html>";

        EmailCliente.enviarCorreo("kevma.notificaciones@gmail.com",reservaEntidad.getCorreo(),"Confirmación de reserva",mensaje);



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

    private void garantizarPlanExiste(int id){
        if(planRepositorio.existsById(id)==false){
            throw new ExcepcionPlanNoExiste(MENSAJE_PLAN_NO_EXISTE);
        }
    }

    @Override
    public ArrayList<RespuestaDisponibilidadDTO> obtenerListaDisponibilidad(ConsultaDisponibilidadDTO disponibilidadDTO){

        ArrayList<RespuestaDisponibilidadDTO> listaDisponibilidad = new ArrayList<>();

        ArrayList<TipoHabitacionEntidad> tipoHabitacionesDisponibles = consultarDisponibilidadTipoHabitacion(disponibilidadDTO);

        for(TipoHabitacionEntidad tipoHabitacionEntidad : tipoHabitacionesDisponibles){
            RespuestaDisponibilidadDTO consultaDisponibilidadDTO = new RespuestaDisponibilidadDTO();

            consultaDisponibilidadDTO.setConsulta(disponibilidadDTO);
            consultaDisponibilidadDTO.setIdTipoHabitacion(tipoHabitacionEntidad.getId());
            consultaDisponibilidadDTO.setNombre(tipoHabitacionEntidad.getNombre());
            consultaDisponibilidadDTO.setDescripcion(tipoHabitacionEntidad.getDescripcion());
            consultaDisponibilidadDTO.setCapacidadAdultos(tipoHabitacionEntidad.getCapacidadAdultos());
            consultaDisponibilidadDTO.setCapacidadNinos(tipoHabitacionEntidad.getCapacidadNinos());

            consultaDisponibilidadDTO.setPlanes(setearPlanesConPrecio(tipoHabitacionEntidad,disponibilidadDTO));

            listaDisponibilidad.add(consultaDisponibilidadDTO);
        }

        return listaDisponibilidad;
    }

    private ArrayList<RespuestaDisponibilidadPlanDTO> setearPlanesConPrecio(TipoHabitacionEntidad tipoHabitacionEntidad, ConsultaDisponibilidadDTO disponibilidadDTO){
        ArrayList<RespuestaDisponibilidadPlanDTO> planesConPrecio = new ArrayList<>();
        ArrayList<PlanEntidad> planesExistentes = (ArrayList<PlanEntidad>) planRepositorio.findAll();

        for(PlanEntidad planEntidad:planesExistentes){
            RespuestaDisponibilidadPlanDTO consultaDisponibilidadPlanDTO = new RespuestaDisponibilidadPlanDTO();

            consultaDisponibilidadPlanDTO.setIdPlan(planEntidad.getId());
            consultaDisponibilidadPlanDTO.setNombre(planEntidad.getNombre());
            consultaDisponibilidadPlanDTO.setDescripcion(planEntidad.getDescripcion());
            consultaDisponibilidadPlanDTO.setPrecioTotal(calcularPrecioTotal(tipoHabitacionEntidad, disponibilidadDTO));

            planesConPrecio.add(consultaDisponibilidadPlanDTO);

        }
        return planesConPrecio;
    }

    private BigDecimal calcularPrecioTotal(TipoHabitacionEntidad tipoHabitacionEntidad, ConsultaDisponibilidadDTO disponibilidadDTO){
        return new BigDecimal(100);
    }




}
