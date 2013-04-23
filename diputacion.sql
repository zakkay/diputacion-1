SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`LINEA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`LINEA` (
  `numero` DECIMAL NOT NULL ,
  `periodo_facturacion` DATE NULL DEFAULT NULL ,
  `publico` CHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`numero`) );


-- -----------------------------------------------------
-- Table `mydb`.`CATEGORIA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`CATEGORIA` (
  `codigo` DECIMAL NOT NULL ,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) );


-- -----------------------------------------------------
-- Table `mydb`.`TERMINAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`TERMINAL` (
  `codigo` DECIMAL NOT NULL ,
  `fecha_alta` DATE NULL DEFAULT NULL ,
  `fecha_baja` DATE NULL DEFAULT NULL ,
  `marca` VARCHAR(40) NULL DEFAULT NULL ,
  `modelo` VARCHAR(40) NULL DEFAULT NULL ,
  `configuracion` VARCHAR(200) NULL DEFAULT NULL ,
  `sn` DECIMAL NOT NULL ,
  `numero_interno` DECIMAL NULL DEFAULT NULL ,
  `pedido` VARCHAR(400) NULL DEFAULT NULL ,
  `product` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) ,
  UNIQUE INDEX (`sn` ASC) ,
  UNIQUE INDEX (`sn` ASC) );


-- -----------------------------------------------------
-- Table `mydb`.`GRUPO_RESCATE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`GRUPO_RESCATE` (
  `codigo` DECIMAL NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`codigo`) );


-- -----------------------------------------------------
-- Table `mydb`.`DIPUTACION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`DIPUTACION` (
  `codigo` DECIMAL NOT NULL ,
  `direccion` VARCHAR(300) NOT NULL ,
  `telefono` VARCHAR(20) NULL DEFAULT NULL ,
  `cod_postal` DECIMAL NULL DEFAULT NULL ,
  `ciudad` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`codigo`) );


-- -----------------------------------------------------
-- Table `mydb`.`ROLES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ROLES` (
  `codigo` INT NOT NULL ,
  `tipo` VARCHAR(45) NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`USUARIO` (
  `dni` VARCHAR(9) NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  `apellidos` VARCHAR(200) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `codigo` DECIMAL NOT NULL ,
  `rol` INT NOT NULL ,
  `codigo1` DECIMAL NULL DEFAULT NULL ,
  PRIMARY KEY (`dni`) ,
  INDEX `fk_9CFA7928-7362-48F4-8DCA-109E06768401` (`codigo` ASC) ,
  INDEX `fk_E4F5117A-7DF2-47F6-83F0-36378FDD65C1` (`codigo1` ASC) ,
  INDEX `fk_USUARIO_ROLES1` (`rol` ASC) ,
  CONSTRAINT `fk_9CFA7928-7362-48F4-8DCA-109E06768401`
    FOREIGN KEY (`codigo` )
    REFERENCES `mydb`.`GRUPO_RESCATE` (`codigo` ),
  CONSTRAINT `fk_E4F5117A-7DF2-47F6-83F0-36378FDD65C1`
    FOREIGN KEY (`codigo1` )
    REFERENCES `mydb`.`DIPUTACION` (`codigo` ),
  CONSTRAINT `fk_USUARIO_ROLES1`
    FOREIGN KEY (`rol` )
    REFERENCES `mydb`.`ROLES` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`ASIGNACION_FIJO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ASIGNACION_FIJO` (
  `fecha_asignacion` DATE NOT NULL ,
  `fecha_fin` DATE NOT NULL ,
  `dni` VARCHAR(9) NOT NULL ,
  `codigo` DECIMAL NULL DEFAULT NULL ,
  `numero` DECIMAL NOT NULL ,
  `codigo1` DECIMAL NOT NULL ,
  PRIMARY KEY (`dni`, `numero`, `codigo1`) ,
  CONSTRAINT `fk_06E77907-E6D8-4570-8F31-0A4910C9AF01`
    FOREIGN KEY (`numero` )
    REFERENCES `mydb`.`LINEA` (`numero` ),
  CONSTRAINT `fk_70807A7D-9571-4E2B-94B8-1A33EF4E5464`
    FOREIGN KEY (`codigo` )
    REFERENCES `mydb`.`CATEGORIA` (`codigo` ),
  CONSTRAINT `fk_F8AE2F64-6F8A-4A5A-97F2-48A4DE1423AA`
    FOREIGN KEY (`codigo1` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ),
  CONSTRAINT `fk_284804E8-3D3C-4AC1-B5EC-98B567F7ED9B`
    FOREIGN KEY (`dni` )
    REFERENCES `mydb`.`USUARIO` (`dni` ));


-- -----------------------------------------------------
-- Table `mydb`.`PERFIL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`PERFIL` (
  `codigo` DECIMAL NOT NULL ,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL ,
  `saldo_limite` DECIMAL NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) );


-- -----------------------------------------------------
-- Table `mydb`.`ASIGNACION_MOVIL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ASIGNACION_MOVIL` (
  `fecha_asignacion` DATE NOT NULL ,
  `fecha_fin` DATE NOT NULL ,
  `dni` VARCHAR(9) NOT NULL ,
  `codigo` DECIMAL NULL DEFAULT NULL ,
  `numero` DECIMAL NOT NULL ,
  `codigo1` DECIMAL NOT NULL ,
  PRIMARY KEY (`dni`, `numero`, `codigo1`) ,
  CONSTRAINT `fk_A7DD52BF-5999-432F-8C6D-3FAF36AEF601`
    FOREIGN KEY (`codigo` )
    REFERENCES `mydb`.`PERFIL` (`codigo` ),
  CONSTRAINT `fk_ABFE6D03-941A-464D-8C06-476D4AED081D`
    FOREIGN KEY (`dni` )
    REFERENCES `mydb`.`USUARIO` (`dni` ),
  CONSTRAINT `fk_FAF55427-DE51-4BC3-978A-DAC15B73893F`
    FOREIGN KEY (`codigo1` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ),
  CONSTRAINT `fk_37EFF3E8-EB5A-482B-880E-0A12D8214335`
    FOREIGN KEY (`numero` )
    REFERENCES `mydb`.`LINEA` (`numero` ));


-- -----------------------------------------------------
-- Table `mydb`.`LLAMADA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`LLAMADA` (
  `numero_destino` DECIMAL NOT NULL ,
  `tipo` VARCHAR(40) NULL DEFAULT NULL ,
  `duracion` DECIMAL NOT NULL ,
  `coste` DECIMAL NOT NULL ,
  `numero` DECIMAL NOT NULL ,
  PRIMARY KEY (`numero`) ,
  CONSTRAINT `fk_9228D15F-0E19-43D3-99FC-EDCF2EBC67C3`
    FOREIGN KEY (`numero` )
    REFERENCES `mydb`.`LINEA` (`numero` ));


-- -----------------------------------------------------
-- Table `mydb`.`MUNICIPIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`MUNICIPIO` (
  `provincia` VARCHAR(40) NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`provincia`,`nombre`) );

-- -----------------------------------------------------
-- Table `mydb`.`PLAN_CONCERTACION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`PLAN_CONCERTACION` (
  `codigo` DECIMAL NOT NULL ,
  `fecha` DATE NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  `descripcion` VARCHAR(300) NOT NULL ,
  `precio` DECIMAL NULL DEFAULT NULL ,
  `codigo1` DECIMAL NOT NULL ,
  `nombre1` VARCHAR(200) NOT NULL ,
  `provincia` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`codigo1`, `codigo`, `nombre1`, `provincia`) ,
  INDEX `fk_6746455C-5879-4FDE-8885-740D68B1BCFF` (`provincia` ASC) ,
  CONSTRAINT `fk_1DE59C0E-CB27-4262-9E33-0049DB9827CC`
    FOREIGN KEY (`codigo1` )
    REFERENCES `mydb`.`DIPUTACION` (`codigo` ),
  CONSTRAINT `fk_nombre_provincia_municipio`
    FOREIGN KEY (`provincia`,`nombre1` )
    REFERENCES `mydb`.`MUNICIPIO` (`provincia`,`nombre` ));

-- -----------------------------------------------------
-- Table `mydb`.`RMA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`RMA` (
  `fecha_emision` DATE NOT NULL ,
  `fecha_recepcion` DATE NULL DEFAULT NULL ,
  `detalle` VARCHAR(200) NULL DEFAULT NULL ,
  `codigo` DECIMAL NOT NULL ,
  PRIMARY KEY (`codigo`) ,
  CONSTRAINT `fk_D666DF7E-0898-441C-A18B-7ADA93B4080D`
    FOREIGN KEY (`codigo` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ));



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
