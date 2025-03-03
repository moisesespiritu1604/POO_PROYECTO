CREATE DATABASE proyecto_poo;
USE proyecto_poo;
CREATE TABLE Cliente(
	id_cliente NUMERIC(10) PRIMARY KEY, 
	nombre VARCHAR(100),
	apellidoPaterno VARCHAR(100),
	apellidoMaterno VARCHAR(100),
	tipo_documento VARCHAR(20), #dni,pasaporte,cedula,carnet extranjeria
	numero_documento NUMERIC(10),
	direccion VARCHAR(500),
	telefono NUMERIC(10),
	email VARCHAR(500),
	contraseña VARCHAR(100)
);

CREATE TABLE Reserva(
	id_reserva NUMERIC (10) PRIMARY KEY, #1,2,3,4,.......
	id_cliente NUMERIC (10), #100,101,102,103,....
	fecha_reserva DATE,
	fecha_ingreso DATE,
	fecha_salida DATE,
	costo_reserva NUMERIC(7,2), #costo reserva (10% del costo de habitacion)
	estado VARCHAR (200) #proceso,culminado
);

ALTER TABLE Reserva ADD FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente);

CREATE TABLE Pago(
	id_pago NUMERIC(10) PRIMARY KEY, #1000,1001,1002,1003,....
	id_reserva NUMERIC(10),
	tipo_comprobante VARCHAR(100), #boleta,factura electronicos
	num_comprobante NUMERIC(9),
	pago_total NUMERIC(7,2), #costo de reserva + costo de habitacion
	fecha_emision DATE,
	fecha_pago DATE,
	estado_pago VARCHAR(100) #cancelado,proceso
);

ALTER TABLE Pago ADD FOREIGN KEY(id_reserva) REFERENCES Reserva(id_reserva);

CREATE TABLE Habitacion(
	id_habitacion NUMERIC (10) PRIMARY KEY,
	id_pago NUMERIC(10),
	ubicacion_piso NUMERIC(10), #ubicacion del piso 1,2,3...10
	ubicacion_habtacion VARCHAR(100),
	estado_habitacion VARCHAR(100), #ocupado,desocupado,mantenimiento
	precio_habitacion NUMERIC(7,2), #solo habitacion (depende del tipo hotel y habitacion)
	descripcion VARCHAR(1000) 
);

ALTER TABLE Habitacion ADD FOREIGN KEY(id_pago) REFERENCES Pago(id_pago);

CREATE TABLE ReservaHabitacion(
	id_reserva NUMERIC(10),
	id_habitacion NUMERIC(19)
);
ALTER TABLE ReservaHabitacion ADD FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva);
ALTER TABLE ReservaHabitacion ADD FOREIGN KEY (id_habitacion) REFERENCES Habitacion(id_habitacion);

CREATE TABLE ImagenHabitacion(
	id_habitacion NUMERIC(10),
	url_imagen VARCHAR(100)
);

ALTER TABLE ImagenHabitacion ADD FOREIGN KEY (id_habitacion) REFERENCES Habitacion (id_habitacion);


CREATE TABLE TipoHabitacion( #personal,familiar (2 camas - 5 camas)
	id_habitacion NUMERIC(10),
	tipo VARCHAR(100)
);
ALTER TABLE TipoHabitacion ADD FOREIGN KEY (id_habitacion) REFERENCES Habitacion (id_habitacion);

CREATE TABLE Hotel(
	id_hotel NUMERIC(10) PRIMARY KEY, #111,222,333,444,...
	nombre VARCHAR(100), #cosntante
	ubicacion VARCHAR(200),
	tipo_hotel VARCHAR(100), #1 estrella,2 estrellas, .... , 5 estrellas
	cantidad_pisos NUMERIC(10) #numero de pisos 1,2,3...10
);

CREATE TABLE ImagenHotel(
	id_hotel NUMERIC(10),
	url_imagen VARCHAR(500)
);

ALTER TABLE ImagenHotel ADD FOREIGN KEY (id_hotel) REFERENCES Hotel (id_hotel);

CREATE TABLE Servicio(
	id_servicio NUMERIC(10) PRIMARY KEY,
	id_hotel NUMERIC(10),
	descripcion VARCHAR(1000)
);
ALTER TABLE Servicio ADD FOREIGN KEY(id_hotel) REFERENCES Hotel(id_hotel);
CREATE TABLE ImagenServicio(
	id_servicio NUMERIC(10),
	url_imagen VARCHAR(500)
);
ALTER TABLE ImagenServicio ADD FOREIGN KEY (id_servicio) REFERENCES Servicio (id_servicio);

-- primer servicio "crear cuenta cliente"
INSERT INTO Cliente (id_cliente, nombre, apellidoPaterno, apellidoMaterno, tipo_documento, numero_documento, direccion, telefono, email, contraseña)
VALUES(1,'Moises','Espiritu','Rojas','DNI',73104587,'Comas',932591194,'moises.espiritu.r@uni.pe','moi1234');

id_reserva, id_cliente, fecha_reserva, fecha_ingreso, fecha_salida, costo_reserva, estado
DELETE FROM cliente 
WHERE id_cliente=1;
SELECT * FROM cliente;

-- empezar con la reserva 
INSERT INTO  reserva(id_reserva, id_cliente, fecha_reserva, fecha_ingreso, fecha_salida, costo_reserva, estado)
VALUES(111,1,'20210701','20210703','20210705',50.5,'Proceso');
SELECT * FROM reserva;
id_pago, id_reserva, tipo_comprobante, num_comprobante, pago_total, fecha_emision, fecha_pago, estado_pago

-- registrar pago 
INSERT INTO Pago (id_pago, id_reserva, tipo_comprobante, num_comprobante, pago_total, fecha_emision, fecha_pago, estado_pago)
VALUES(1000,111,'Boleta',1,150.5,'20210703','20210703','Cancelado');

SELECT * FROM pago;
-- registrar habitacion 
INSERT INTO Habitacion (id_habitacion, id_pago, ubicacion_piso, ubicacion_habtacion, estado_habitacion, precio_habitacion, descripcion)
VALUES(101,1000,4,'4A101','Cancelado',150.50,'Limpio');
-- buscar hotel

DELETE FROM hotel WHERE id_hotel=1112;
-- mostrar descripción 
SELECT * FROM hotel
WHERE ubicacion='Jr viscardo 180 - Comas';

-- mostrar imagenes servicio 
INSERT INTO imagenhabitacion(id_habitacion,url_imagen)
VALUES (10,"wwww.eee.com");

-- mostrar imagenes de hotel 
insert into imagenhotel, id_hotel, url_imagen


SELECT * FROM imagenhotel;

SELECT id_hotel, url_imagen FROM imagenhotel;

-- insertando hoteles
INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (1111,'Fiesta Hotel','Alcanfores 475, Miraflores 15074','4 estrellas',8);

INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (2222,'Hotel J. Pardo','Ca. Gral. Borgoño 116, Miraflores 18','4 estrellas',8);

INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (222,'Hotel J. Pardo','Ca. Gral. Borgoño 116, Miraflores 18','4 estrellas',8);
INSERT INTO imagenhotel(id_hotel,url_imagen)
VALUES (222,'http://thunderbirdhotels.com/extra-images/pardo_gale5.jpg');

INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (3333,'Sheraton Lima Hotel & Convention Center','Jirón Camaná 944-962, Cercado de Lima 15001','Cinco estrellas',20);

INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (4444,'Hotel Carrera','Jirón Leon Velarde 123, Lince, Lima 14 Lima, Perú','4 estrellas',10);

INSERT INTO hotel(id_hotel,nombre,ubicacion,tipo_hotel,cantidad_pisos)
VALUES (5555,'El Pueblo Resort & Convention Center','Carretera Central, km. 10.5, Ate, Perú','cuatro estrellas',2);

SELECT * FROM hotel
-- insertando imagenes de los hoteles registrados
INSERT INTO ImagenHotel (id_hotel, url_imagen)
VALUES (1111,'http://thunderbirdhotels.com/extra-images/main_gale6.jpg');

INSERT INTO ImagenHotel(id_hotel,url_imagen)
VALUES (2222,'http://thunderbirdhotels.com/extra-images/pardo_gale1.jpg');


INSERT INTO ImagenHotel(id_hotel,url_imagen)
VALUES (3333,'https://imgcy.trivago.com/c_lfill,d_dummy.jpeg,e_sharpen:60,f_auto,h_225,q_auto,w_225/itemimages/10/11/101151_v3.jpeg');

INSERT INTO imagenhotel(id_hotel,url_imagen)
VALUES (4444,'https://cf.bstatic.com/xdata/images/hotel/max1024x768/265344576.jpg?k=8ca74139a696a27bb0de2f21d7b6955a9e4c79b70738a20fab33c3b75bfe2d48&o=&hp=1');

INSERT INTO imagenhotel(id_hotel,url_imagen)
VALUES (5555,'https://www.atrapalo.pe/hoteles/picture/l/696/7/5/376957973.jpg');

-- obtener url de imagen hotel
SELECT h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, i.url_imagen
FROM imagenhotel i JOIN hotel h ON (i.id_hotel=h.id_hotel);

-- insertando habitacion pra prueba
INSERT INTO Habitacion (id_habitacion, id_pago, ubicacion_piso, ubicacion_habtacion, estado_habitacion, precio_habitacion, descripcion)
VALUES(101,1000,4,'4A101','Cancelado',150.50,'Limpio');

INSERT INTO Habitacion(id_habitacion,id_pago,ubicacion_piso,ubicacion_habtacion,estado_habitacion,precio_habitacion,descripcion)
VALUES (100,1000,4,'4A111','Ocupado',199.90,'televisor LCD de 32 pulgadas, aire acondicionado y minibar, así como caja fuerte, área de trabajo, baño privado y vistas a la ciudad');


-- insertando servicios por hotel

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (1000,1111,'Restaurante');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (1000,'https://cdn.ostrovok.ru/t/240x240/content/f2/63/f2633422b942257f2b3256334d0df7184f51d751.jpeg');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (2000,1111,'Gimnasio');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (2000,'https://cdn.ostrovok.ru/t/240x240/content/4c/4a/4c4adaf93441f126dcb96a100dc70fdb334e03b5.jpeg');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (3000, 2222,'Restaurante');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (3000,'http://thunderbirdhotels.com/pardo/pardo_cafe21.html#');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (4000, 2222,'Salones');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (4000,'http://thunderbirdhotels.com/pardo/pardo_eventos.html#');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (5000,3333,'Gimnacio');

INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (5000,'https://imgcy.trivago.com/d_dummy.jpeg,f_auto,q_auto/if_iw_lte_ih,c_scale,w_236/if_else,c_scale,h_160/e_improve,q_auto:low//partnerimages/33/17/331700466.jpeg');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (6000,3333,'Piscina');

INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (6000,'https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/33/17/331700474.jpeg');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (7000,444,'bar');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (7000,'https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/72/04/720478692.jpeg');

INSERT INTO Servicio(id_servicio,id_hotel,descripcion)
VALUE (8000,444,'jacuzzi');
INSERT INTO Imagenservicio(id_servicio,url_imagen)
VALUE (8000,'https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/36/17/361737678.jpeg');

-- obteniendo url de imagen de los servicios 
SELECT h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, s.id_servicio, s.descripcion, i.url_imagen
FROM servicio s JOIN imagenservicio i ON (s.id_servicio=i.id_servicio) JOIN hotel h ON (h.id_hotel=s.id_hotel) ORDER BY id_servicio;


SELECT id_servicio,id_hotel,descripcion FROM servicio;

SELECT  h.id_hotel,h.nombre,h.ubicacion,h.tipo_hotel,h.cantidad_pisos, s.id_servicio, s.descripcion
FROM servicio s JOIN hotel h ON (s.id_hotel=h.id_hotel);

-- cambiando algunos urls
UPDATE Imagenservicio
SET url_imagen='https://hotelmiramarperu.com/hotelmiramar/wp-content/uploads/2018/03/MASAJES600-2.jpg'
WHERE id_servicio=3000;
UPDATE Imagenservicio
SET url_imagen='https://media-cdn.tripadvisor.com/media/photo-s/06/14/44/ac/getlstd-property-photo.jpg'
WHERE id_servicio=4000;

-- cambiando algunos servicios
UPDATE servicio
SET descripcion='Spa'
WHERE id_servicio=3000;

UPDATE servicio
SET descripcion='Restaurante'
WHERE id_servicio=4000;

SELECT * FROM habitacion;
SELECT * FROM cliente;
-- crear la secuencia para cliente
CREATE SEQUENCE secuencia_cliente START WITH 1
SELECT NEXTVAL(secuencia_cliente)


-- buscar usuario con su correo y contraseña
SELECT id_cliente, nombre, apellidoPaterno, apellidoMaterno, tipo_documento, numero_documento, direccion, telefono, email, contraseña
FROM cliente 
WHERE email='moises.espiritu.r@uni.pe' AND contraseña='moi1234';

-- reporte de reserva
SELECT c.nombre,c.apellidoPaterno,c.apellidoMaterno,r.fecha_ingreso,r.fecha_salida,p.pago_total
FROM cliente c
INNER JOIN (reserva r INNER JOIN pago p ON (r.id_reserva=p.id_reserva))
ON (c.id_cliente=r.id_cliente);

SELECT * from tipohabitacion;

DELETE FROM cliente 
WHERE id_cliente=17;
