SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2_test` DEFAULT CHARACTER SET utf8;

USE `java2_test`;

DROP TABLE IF EXISTS `java2_test`.`users`;
-- -----------------------------------------------------
-- Table `java2_test`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java2_test`.`users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `Password` CHAR(32) NOT NULL,
  `Name` CHAR(32),
  `LastName` CHAR(32),
  `NickName` CHAR(32) NOT NULL,
  `Email` CHAR(32) NOT NULL,
  `Age` INT(11),
  `City` CHAR(32) NOT NULL,
  `Country` CHAR(32) NOT NULL,
  `UserTag` CHAR(32),
  `Reviews` CHAR(32),
  `Routes` CHAR(32),
  PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

-- -----------------------------------------------------
-- Table `java2_test`.`places;`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java2_test`.`places`;

CREATE TABLE IF NOT EXISTS `java2_test`.`places` (
  `PlaceID` INT(11) NOT NULL AUTO_INCREMENT,
  `Latitude` DOUBLE,
  `Longitude` DOUBLE,
  `City` CHAR(32) NOT NULL,
  `Country` CHAR(32) NOT NULL,
  `ImageURL` CHAR(32),
  `PlaceName` CHAR(32) NOT NULL,
  `PlaceAddress` CHAR(32) NOT NULL,
  PRIMARY KEY (`PlaceID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 2002;

-- -----------------------------------------------------
-- Table `java2_test`.`routes`
-- -----------------------------------------------------
# DROP TABLE IF EXISTS `java2_test`.`routes`;
#
# CREATE TABLE IF NOT EXISTS `java2_test`.`routes` (
#   `RouteID` INT(11) NOT NULL AUTO_INCREMENT,
#   `RouteTag` CHAR(32),
# # Missing place lists
#   PRIMARY KEY (`RouteID`)
# )
# ENGINE = InnoDB
# AUTO_INCREMENT = 3002;

-- -----------------------------------------------------
-- Table `java2_test`.`reviews`
-- -----------------------------------------------------
# DROP TABLE IF EXISTS `java2_test`.`reviews`;
# CREATE TABLE IF NOT EXISTS `java2_test`.`reviews` (
#   `ReviewID` INT(11) NOT NULL AUTO_INCREMENT,
#   PRIMARY KEY (`ReviewID`)
# )
# ENGINE = InnoDB
# AUTO_INCREMENT = 4002;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;