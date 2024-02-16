DROP DATABASE IF EXISTS banco;
CREATE DATABASE IF NOT EXISTS banco;
USE banco;

CREATE TABLE IF NOT EXISTS  Clientes(
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(30) NOT NULL,
    contraseña VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    domicilio varchar(200)NOT NULL,
    nombre VARCHAR(150) GENERATED ALWAYS AS (CONCAT(nombres, ' ', apellido_paterno, ' ', apellido_materno)) STORED,
    edad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Cuentas(
	id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
    numero_cuenta INT NOT NULL UNIQUE,
    estado enum('Activa','Cancelada') NOT NULL,
    fecha_apertura DATE NOT NULL,
	saldo float(10.2) NOT NULL,
    id_cliente int not null,
	FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE IF NOT EXISTS Operaciones(
	id_operacion INT PRIMARY KEY AUTO_INCREMENT,
    tipo enum('Retiro','Transferencia') NOT NULL,
    fecha_hora datetime NOT NULL,
    monto float(10.2) NOT NULL,
    id_cuenta int NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES Cuentas(id_cuenta)
);

CREATE TABLE IF NOT EXISTS Retiros(
	id_operacion int PRIMARY KEY,
    folio int NOT NULL,
    contraseña int NOT NULL,
    fecha_hora_limita datetime NOT NULL,
    estado enum('Activo','Inactivo') not null,
    FOREIGN KEY (id_operacion) REFERENCES Operaciones(id_operacion)

);