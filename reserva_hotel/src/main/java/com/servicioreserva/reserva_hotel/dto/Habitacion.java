package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Habitacion {
    private Integer idHabitacion;
    private Pago pago;
    private Integer ubicacion_piso;
    private String ubicacion_habtacion;
    private String estado_habitacion;
    private Double precio_habitacion;
    private String descripcion;
    
}
