---para ejecutar este archivo desde consola escriba
-- psql - U user_name -d data_base_name -h host_name -f archivo.sql
------------------------------------------------------------------------------
DROP TABLE IF EXISTS rutas;
CREATE TABLE rutas (
    codigo VARCHAR(12) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50)  NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS buses;
CREATE TABLE buses (
    placa VARCHAR(12) NOT NULL PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50),
    tipo VARCHAR(50),
    capacidad VARCHAR(20),
    rutaBus VARCHAR(50),
    FOREIGN KEY (rutaBus) REFERENCES rutas (codigo)
);

DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    numero VARCHAR(12) NOT NULL ,
    identificacion VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    fecha VARCHAR(30) NOT NULL,
    saldo FLOAT NOT NULL
    
);

DROP TABLE IF EXISTS descuentos;
CREATE TABLE descuentos (
    identificacionUsuario VARCHAR(20) NOT NULL,
    FechaDescuento VARCHAR(50) NOT NULL PRIMARY KEY,
    valorDescuento VARCHAR(50),
    FOREIGN KEY (identificacionUsuario) REFERENCES usuarios (identificacion)
);

DROP TABLE IF EXISTS recargas;
CREATE TABLE recargas (
    identificacionUsuario VARCHAR(20) NOT NULL,
    FechaRecarga VARCHAR(50) NOT NULL PRIMARY KEY,
    valorRecarga VARCHAR(50),
    FOREIGN KEY (identificacionUsuario) REFERENCES usuarios (identificacion)
);
