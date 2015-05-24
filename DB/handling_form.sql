-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-05-2015 a las 14:41:02
-- Versión del servidor: 5.5.40-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `handling_form`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `COURSE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_NAME` varchar(30) DEFAULT NULL,
  `COURSE_CODE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COURSE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `course`
--

INSERT INTO `course` (`COURSE_ID`, `COURSE_NAME`, `COURSE_CODE`) VALUES
(1, 'Java 1', 'JAV1'),
(2, 'Math 300', 'MATH300'),
(3, 'Calculo 2', 'CAL2'),
(4, 'Geografia 56', 'GEO56'),
(5, 'Historia 2', 'HIS2'),
(6, 'Contabilidad 1', 'CON1'),
(7, 'Digitales 1', 'DIG1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(30) DEFAULT NULL,
  `LAST_NAME` varchar(30) DEFAULT NULL,
  `PHONE_HOME` varchar(20) DEFAULT NULL,
  `PHONE_MOBILE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`STUDENT_ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE_HOME`, `PHONE_MOBILE`) VALUES
(1, 'Gabriel', 'Vargas', '5103939921', '5103939921'),
(2, 'Patricia', 'Padilla', '5107788181', '5107788181'),
(3, 'Mike', 'Almada', '5101239921', '5101239921'),
(4, 'Maria', 'Ramirez', '5109849921', '5109849921'),
(5, 'Juan', 'Perez', '510-555-58-58', '510-551-5151'),
(6, 'Pedro', 'Lopez', '510-665-5858', '510-858-5151'),
(7, 'Jorge', 'Lopez', '848-665-5258', '848-852-5251'),
(8, 'Alejandro', 'Jimenez', '554-645-5858', '554-845-5151');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
