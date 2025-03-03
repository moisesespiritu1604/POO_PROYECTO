package com.servicioreserva.reserva_hotel.servicio;

import java.util.List;

import com.servicioreserva.reserva_hotel.dao.Dao;
import com.servicioreserva.reserva_hotel.dto.Cliente;
import com.servicioreserva.reserva_hotel.dto.Habitacion;
import com.servicioreserva.reserva_hotel.dto.Hotel;
import com.servicioreserva.reserva_hotel.dto.ImagenHabitacion;
import com.servicioreserva.reserva_hotel.dto.ImagenHotel;
import com.servicioreserva.reserva_hotel.dto.ImagenServicios;
import com.servicioreserva.reserva_hotel.dto.Pago;
import com.servicioreserva.reserva_hotel.dto.Reserva;
import com.servicioreserva.reserva_hotel.dto.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioImpl implements Servicio{
    @Autowired
    private Dao dao;
    public Cliente crearCuentaCliente(Cliente cliente) {
        return dao.crearCuentaCliente(cliente);
    }
    public Reserva registrarReserva(Reserva reserva) {
        return dao.registrarReserva(reserva);
    }
    public Pago registrarPago(Pago pago) {
        return dao.registrarPago(pago);
    }
    public Habitacion reservarHabitacion(Habitacion habitacion) {
        return dao.reservarHabitacion(habitacion);
    }

    public Hotel buscarHotel(Hotel hotel) {
        return dao.buscarHotel(hotel);
    }
    public List<ImagenHotel> obtenerImagenHotels() {
        return dao.obtenerImagenHotels();
    }
    public List<ImagenHabitacion> obtenerImagenHabitaciones() {
        return dao.obtenerImagenHabitaciones();
    }
    public List<Servicios> mostrarServicios() {

        return dao.mostrarServicios();
    }
 
    public List<ImagenServicios> obtenerImagenServicios() {

        return dao.obtenerImagenServicios();
    }
    public Cliente obtenerCliente(Cliente cliente) {
        return dao.obtenerCliente(cliente);
    }

    
    
}
