export interface Hotel{
    id_hotel?: number;
    nombre?: string;
    ubicacion?: string;
    tipo_hotel?: string;
    cantidad_pisos?: number;
}
export interface ImagenHotel{
    hotel: Hotel;
    url?: string;
}

export interface Cliente{
    idCliente?: number;
    nombre: string;
    apellidoPaterno: string;
    apellidoMaterno: string;
    tipoDocumento: string;
    nroDocumento: number;
    direccion: string;
    telefono: number;
    email: string;
    contraseña: string;
}
export interface Reserva{
    idReserva?: number;
    cliente: Cliente;
    tipoDocumento?: string;
    fecha_ingreso?: string;
    fecha_salida?: string;
    costo_reserva?: number;
    estado?: string;
}
export interface Pago{
    idPago?: number;
    reserva: Reserva;
    tipo_comprobante?: string;
    num_comprobante?: number;
    pago_total?: number;
    fecha_emision?: string;
    fecha_pago?: string;
    estado_pago?: string;
}
export interface Habitacion{
    idHabitacion?: number;
    pago: Pago;
    ubicacion_piso?: number;
    ubicacion_habtacion?: string;
    estado_habitacion?: string;
    precio_habitacion?: number;
    descripcion?: string;
}
export  interface ImagenHabitacion{
    habitacion: Habitacion;
    url_img?: string;
}
export interface RespuestaImagenHotel{
    lista: ImagenHotel[];
}
export interface RespuestaImagenHabitacion{
    lista2: ImagenHabitacion[];
}
export interface Servicios{
    id_servicio?: number;
    hotel: Hotel;
    descripcion?: string; 
}
export  interface ImagenServicios{
    servicios: Servicios;
    url?: string;
}
export interface RespuestaImagenServicios{
    lista: ImagenServicios[];
}
export interface RespuestaServicios{
    lista: Servicios[];
}
export interface SesionUsuario{
    id : number ;
    correo: string;
    nombres: string;
}