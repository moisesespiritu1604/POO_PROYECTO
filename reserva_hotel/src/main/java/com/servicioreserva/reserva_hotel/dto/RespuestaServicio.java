package com.servicioreserva.reserva_hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaServicio {
    private List<Servicios> lista;
}
