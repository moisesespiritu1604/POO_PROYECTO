package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Servicios {
    private Integer id_servicio;
    private Hotel hotel;
    private String descripcion;
}
