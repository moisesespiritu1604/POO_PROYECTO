package com.servicioreserva.reserva_hotel.dto;

import lombok.Data;

@Data
public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private Integer nroDocumento;
    private String direccion;
    private Integer telefono;
    private String email;
    private String contraseña;
}
