package com.servicioreserva.reserva_hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaImagenHabitaciones {
    private List<ImagenHabitacion> lista;
}
