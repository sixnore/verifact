-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-04-2017 a las 01:07:09
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.5.37

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
-- Estructura de tabla para la tabla `cheque`
--

CREATE TABLE `cheque` (
  `no_cheque` int(5) NOT NULL,
  `solicitud_cheque` char(1) DEFAULT NULL,
  `poliza` char(1) DEFAULT NULL,
  `id_pago` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `no_factura` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `quincena` char(7) NOT NULL,
  `estado` char(9) NOT NULL,
  `id_pago` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_pago` int(5) NOT NULL,
  `cheque` char(1) DEFAULT NULL,
  `id_servicio` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolusuario`
--

CREATE TABLE `rolusuario` (
  `idRol` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `username` varchar(12) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rolusuario`
--

INSERT INTO `rolusuario` (`idRol`, `idUsuario`, `username`, `rol`) VALUES
(1, 1, 'usuario1', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` int(5) NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `concepto` varchar(100) NOT NULL,
  `importe_num` float(8,2) NOT NULL,
  `importe_letra` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(60) DEFAULT NULL,
  `apatUsuario` varchar(60) DEFAULT NULL,
  `amatUsuario` varchar(60) DEFAULT NULL,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `apatUsuario`, `amatUsuario`, `username`, `password`, `enabled`) VALUES
(1, 'Daniel Alejandro		', 'Alfaro', 'Quintanar', 'sixnore', '36112710', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cheque`
--
ALTER TABLE `cheque`
  ADD PRIMARY KEY (`no_cheque`),
  ADD KEY `id_pago` (`id_pago`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`no_factura`),
  ADD KEY `id_pago` (`id_pago`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `id_servicio` (`id_servicio`);

--
-- Indices de la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  ADD PRIMARY KEY (`idRol`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cheque`
--
ALTER TABLE `cheque`
  MODIFY `no_cheque` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cheque`
--
ALTER TABLE `cheque`
  ADD CONSTRAINT `cheque_ibfk_1` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`);

--
-- Filtros para la tabla `rolusuario`
--
ALTER TABLE `rolusuario`
  ADD CONSTRAINT `rolusuario_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
