package com.servicioreserva.reserva_hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaImagenHotel {
    private List<ImagenHotel> lista;
}
