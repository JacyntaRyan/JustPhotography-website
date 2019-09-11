-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema JustPhotography
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema JustPhotography
-- -----------------------------------------------------
-- drop schema justphotography;
CREATE SCHEMA IF NOT EXISTS `JustPhotography` DEFAULT CHARACTER SET utf8 ;
USE `JustPhotography` ;

-- -----------------------------------------------------
-- Table `JustPhotography`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JustPhotography`.`Users` (
  `username` VARCHAR(255) NOT NULL,
  `First_Name` VARCHAR(100) NULL,
  `Last_Name` VARCHAR(100) NULL,
  `Phone` INT(10) NULL,
  `Address` VARCHAR(255) NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(30) NULL,
  `Confirm_Password` VARCHAR(30) NULL,
  `User_Type` ENUM ('admin', 'user') default 'user',
  PRIMARY KEY (`username`))
ENGINE = InnoDB;

insert into Users  values('stephen123','Stephen','treacy',5663748,'2 thurles','stephen@gmail.com','pass','pass','admin');
insert into Users  values('jacynta123','jacynta','Ryan',089263537,'33 thurles','jacynta@gmail.com','pass','pass','admin');
insert into Users  values('flower','John','Cahill',09663748,'2 glanmire Cork','Johng@gmail.com','pass','pass','user');



-- -----------------------------------------------------
-- Table `JustPhotography`.`Venue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JustPhotography`.`Venue` (
  `VenueID` INT NOT NULL AUTO_INCREMENT,
  `Address` VARCHAR(255) NULL,
  `Phone` INT(10) NULL,
  PRIMARY KEY (`VenueID`))
ENGINE = InnoDB;
insert into Venue values(1, 'Main Street Thurles', 0873190011);
insert into Venue values(2, 'LIT Tipperary, Thurles', 062390145);
insert into Venue values(3, 'LIT M, Thurles', 062390145);



-- -----------------------------------------------------
-- Table `JustPhotography`.`Events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JustPhotography`.`Events` (
  `EventID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NULL,
  `Date` DATE NULL,
  `Description` VARCHAR(255) NULL,
  `Price` DECIMAL(10,2) NULL,
  `VenueID` INT NOT NULL,
  PRIMARY KEY (`EventID`),
  INDEX `fk_Events_Venue_idx` (`VenueID` ASC),
  CONSTRAINT `fk_Events_Venue`
    FOREIGN KEY (`VenueID`)
    REFERENCES `JustPhotography`.`Venue` (`VenueID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Events (Name,Date,Description,Price,VenueID) values('Night Trek Through Dublin', '2019/04/29',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
 eiusmod tempor incididunt ut labore et dolore magna aliqua.
 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
 nisi ut aliquip ex ea commodo consequat.' ,12.00,1);
 insert into Events (Name,Date,Description,Price,VenueID) values ('Meet the wedding photographer', '2019/06/19',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
 eiusmod tempor incididunt ut labore et dolore magna aliqua.
 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
 nisi ut aliquip ex ea commodo consequat.' ,22.00,2);


-- -----------------------------------------------------
-- Table `JustPhotography`.`Classes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JustPhotography`.`Classes` (
  `ClassID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NULL,
  `StartDate` DATE NULL,
  `EndDate` DATE NULL,
  `Description` VARCHAR(255) NULL,
  `Price` DECIMAL(10,2) NULL,
  `VenueID` INT NOT NULL,
  PRIMARY KEY (`ClassID`),
  INDEX `fk_Classes_Venue1_idx` (`VenueID` ASC),
  CONSTRAINT `fk_Classes_Venue1`
    FOREIGN KEY (`VenueID`)
    REFERENCES `JustPhotography`.`Venue` (`VenueID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Classes values(1, 'Composition', '2019/06/14', '2019/07/14', 'Learn how to compose your shots', 29.99, 1);

insert into Classes values(2, 'Lighting', '2019/06/24', '2019/07/18', 'Learn how to use lighting to get the perfect shots', 15.50, 2);


-- -----------------------------------------------------
-- Table `JustPhotography`.`Competitions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JustPhotography`.`Competitions` (
  `CompetitionID` INT AUTO_INCREMENT,
  `Name` VARCHAR(255) NULL,
  `Date` DATE NULL,
  `Prize` DECIMAL(10,2) NULL,
  `Description` VARCHAR(255) NULL,
  `Winner` VARCHAR(255) NULL,
  PRIMARY KEY (`CompetitionID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
