package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Pago {
    private Integer idPago;
    private Reserva reserva;
    private String tipo_comprobante;
    private Integer num_comprobante;
    private Double pago_total;
    private String fecha_emision;
    private String fecha_pago;
    private String estado_pago;
}
