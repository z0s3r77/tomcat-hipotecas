-- Crear la base de datos "administracion"
CREATE DATABASE IF NOT EXISTS administracion;

-- Utilizar la base de datos "administracion"
USE administracion;

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        email VARCHAR(255) UNIQUE NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
    );

-- Insertar datos iniciales de usuario 1
INSERT INTO usuarios (nombre, email, password) VALUES ('Juan Pérez', 'usuario1@example.com', 'usuario1');

-- Crear la tabla de préstamos
CREATE TABLE IF NOT EXISTS prestamos (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         capital DOUBLE,
                                         interes DOUBLE,
                                         frecuenciaDePagoEnMeses INT,
                                         plazoDeAmortizacionEnMeses INT,
                                         tipoDePrestamo VARCHAR(255),
    usuario_id INT,
    fecha_creacion DATE,  -- Nueva columna fecha_creacion de tipo DATE
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
    );
