package com.servicioreserva.reserva_hotel.servicio;

import java.util.List;

import com.servicioreserva.reserva_hotel.dto.Cliente;
import com.servicioreserva.reserva_hotel.dto.Habitacion;
import com.servicioreserva.reserva_hotel.dto.Hotel;
import com.servicioreserva.reserva_hotel.dto.ImagenHabitacion;
import com.servicioreserva.reserva_hotel.dto.ImagenHotel;
import com.servicioreserva.reserva_hotel.dto.ImagenServicios;
import com.servicioreserva.reserva_hotel.dto.Pago;
import com.servicioreserva.reserva_hotel.dto.Reserva;
import com.servicioreserva.reserva_hotel.dto.Servicios;

public interface Servicio {
    public Cliente crearCuentaCliente(Cliente cliente);
    public Reserva registrarReserva(Reserva reserva);
    public Pago registrarPago(Pago pago);
    public Habitacion reservarHabitacion(Habitacion habitacion);
    public Hotel buscarHotel(Hotel hotel);
    public List<ImagenHotel> obtenerImagenHotels();
    public List<ImagenHabitacion> obtenerImagenHabitaciones();
    public List<Servicios> mostrarServicios();
    public List<ImagenServicios> obtenerImagenServicios();
    public Cliente obtenerCliente(Cliente cliente);
}
