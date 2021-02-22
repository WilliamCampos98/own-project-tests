package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Administrador;

public interface AdminDao {
	
	public Administrador save(Administrador admin);

	public List<Administrador> findAll();

	public Administrador findById(int id);
	
	public Administrador update(Administrador admin);
	
	public void delete(int id);

	public List<Administrador> findByNombre(String nombre);
	
//	-- -----------------------------------------------------
//	-- Schema testbd
//	-- -----------------------------------------------------
//	CREATE SCHEMA IF NOT EXISTS `testbd` DEFAULT CHARACTER SET utf8 ;
//	USE `testbd` ;
//
//	-- -----------------------------------------------------
//	-- Table `testbd`.`Admin`
//	-- -----------------------------------------------------
//	CREATE TABLE IF NOT EXISTS `testbd`.`Administrador` (
//	    `idAd` INT NOT NULL AUTO_INCREMENT,
//	    `nombre` VARCHAR(80) NOT NULL,
//	    `cargo` VARCHAR(45) NOT NULL,
//	    `fechaCreacion` DATETIME NOT NULL,
//	    PRIMARY KEY (`idAd`)
//	)  ENGINE=INNODB;
//
//	CREATE TABLE IF NOT EXISTS `testbd`.`admin` (
//	    `idAd` INT NOT NULL AUTO_INCREMENT,
//	    `nombre` VARCHAR(80) NOT NULL,
//	    `cargo` VARCHAR(45) NOT NULL,
//	    `fechaCreacion` DATETIME NOT NULL,
//	    PRIMARY KEY (`idAd`)
//	)  ENGINE=INNODB;
//
//
//	-- -----------------------------------------------------
//	-- Table `testbd`.`Direccion`
//	-- -----------------------------------------------------
//	CREATE TABLE IF NOT EXISTS `testbd`.`Direccion` (
//	  `idDir` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
//	  `calle` VARCHAR(45) NOT NULL,
//	  `cp` VARCHAR(45) NOT NULL,
//	  `idAd` INT(4) NOT NULL,
//	  foreign key (idad) references administrador(idAd))ENGINE = InnoDB;
//	  use testbd;
//	  insert into administrador value(null,'xd','lol','2019-08-31 09:14:34');
}
