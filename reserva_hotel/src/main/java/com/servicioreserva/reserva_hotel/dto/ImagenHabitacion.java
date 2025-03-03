package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class ImagenHabitacion {
    private Habitacion habitacion;
    private String url;
}
