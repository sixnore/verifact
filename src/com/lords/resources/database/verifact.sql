-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-04-2017 a las 04:51:35
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `verifact`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estatus`
--

CREATE TABLE `estatus` (
  `enabled` int(11) NOT NULL,
  `estatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estatus`
--

INSERT INTO `estatus` (`enabled`, `estatus`) VALUES
(0, 'Inactivo'),
(1, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `folio_factura` varchar(50) NOT NULL,
  `fecha_recep` date NOT NULL,
  `quincena` char(7) NOT NULL,
  `estado_factura` char(9) NOT NULL,
  `factura_img` varchar(100) DEFAULT NULL,
  `subtotal` float(8,2) NOT NULL,
  `iva` float(8,2) NOT NULL,
  `total` float(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`folio_factura`, `fecha_recep`, `quincena`, `estado_factura`, `factura_img`, `subtotal`, `iva`, `total`) VALUES
('12042017FAC1', '2017-04-01', '1ERA', 'EN ESPERA', NULL, 3500.42, 500.01, 4000.43),
('12042018FAC1', '2017-04-03', '1ERA', 'ENTREGADA', NULL, 4500.42, 500.01, 5000.43),
('12042019FAC1', '2017-04-07', '2DA', 'ENTREGADA', NULL, 2500.42, 500.01, 3000.43),
('12042020FAC1', '2017-04-05', '1ERA', 'EN ESPERA', NULL, 5500.42, 500.01, 6000.43),
('12042021FAC1', '2017-04-10', '2DA', 'ENTREGADA', NULL, 1500.42, 500.01, 2000.43);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_pago`
--

CREATE TABLE `orden_pago` (
  `no_orden_pago` int(5) NOT NULL,
  `solicitante` varchar(50) DEFAULT 'C.P. Armando Mendoza Delgado',
  `fecha_orden` date NOT NULL,
  `departamento` varchar(50) DEFAULT 'Estadio Azul',
  `tipo_pago` varchar(15) NOT NULL,
  `importe_numero` float(8,2) NOT NULL,
  `importe_letra` varchar(50) NOT NULL,
  `aplic_contable` varchar(80) NOT NULL,
  `gerente_area` varchar(30) DEFAULT 'Lic. Pedro Ruiz Isunza',
  `direccion_area` varchar(30) DEFAULT 'C.P. Isaac Velasco Alcantara'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `orden_pago`
--

INSERT INTO `orden_pago` (`no_orden_pago`, `solicitante`, `fecha_orden`, `departamento`, `tipo_pago`, `importe_numero`, `importe_letra`, `aplic_contable`, `gerente_area`, `direccion_area`) VALUES
(1, 'C.P. Armando Mendoza Delgado', '2017-04-15', 'Estadio Azul', 'TRANSFERENCIA', 5000.00, 'CINCO MIL PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara'),
(2, 'C.P. Armando Mendoza Delgado', '2017-04-14', 'Estadio Azul', 'CHEQUE', 4500.00, 'CUATRO MIL QUINIENTOS PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara'),
(3, 'C.P. Armando Mendoza Delgado', '2017-04-15', 'Estadio Azul', 'TRANSFERENCIA', 5000.00, 'CINCO MIL PESOS MEXICANOS', 'SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO', 'Lic. Pedro Ruiz Isunza', 'C.P. Isaac Velasco Alcantara');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_pago` int(5) NOT NULL,
  `no_orden_pago` int(5) NOT NULL,
  `estado_pago` varchar(15) NOT NULL,
  `id_servicio` int(5) NOT NULL,
  `folio_factura` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_pago`, `no_orden_pago`, `estado_pago`, `id_servicio`, `folio_factura`) VALUES
(1, 1, 'EN ESPERA', 10, '12042017FAC1'),
(2, 2, 'EN ESPERA', 1, '12042021FAC1'),
(3, 3, 'EN ESPERA', 5, '12042020FAC1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(5) NOT NULL,
  `proveedor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `proveedor`) VALUES
(1, 'MIGUEL ?NGEL L?PEZ MART?NEZ'),
(2, 'SANSPOWER S.A. DE C.V.'),
(3, 'OPERADORA CENTRAL DE ESTACIONAMIENTOS SAPI DE C.V.'),
(4, 'OPERADORA DE CENTROS DE ESPECT?CULOS S.A. DE C.V.'),
(5, 'CIA. OPERADORA DE ESTACIONAMIENTOS MEXICANOS S.A. DE C.V.'),
(6, 'SERVICIOS DE PROTECCI?N PRIVADA LOBO S.A. DE C.V.'),
(7, 'GOBIERNO DEL DISTRITO FEDERAL'),
(8, 'LIBERTAD SAT?LITE S.A. DE C.V.'),
(9, 'DISTRIBUIDORA DE HIELO S.A. DE C.V.'),
(10, 'MARDE ECOLOGY S.A DE C.V.'),
(11, 'MIGUEL ?NGEL L?PEZ MART?NEZ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rollusuario`
--

CREATE TABLE `rollusuario` (
  `id_roll` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `user_name` varchar(12) DEFAULT NULL,
  `roll` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rollusuario`
--

INSERT INTO `rollusuario` (`id_roll`, `id_usuario`, `user_name`, `roll`) VALUES
(1, 1, 'sixnore', 'Administrador'),
(2, 2, 'poortunic', 'Administrador'),
(3, 3, 'ingevictor', 'Capturista'),
(4, 4, 'zerometra', 'Administrador'),
(5, 5, 'paulashade', 'Secretaria'),
(6, 6, 'asdas', 'Administrador'),
(7, 7, 'asdasd', 'Capturista'),
(8, 8, 'iori', 'Administrador'),
(9, 9, 'rugal', 'Secretaria'),
(10, 12, 'asdasdasdas', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` int(5) NOT NULL,
  `servicio` varchar(100) NOT NULL,
  `id_proveedor` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_servicio`, `servicio`, `id_proveedor`) VALUES
(1, 'SERVICIO DE PIPAS DE AGUA PARA BA?OS', 1),
(2, 'SERVICIO DE RENTA DE PLANTAS DE LUZ', 2),
(3, 'SERVICIO DE VALET PARKING', 3),
(4, 'SERVICIO A PALCOS', 4),
(5, 'SERVICIO DE ESTACIONAMIENTOS', 5),
(6, 'SERVICIO DE OPERADORES DE AUDIO', 4),
(7, 'SERVICIO DE ANFITRIONES', 4),
(8, 'SERVICIO DE TAQUILLEROS', 4),
(9, 'SERVICIO DE BOLETEROS', 4),
(10, 'SERVICIO DE SEGURIDAD PRIVADA', 6),
(11, 'SERVICIO DE ACOMODADORES', 4),
(12, 'SERVICIO DE A Y B.', 4),
(13, 'SERVICIO DE SEGURIDAD Y VIGILANCIA', 7),
(14, 'SERVICIO DE PROTECCION PRIVADA', 6),
(15, 'SERVICIO DE PARTICIPACI?N Y VENTA DE ABONO FREEDOM EN TEMPORADA DE CLAUSURA', 8),
(16, 'SERVICIO DE COMPRA DE HIELO PARA PARTIDOS Y ENTRENAMIENTO', 9),
(17, 'SERVICIO DE CONTENEDORES DE BASURA', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(60) DEFAULT NULL,
  `apatUsuario` varchar(60) DEFAULT NULL,
  `amatUsuario` varchar(60) DEFAULT NULL,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `apatUsuario`, `amatUsuario`, `username`, `password`, `enabled`) VALUES
(1, 'Ryuu', 'Eru', 'Lawliet', 'sixnore', 'password', 1),
(2, 'Daniel', 'Alias', 'Pigmeo', 'poortunic', 'password', 0),
(3, 'Victor', 'Alias', 'El inge', 'ingevictor', 'password', 1),
(4, 'Zero', 'Metralletas', 'Oscuras', 'zerometra', '123456789', 1),
(5, 'Pau', 'Alias', 'Shade', 'shadeshade', 'password', 1),
(6, 'asdas', 'asdas', 'asdas', 'asdas', 'asdas', 1),
(7, 'Usuario', 'sdasd', 'asdas', 'asdasd', 'asdasd', 1),
(8, 'Daniel', 'Alejandro', 'Alfaro', 'iori', 'asdasd', 1),
(9, 'Dano', 'Alexander', 'Alfaro', 'rugal', '12345678', 1),
(12, 'asdas', 'asdas', 'asdas', 'asdasdasdas', 'asdasd', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estatus`
--
ALTER TABLE `estatus`
  ADD PRIMARY KEY (`enabled`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`folio_factura`);

--
-- Indices de la tabla `orden_pago`
--
ALTER TABLE `orden_pago`
  ADD PRIMARY KEY (`no_orden_pago`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `no_orden_pago` (`no_orden_pago`),
  ADD KEY `id_servicio` (`id_servicio`),
  ADD KEY `folio_factura` (`folio_factura`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `rollusuario`
--
ALTER TABLE `rollusuario`
  ADD PRIMARY KEY (`id_roll`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `enabled` (`enabled`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `orden_pago`
--
ALTER TABLE `orden_pago`
  MODIFY `no_orden_pago` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `rollusuario`
--
ALTER TABLE `rollusuario`
  MODIFY `id_roll` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`no_orden_pago`) REFERENCES `orden_pago` (`no_orden_pago`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`),
  ADD CONSTRAINT `pago_ibfk_3` FOREIGN KEY (`folio_factura`) REFERENCES `factura` (`folio_factura`);

--
-- Filtros para la tabla `rollusuario`
--
ALTER TABLE `rollusuario`
  ADD CONSTRAINT `rollusuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`enabled`) REFERENCES `estatus` (`enabled`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
