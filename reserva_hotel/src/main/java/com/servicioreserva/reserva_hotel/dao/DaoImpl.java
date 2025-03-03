package com.servicioreserva.reserva_hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servicioreserva.reserva_hotel.dto.Cliente;
import com.servicioreserva.reserva_hotel.dto.Habitacion;
import com.servicioreserva.reserva_hotel.dto.Hotel;
import com.servicioreserva.reserva_hotel.dto.ImagenHabitacion;
import com.servicioreserva.reserva_hotel.dto.ImagenHotel;
import com.servicioreserva.reserva_hotel.dto.ImagenServicios;
import com.servicioreserva.reserva_hotel.dto.Pago;
import com.servicioreserva.reserva_hotel.dto.Reserva;
import com.servicioreserva.reserva_hotel.dto.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DaoImpl implements Dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection conexion;
    private void crearConexion(){
        try {
            conexion=jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion(){
        try {
            conexion.commit();
            conexion.close();
            conexion=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Cliente crearCuentaCliente(Cliente cliente) {
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO Cliente (id_cliente, nombre, apellidoPaterno, apellidoMaterno, tipo_documento, numero_documento, direccion, telefono, email, contraseña) ").
            append(" VALUES ( nextval(secuencia_cliente) , ? , ?, ?, ?, ? , ? , ?, ?, ? ) ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellidoPaterno());
            sentencia.setString(3, cliente.getApellidoMaterno());
            sentencia.setString(4, cliente.getTipoDocumento());
            sentencia.setInt(5, cliente.getNroDocumento());
            sentencia.setString(6, cliente.getDireccion());
            sentencia.setInt(7, cliente.getTelefono());
            sentencia.setString(8, cliente.getEmail());
            sentencia.setString(9, cliente.getContraseña());
            sentencia.executeUpdate();
            sentencia.close();
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public Reserva registrarReserva(Reserva reserva) {
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO  reserva(id_reserva, id_cliente, fecha_reserva, fecha_ingreso, fecha_salida, costo_reserva, estado) ").
            append(" VALUES ( ? , ? , ?, ?, ?, ? , ? ) ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setInt(1, reserva.getIdReserva());
            sentencia.setInt(2, reserva.getCliente().getIdCliente());
            sentencia.setString(3, reserva.getFecha_reserva());
            sentencia.setString(4, reserva.getFecha_ingreso());
            sentencia.setString(5, reserva.getFecha_salida());
            sentencia.setDouble(6, reserva.getCosto_reserva());
            sentencia.setString(7, reserva.getEstado());
            sentencia.executeUpdate();
            sentencia.close();
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }
    public Pago registrarPago(Pago pago) {
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO  Pago (id_pago, id_reserva, tipo_comprobante, num_comprobante, pago_total, fecha_emision, fecha_pago, estado_pago) ").
            append(" VALUES ( ? , ? , ?, ?, ?, ? , ?, ?) ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setInt(1, pago.getIdPago());
            sentencia.setInt(2, pago.getReserva().getIdReserva());
            sentencia.setString(3, pago.getTipo_comprobante());
            sentencia.setInt(4, pago.getNum_comprobante());
            sentencia.setDouble(5, pago.getPago_total());
            sentencia.setString(6, pago.getFecha_emision());
            sentencia.setString(7, pago.getFecha_pago());
            sentencia.setString(8, pago.getEstado_pago());
            sentencia.executeUpdate();
            sentencia.close();
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pago;
    }
    public Habitacion reservarHabitacion(Habitacion habitacion) {
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO  Habitacion (id_habitacion, id_pago, ubicacion_piso, ubicacion_habtacion, estado_habitacion, precio_habitacion, descripcion) ").
            append(" VALUES ( ? , ? , ?, ?, ?, ? , ?) ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setInt(1, habitacion.getIdHabitacion());
            sentencia.setInt(2, habitacion.getPago().getIdPago());
            sentencia.setInt(3, habitacion.getUbicacion_piso());
            sentencia.setString(4, habitacion.getUbicacion_habtacion());
            sentencia.setString(5, habitacion.getEstado_habitacion());
            sentencia.setDouble(6, habitacion.getPrecio_habitacion());
            sentencia.setString(7, habitacion.getDescripcion());
            sentencia.executeUpdate();
            sentencia.close();
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitacion;
    }
    public Hotel buscarHotel(Hotel hotel){
        Hotel hotelRetorno=new Hotel();
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos FROM hotel ").
            append(" WHERE ubicacion= ? ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setString(1, hotel.getUbicacion());
            ResultSet resultado= sentencia.executeQuery();
            while(resultado.next()){
                hotelRetorno.setId_hotel(resultado.getInt("id_hotel"));
                hotelRetorno.setNombre(resultado.getString("nombre"));
                hotelRetorno.setUbicacion(resultado.getString("ubicacion"));
                hotelRetorno.setTipo_hotel(resultado.getString("tipo_hotel"));
                hotelRetorno.setCantidad_pisos(resultado.getInt("cantidad_pisos"));
            }
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelRetorno;
    }
    public List<ImagenHotel> obtenerImagenHotels() {
        List<ImagenHotel> lista = new ArrayList<>();

        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, i.url_imagen").
            append(" FROM imagenhotel i JOIN hotel h ON (i.id_hotel=h.id_hotel);");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sb.toString());
            while (resultado.next()){
                ImagenHotel imagenHotel=new ImagenHotel();
                Hotel hotel = new Hotel();
                hotel.setId_hotel(resultado.getInt("id_hotel"));
                hotel.setNombre(resultado.getString("nombre"));
                hotel.setUbicacion(resultado.getString("ubicacion"));
                hotel.setTipo_hotel(resultado.getString("tipo_hotel"));
                hotel.setCantidad_pisos(resultado.getInt("cantidad_pisos"));
                imagenHotel.setUrl(resultado.getString("url_imagen"));
                imagenHotel.setHotel(hotel);

                lista.add(imagenHotel);
            }
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }
    public List<ImagenHabitacion> obtenerImagenHabitaciones() {
        List<ImagenHabitacion> lista = new ArrayList<>();

        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT id_habitacion, url_imagen").
            append(" FROM  imagenhabitacion ORDER by id_habitacion ASC");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sb.toString());
            while (resultado.next()){
                ImagenHabitacion imagenHabitacion = new ImagenHabitacion();
                Habitacion habitacion=new Habitacion();
                habitacion.setIdHabitacion(resultado.getInt("id_habitacion"));
                imagenHabitacion.setUrl(resultado.getString("url_imagen"));
                imagenHabitacion.setHabitacion(habitacion);
                lista.add(imagenHabitacion);
            }
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }
    public List<Servicios> mostrarServicios(){
        List<Servicios> lista = new ArrayList<>();
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT  h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, s.id_servicio, s.descripcion").
            append(" FROM servicio s JOIN hotel h ON (s.id_hotel=h.id_hotel);");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sb.toString());
            while (resultado.next()){
                Servicios servicios = new Servicios();
                Hotel hotel=new Hotel();
                hotel.setId_hotel(resultado.getInt("id_hotel"));
                hotel.setNombre(resultado.getString("nombre"));
                hotel.setUbicacion(resultado.getString("ubicacion"));
                hotel.setTipo_hotel(resultado.getString("tipo_hotel"));
                hotel.setCantidad_pisos(resultado.getInt("cantidad_pisos"));

                servicios.setId_servicio(resultado.getInt("id_servicio"));
                servicios.setHotel(hotel);
                servicios.setDescripcion(resultado.getString("descripcion"));
                lista.add(servicios);
            }
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }
    public List<ImagenServicios> obtenerImagenServicios() {
        List<ImagenServicios> lista = new ArrayList<>();

        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, s.id_servicio, s.descripcion, i.url_imagen").
            append(" FROM servicio s JOIN imagenservicio i ON (s.id_servicio=i.id_servicio)").
            append(" JOIN hotel h ON (h.id_hotel=s.id_hotel) ORDER BY id_servicio");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sb.toString());
            while (resultado.next()){
                ImagenServicios imagenServicios = new ImagenServicios();
                Servicios servicios=new Servicios();
                Hotel hotel=new Hotel();
                hotel.setId_hotel(resultado.getInt("id_hotel"));
                hotel.setNombre(resultado.getString("nombre"));
                hotel.setUbicacion(resultado.getString("ubicacion"));
                hotel.setTipo_hotel(resultado.getString("tipo_hotel"));
                hotel.setCantidad_pisos(resultado.getInt("cantidad_pisos"));

                servicios.setId_servicio(resultado.getInt("id_servicio"));
                servicios.setHotel(hotel);
                servicios.setDescripcion(resultado.getString("descripcion"));

                imagenServicios.setServicios(servicios);
                imagenServicios.setUrl(resultado.getString("url_imagen"));
                lista.add(imagenServicios);
            }
            cerrarConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }
   
    public Cliente obtenerCliente(Cliente cliente) {
        Cliente clienteRetorno=new Cliente();
        try {
            crearConexion();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT id_cliente, nombre, apellidoPaterno, apellidoMaterno, tipo_documento, numero_documento, direccion, telefono, email, contraseña ").
            append(" FROM cliente" ).
            append(" WHERE email= ? AND contraseña= ? ");
            PreparedStatement sentencia = conexion.prepareStatement(sb.toString());
            sentencia.setString(1, cliente.getEmail());
            sentencia.setString(2, cliente.getContraseña());
            ResultSet resultado= sentencia.executeQuery();
            while(resultado.next()){
                clienteRetorno.setIdCliente(resultado.getInt("id_cliente"));
                clienteRetorno.setNombre(resultado.getString("nombre"));
                clienteRetorno.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                clienteRetorno.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                clienteRetorno.setTipoDocumento(resultado.getString("tipo_documento"));
                clienteRetorno.setNroDocumento(resultado.getInt("numero_documento"));
                clienteRetorno.setDireccion(resultado.getString("direccion"));
                clienteRetorno.setTelefono(resultado.getInt("telefono"));
                clienteRetorno.setEmail(resultado.getString("email"));
                clienteRetorno.setContraseña(null);
            }
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteRetorno;
    }
    
}
