package com.servicioreserva.reserva_hotel.controlador;


import com.servicioreserva.reserva_hotel.dto.Cliente;
import com.servicioreserva.reserva_hotel.dto.Habitacion;
import com.servicioreserva.reserva_hotel.dto.Hotel;
import com.servicioreserva.reserva_hotel.dto.Pago;
import com.servicioreserva.reserva_hotel.dto.Reserva;
import com.servicioreserva.reserva_hotel.dto.RespuestaImagenHabitaciones;
import com.servicioreserva.reserva_hotel.dto.RespuestaImagenHotel;
import com.servicioreserva.reserva_hotel.dto.RespuestaServicio;
import com.servicioreserva.reserva_hotel.dto.RespustaImagenServicios;
import com.servicioreserva.reserva_hotel.servicio.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@CrossOrigin(origins = {"*"})
public class Controlador {
    @Autowired
    private Servicio servicio;
    @RequestMapping(value="/crear-cuentacliente", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Cliente crearCuenta(@RequestBody Cliente cliente){
        return servicio.crearCuentaCliente(cliente);
    }  
    @RequestMapping(value="/registrar-reserva", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Reserva registrarReserva(@RequestBody Reserva reserva){
        return servicio.registrarReserva(reserva);
    } 
    @RequestMapping(value="/registrar-pago", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Pago crearCuenta(@RequestBody Pago pago){
        return servicio.registrarPago(pago);
    } 
    @RequestMapping(value="/reservar-habitacion", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Habitacion reservarHabitacion(@RequestBody Habitacion habitacion){
        return servicio.reservarHabitacion(habitacion);
    }
    @RequestMapping(value="/buscar-hotel", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Hotel buscarHotel(@RequestBody Hotel hotel){
        return servicio.buscarHotel(hotel);
    }
    @RequestMapping(value="/obtener-imagenHotel", method=RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public @ResponseBody RespuestaImagenHotel obtenerImagenHotels(){
        RespuestaImagenHotel respuestaImagenHotel=new RespuestaImagenHotel();
        respuestaImagenHotel.setLista(servicio.obtenerImagenHotels());
        return respuestaImagenHotel;
    }
    @RequestMapping(value="/obtener-imagenHabitacion", method=RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public @ResponseBody RespuestaImagenHabitaciones obtenerImagenHabitaciones(){
        RespuestaImagenHabitaciones respuestaImagenHabitaciones=new RespuestaImagenHabitaciones();
        respuestaImagenHabitaciones.setLista(servicio.obtenerImagenHabitaciones());
        return respuestaImagenHabitaciones;
    }
    @RequestMapping(value="/obtener-servicios", method=RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public @ResponseBody RespuestaServicio mostrarServicios(){
        RespuestaServicio respuestaServicio=new RespuestaServicio();
        respuestaServicio.setLista(servicio.mostrarServicios());
        return respuestaServicio;
    }

    @RequestMapping(value="/obtener-imagenServicios", method=RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public @ResponseBody RespustaImagenServicios obtenerImagenServicios(){
        RespustaImagenServicios respustaImagenServicios=new RespustaImagenServicios();
        respustaImagenServicios.setLista(servicio.obtenerImagenServicios());
        return respustaImagenServicios;
    }
    @RequestMapping(value="/autenticar-cliente", method=RequestMethod.POST,
            consumes = "application/json;charset=utf-8",
            produces = "application/json;charset=utf-8")
    public @ResponseBody Cliente obtenerCliente(@RequestBody Cliente cliente){
        return servicio.obtenerCliente(cliente);
    } 
}
