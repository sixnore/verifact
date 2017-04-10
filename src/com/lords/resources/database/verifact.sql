-- CREACIÓN DE LA BASE DE DATOS

CREATE DATABASE lines01 CHARACTER SET 'UTF8';
USE lines01;

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
importe_num FLOAT(8,2) NOT NULL,
id_proveedor INT(5),
FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
)Engine=Innodb;

-- TABLA PAGO

CREATE TABLE pago(
id_pago INT(5) PRIMARY KEY AUTO_INCREMENT NOT NULL,
folio_cheque INT(5),
status_pago VARCHAR(15),
subtotal FLOAT(8,2),
iva FLOAT(8,2),
total FLOAT(8,2),
metodo_pago VARCHAR(15),
id_servicio INT(5) NOT NULL, 
FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
)Engine=Innodb;

-- TABLA FACTURA

CREATE TABLE factura(
folio_factura VARCHAR(50) PRIMARY KEY NOT NULL,
fecha_recep DATE NOT NULL,
quincena CHAR(7) NOT NULL,
estado CHAR(9) NOT NULL,
factura_img VARCHAR(100),
id_pago INT(5) NOT NULL,
FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
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
