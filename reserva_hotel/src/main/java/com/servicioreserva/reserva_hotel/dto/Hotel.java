package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Hotel {
    private Integer id_hotel;
    private String nombre;
    private String ubicacion;
    private String tipo_hotel;
    private Integer cantidad_pisos;

    
}
