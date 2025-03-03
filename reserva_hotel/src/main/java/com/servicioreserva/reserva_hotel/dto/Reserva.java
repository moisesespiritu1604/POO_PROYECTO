package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Reserva {
    private Integer idReserva;
    private Cliente cliente;
    private String fecha_reserva;
    private String fecha_ingreso;
    private String fecha_salida;
    private Double costo_reserva;
    private String estado;
}
