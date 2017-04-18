-- Crecion de la base de datos: VERIFACT
-- 14/04/2017
-- Burgueño Sanchez Ivan Samuel
-- Clemente Aguirre Daniel
-- Palacios Oviedo Victor
-- Carreon Manriquez Paula Shade

-- CREACIÓN DE LA BASE DE DATOS

CREATE DATABASE verifact CHARACTER SET 'UTF8';
USE verifact;

-- CREACIÓN DE TABLAS

-- TABLA PROVEEDOR

CREATE TABLE proveedor(
id_proveedor INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
proveedor VARCHAR(100) NOT NULL
)Engine=Innodb;

-- TABLA SERVICIO

CREATE TABLE servicio(
id_servicio INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
servicio VARCHAR(100) NOT NULL,
id_proveedor INT(5),
FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor) on delete cascade
)Engine=Innodb;

-- TABLA FACTURA

CREATE TABLE factura(
folio_factura VARCHAR(50) PRIMARY KEY NOT NULL,
fecha_recep DATE NOT NULL,
quincena CHAR(7) NOT NULL,
estado_factura CHAR(9) NOT NULL,
factura_img VARCHAR(100),
subtotal FLOAT(8,2) NOT NULL,
iva FLOAT(8,2) NOT NULL,
total FLOAT(8,2) NOT NULL
)Engine=Innodb;

-- TABLA ORDEN_PAGO

CREATE TABLE orden_pago(
no_orden_pago INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
solicitante VARCHAR(50) DEFAULT 'C.P. Armando Mendoza Delgado',
fecha_orden DATE NOT NULL,
departamento VARCHAR(50) DEFAULT 'Estadio Azul',
tipo_pago VARCHAR (15) NOT NULL,
importe_numero FLOAT(8,2) NOT NULL,
importe_letra VARCHAR(50) NOT NULL,
aplic_contable VARCHAR(80) NOT NULL,
gerente_area VARCHAR(30) DEFAULT 'Lic. Pedro Ruiz Isunza',
direccion_area VARCHAR(30) DEFAULT 'C.P. Isaac Velasco Alcantara'
)Engine=Innodb;

-- TABLA PAGO

CREATE TABLE pago(
id_pago INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
no_orden_pago INT(5) NOT NULL,
estado_pago VARCHAR(15) NOT NULL,
id_servicio INT(5) NOT NULL, 
folio_factura VARCHAR(50) NOT NULL,
FOREIGN KEY (no_orden_pago) REFERENCES orden_pago(no_orden_pago),
FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio),
FOREIGN KEY (folio_factura) REFERENCES factura(folio_factura)
)Engine=Innodb;

-- TABLA USUARIO

CREATE TABLE usuario(
id_usuario INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
nombre_usuario VARCHAR(60),
apatUsuario VARCHAR(60),
amatUsuario VARCHAR(60),
username VARCHAR(12),
password VARCHAR(15),
enabled INT(11)
)ENGINE=InnoDB;

-- TABLA ROLL USUARIO

CREATE TABLE rollusuario(
id_roll INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_usuario INT(11) DEFAULT NULL,
user_name VARCHAR(12) DEFAULT NULL,
roll VARCHAR(20) DEFAULT NULL,
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
)ENGINE=InnoDB;


-- _____________________________________________________________________________
-- REGISTROS DE USUARIOS
INSERT INTO usuario VALUES(
NULL,
'Ryuu',
'Eru',
'Lawliet',
'sixnore',
'password',
1
);

INSERT INTO usuario VALUES(
NULL,
'Daniel',
'Alias',
'Pigmeo',
'poortunic',
'password',
1
);

INSERT INTO usuario VALUES(
NULL,
'Victor',
'Alias',
'El inge',
'ingevictor',
'password',
1
);

INSERT INTO usuario VALUES(
NULL,
'Zero',
'Metralletas',
'Oscuras',
'zerometra',
'123456789',
1
);

INSERT INTO usuario VALUES(
NULL,
'Pau',
'Alias',
'Shade',
'shadeshade',
'password',
1
);

-- _____________________________________________________________________________
-- REGISTROS DE ROLL USUARIOS

INSERT INTO rollusuario VALUES(
NULL,
1,
'sixnore',
'Administrador'
);

INSERT INTO rollusuario VALUES(
NULL,
2,
'poortunic',
'Administrador'
);

INSERT INTO rollusuario VALUES(
NULL,
3,
'ingevictor',
'Capturista'
);

INSERT INTO rollusuario VALUES(
NULL,
4,
'zerometra',
'Administrador'
);

INSERT INTO rollusuario VALUES(
NULL,
5,
'paulashade',
'Secretaria'
);

-- ______________________________________________________________________________
-- REGISTROS DE

-- INSERCCION DATOS

insert into proveedor values(NULL,'MIGUEL ÁNGEL LÓPEZ MARTÍNEZ');

insert into proveedor values(NULL,'SANSPOWER S.A. DE C.V.');

insert into proveedor values(NULL,'OPERADORA CENTRAL DE ESTACIONAMIENTOS SAPI DE C.V.');

insert into proveedor values(NULL,'OPERADORA DE CENTROS DE ESPECTÁCULOS S.A. DE C.V.');

insert into proveedor values(NULL,'CIA. OPERADORA DE ESTACIONAMIENTOS MEXICANOS S.A. DE C.V.');

insert into proveedor values(NULL,'SERVICIOS DE PROTECCIÓN PRIVADA LOBO S.A. DE C.V.');

insert into proveedor values(NULL,'GOBIERNO DEL DISTRITO FEDERAL');

insert into proveedor values(NULL,'LIBERTAD SATÉLITE S.A. DE C.V.');

insert into proveedor values(NULL,'DISTRIBUIDORA DE HIELO S.A. DE C.V.');

insert into proveedor values(NULL,'MARDE ECOLOGY S.A DE C.V.');

insert into proveedor values(NULL,'MIGUEL ÁNGEL LÓPEZ MARTÍNEZ');
-- ______________________________________________________________________________

insert into servicio values(NULL,'SERVICIO DE PIPAS DE AGUA PARA BAÑOS',1);

insert into servicio values(NULL,'SERVICIO DE RENTA DE PLANTAS DE LUZ',2);

insert into servicio values(NULL,'SERVICIO DE VALET PARKING',3);

insert into servicio values(NULL,'SERVICIO A PALCOS',4);

insert into servicio values(NULL,'SERVICIO DE ESTACIONAMIENTOS',5);

insert into servicio values(NULL,'SERVICIO DE OPERADORES DE AUDIO',4);

insert into servicio values(NULL,'SERVICIO DE ANFITRIONES',4);

insert into servicio values(NULL,'SERVICIO DE TAQUILLEROS',4);

insert into servicio values(NULL,'SERVICIO DE BOLETEROS',4);

insert into servicio values(NULL,'SERVICIO DE SEGURIDAD PRIVADA',6);

insert into servicio values(NULL,'SERVICIO DE ACOMODADORES',4);

insert into servicio values(NULL,'SERVICIO DE A Y B.',4);

insert into servicio values(NULL,'SERVICIO DE SEGURIDAD Y VIGILANCIA',7);

insert into servicio values(NULL,'SERVICIO DE PROTECCION PRIVADA',6);

insert into servicio values(NULL,'SERVICIO DE PARTICIPACIÓN Y VENTA DE ABONO FREEDOM EN TEMPORADA DE CLAUSURA',8);

insert into servicio values(NULL,'SERVICIO DE COMPRA DE HIELO PARA PARTIDOS Y ENTRENAMIENTO',9);

insert into servicio values(NULL,'SERVICIO DE CONTENEDORES DE BASURA',10);
-- ______________________________________________________________________________

insert into factura values('12042017FAC1','2017-04-01','1ERA','EN ESPERA', null,3500.42,500.01,4000.43);


insert into factura values('12042018FAC1','2017-04-03','1ERA','ENTREGADA', null,4500.42,500.01,5000.43);


insert into factura values('12042019FAC1','2017-04-07','2DA','ENTREGADA', null ,2500.42,500.01,3000.43);


insert into factura values('12042020FAC1','2017-04-05','1ERA','EN ESPERA', null ,5500.42,500.01,6000.43);


insert into factura values('12042021FAC1','2017-04-10','2DA','ENTREGADA', null ,1500.42,500.01,2000.43);



-- ______________________________________________________________________________

insert into orden_pago values(null, 'C.P. Armando Mendoza Delgado', '2017-04-15', 'Estadio Azul', 'TRANSFERENCIA', 5000.00, 'CINCO MIL PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara');

insert into orden_pago values(null, 'C.P. Armando Mendoza Delgado', '2017-04-14', 'Estadio Azul', 'CHEQUE', 4500.00, 'CUATRO MIL QUINIENTOS PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara');

insert into orden_pago values(null, 'C.P. Armando Mendoza Delgado', '2017-04-15', 'Estadio Azul', 'TRANSFERENCIA', 5000.00, 'CINCO MIL PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara');

-- ______________________________________________________________________________

insert into pago values(null, 1, 'EN ESPERA', 10, '12042017FAC1');

insert into pago values(null, 2, 'EN ESPERA', 1, '12042021FAC1');

insert into pago values(null, 3, 'EN ESPERA', 5, '12042020FAC1');
