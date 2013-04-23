-- Generado por Oracle SQL Developer Data Modeler 3.1.4.710
--   en:        2013-04-22 09:41:49 CEST
--   sitio:      Oracle Database 10g
--   tipo:      Oracle Database 10g



CREATE TABLE ASIGNACION_FIJO 
    ( 
     fecha_asignacion DATE  NOT NULL , 
     fecha_fin DATE  NOT NULL , 
     dni VARCHAR(9)  NOT NULL , 
     codigo DECIMAL , 
     numero DECIMAL  NOT NULL , 
     codigo1 DECIMAL  NOT NULL ,
     PRIMARY KEY(dni,numero,codigo1)
    ) 
;



CREATE TABLE ASIGNACION_MOVIL 
    ( 
     fecha_asignacion DATE  NOT NULL , 
     fecha_fin DATE  NOT NULL , 
     dni VARCHAR(9)  NOT NULL , 
     codigo DECIMAL , 
     numero DECIMAL  NOT NULL , 
     codigo1 DECIMAL  NOT NULL ,
     PRIMARY KEY (dni,numero,codigo1)
    ) 
;


CREATE TABLE CATEGORIA 
    ( 
     codigo DECIMAL  NOT NULL , 
     descripcion VARCHAR(300) ,
     PRIMARY KEY(codigo)
    ) 
;


CREATE TABLE DIPUTACION 
    ( 
     codigo DECIMAL  NOT NULL , 
     direccion VARCHAR(300)  NOT NULL , 
     telefono VARCHAR(20) , 
     cod_postal DECIMAL , 
     ciudad VARCHAR(40)  NOT NULL ,
     PRIMARY KEY(codigo)
    ) 
;

CREATE TABLE GRUPO_RESCATE 
    ( 
     codigo DECIMAL  NOT NULL , 
     nombre VARCHAR(100)  NOT NULL ,
     PRIMARY KEY(codigo)
    ) 
;

CREATE TABLE LINEA 
    ( 
     numero DECIMAL  NOT NULL , 
     periodo_facturacion DATE , 
     publico CHAR (1) ,
     PRIMARY KEY(numero)
    ) 
;

CREATE TABLE LLAMADA 
    ( 
     numero_destino DECIMAL  NOT NULL , 
     tipo VARCHAR(40) , 
     duracion DECIMAL  NOT NULL , 
     coste DECIMAL  NOT NULL , 
     numero DECIMAL  NOT NULL ,
     PRIMARY KEY(numero)
    ) 
;

CREATE TABLE MUNICIPIO 
    (     
     provincia VARCHAR(60)  NOT NULL ,
     nombre VARCHAR(60)  NOT NULL , 
     PRIMARY KEY(provincia)
    ) 
;



CREATE TABLE PERFIL 
    ( 
     codigo DECIMAL  NOT NULL , 
     descripcion VARCHAR(300) , 
     saldo_limite DECIMAL ,
     PRIMARY KEY(codigo)
    ) 
;

CREATE TABLE PLAN_CONCERTACION 
    ( 
     codigo DECIMAL  NOT NULL , 
     fecha DATE  NOT NULL , 
     nombre VARCHAR(200)  NOT NULL , 
     descripcion VARCHAR(300)  NOT NULL , 
     precio DECIMAL , 
     codigo1 DECIMAL  NOT NULL , 
     nombre1 VARCHAR(200)  NOT NULL , 
     provincia VARCHAR(40)  NOT NULL ,
     PRIMARY KEY(codigo1,codigo,nombre1,provincia)
    ) 
;

CREATE TABLE RMA 
    ( 
     fecha_emision DATE  NOT NULL , 
     fecha_recepcion DATE , 
     detalle VARCHAR(200) , 
     codigo DECIMAL  NOT NULL ,
     PRIMARY KEY(codigo)
    ) 
;


CREATE TABLE TERMINAL 
    ( 
     codigo DECIMAL  NOT NULL , 
     fecha_alta DATE , 
     fecha_baja DATE , 
     marca VARCHAR(40) , 
     modelo VARCHAR(40) , 
     configuracion VARCHAR(200) , 
     sn DECIMAL  NOT NULL , 
     numero_interno DECIMAL , 
     pedido VARCHAR(400) , 
     product VARCHAR(200) ,
     PRIMARY KEY(codigo) 
    ) 
;



ALTER TABLE TERMINAL 
    ADD UNIQUE ( sn ) ;



CREATE TABLE USUARIO 
    ( 
     dni VARCHAR(9)  NOT NULL , 
     nombre VARCHAR(200)  NOT NULL , 
     apellidos VARCHAR(200)  NOT NULL , 
     email VARCHAR(50)  NOT NULL , 
     codigo DECIMAL  NOT NULL , 
     rol INT  NOT NULL , 
     codigo1 DECIMAL ,
     PRIMARY KEY(dni)
    ) 
;




ALTER TABLE USUARIO 
ADD FOREIGN KEY (codigo) REFERENCES GRUPO_RESCATE (codigo);


ALTER TABLE ASIGNACION_MOVIL 
ADD FOREIGN KEY (dni) REFERENCES USUARIO (dni);
    

ALTER TABLE ASIGNACION_MOVIL 
ADD FOREIGN KEY (codigo1) REFERENCES TERMINAL (codigo);


ALTER TABLE ASIGNACION_FIJO 
ADD FOREIGN KEY (numero) REFERENCES LINEA (numero);


ALTER TABLE ASIGNACION_MOVIL 
ADD FOREIGN KEY (numero) REFERENCES LINEA (numero);

ALTER TABLE ASIGNACION_MOVIL 
ADD FOREIGN KEY (codigo) REFERENCES PERFIL (codigo);

ALTER TABLE ASIGNACION_FIJO 
ADD FOREIGN KEY (codigo) REFERENCES CATEGORIA (codigo);


ALTER TABLE USUARIO 
ADD FOREIGN KEY (codigo1) REFERENCES DIPUTACION (codigo);


ALTER TABLE PLAN_CONCERTACION 
ADD FOREIGN KEY (codigo1) REFERENCES DIPUTACION (codigo);


ALTER TABLE PLAN_CONCERTACION 
ADD FOREIGN KEY (nombre1) REFERENCES MUNICIPIO (nombre),
ADD FOREIGN KEY (provincia) REFERENCES MUNICIPIO (provincia);

ALTER TABLE LLAMADA 
ADD FOREIGN KEY (numero) REFERENCES LINEA (numero);


ALTER TABLE RMA 
ADD FOREIGN KEY (codigo) REFERENCES TERMINAL (codigo);


ALTER TABLE ASIGNACION_FIJO 
ADD FOREIGN KEY (codigo1) REFERENCES TERMINAL (codigo);


ALTER TABLE ASIGNACION_FIJO 
ADD FOREIGN KEY (dni) REFERENCES USUARIO (dni); 



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            13
-- CREATE INDEX                             0
-- ALTER TABLE                             28
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE STRUCTURED TYPE                   0
-- CREATE COLLECTION TYPE                   0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
