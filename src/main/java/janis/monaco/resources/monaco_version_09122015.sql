SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `monaco` ;
CREATE SCHEMA IF NOT EXISTS `monaco` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
USE `monaco` ;

-- -----------------------------------------------------
-- Table `monaco`.`TAGS_REF`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`TAGS_REF` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`TAGS_REF` (
  `TAG_NAME_ID` INT NOT NULL AUTO_INCREMENT,
  `TAG_NAME` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `I_TR_TAG_NAME_ID_UNIQUE` (`TAG_NAME_ID` ASC),
  PRIMARY KEY (`TAG_NAME_ID`),
  UNIQUE INDEX `I_TR_TAG_NAME_UNIQUE` (`TAG_NAME` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`COUNTRY_REF`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`COUNTRY_REF` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`COUNTRY_REF` (
  `COUNTRY_NAME_ID` INT NOT NULL AUTO_INCREMENT,
  `COUNTRY_NAME` VARCHAR(100) NOT NULL,
  `COUNTRY_SHORT_NAME` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `I_COREF_CITY_NAME_ID_UNIQUE` (`COUNTRY_NAME_ID` ASC),
  PRIMARY KEY (`COUNTRY_NAME_ID`),
  UNIQUE INDEX `I_COREF_COUNTRY_NAME_UNIQUE` (`COUNTRY_NAME` ASC),
  UNIQUE INDEX `I_COUNTRY_SHORT_NAME_UNIQUE` (`COUNTRY_SHORT_NAME` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`CITY_REF`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`CITY_REF` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`CITY_REF` (
  `CITY_NAME_ID` INT NOT NULL AUTO_INCREMENT,
  `CITY_NAME` VARCHAR(45) NOT NULL,
  `CITY_COUNTRY_ID` INT NOT NULL,
  UNIQUE INDEX `I_CIREF_CITY_NAME_ID_UNIQUE` (`CITY_NAME_ID` ASC),
  PRIMARY KEY (`CITY_NAME_ID`),
  INDEX `FK_CITYREF_CountryID_idx` (`CITY_COUNTRY_ID` ASC),
  CONSTRAINT `FK_CITYREF_CountryID`
    FOREIGN KEY (`CITY_COUNTRY_ID`)
    REFERENCES `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`USER` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`USER` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(100) NOT NULL,
  `age` INT NULL,
  `cityID` INT NOT NULL,
  `countryID` INT NOT NULL,
  `userTagID` INT NULL,
  `userPass` VARCHAR(16) NOT NULL,
  `creationDate` DATETIME NULL,
  UNIQUE INDEX `I_U_userID_UNIQUE` (`userID` ASC),
  PRIMARY KEY (`userID`),
  INDEX `I_U_userTagID_idx` (`userTagID` ASC),
  INDEX `I_U_cityID_idx` (`cityID` ASC),
  INDEX `I_U_countryID_idx` (`countryID` ASC),
  UNIQUE INDEX `I_U_nickname_UNIQUE` (`nickname` ASC),
  CONSTRAINT `FK_U_userTagID`
    FOREIGN KEY (`userTagID`)
    REFERENCES `monaco`.`TAGS_REF` (`TAG_NAME_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_U_cityID`
    FOREIGN KEY (`cityID`)
    REFERENCES `monaco`.`CITY_REF` (`CITY_NAME_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_U_countryID`
    FOREIGN KEY (`countryID`)
    REFERENCES `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`PLACE_TYPE_REF`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`PLACE_TYPE_REF` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`PLACE_TYPE_REF` (
  `PLACE_TYPE_ID` INT NOT NULL AUTO_INCREMENT,
  `PLACE_TYPE` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`PLACE_TYPE_ID`),
  UNIQUE INDEX `I_PTREF_PLACE_TYPE_ID_UNIQUE` (`PLACE_TYPE_ID` ASC),
  UNIQUE INDEX `I_PTREF_PLACE_TYPE_UNIQUE` (`PLACE_TYPE` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`ROUTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`ROUTE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`ROUTE` (
  `routeID` INT NOT NULL AUTO_INCREMENT,
  `distance` VARCHAR(45) NOT NULL,
  `completionTime` VARCHAR(45) NOT NULL,
  `routeTagID` INT NOT NULL,
  `creationDate` DATETIME NULL,
  `creatorID` INT NOT NULL,
  UNIQUE INDEX `I_ROUTE_routeID_UNIQUE` (`routeID` ASC),
  PRIMARY KEY (`routeID`),
  INDEX `I_ROUTE_routeTagId_idx` (`routeTagID` ASC),
  INDEX `I_ROUTE_creatorID_idx` (`creatorID` ASC),
  CONSTRAINT `FK_ROUTE_routeTagId`
    FOREIGN KEY (`routeTagID`)
    REFERENCES `monaco`.`TAGS_REF` (`TAG_NAME_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROUTE_creatorID`
    FOREIGN KEY (`creatorID`)
    REFERENCES `monaco`.`USER` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`PLACE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`PLACE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`PLACE` (
  `placeID` INT NOT NULL AUTO_INCREMENT,
  `latitude` DOUBLE NOT NULL,
  `longitude` DOUBLE NOT NULL,
  `imageURL` VARCHAR(100) NULL,
  `placeName` VARCHAR(100) NULL,
  `placeAddress` VARCHAR(100) NULL,
  `placeTypeID` INT NULL,
  UNIQUE INDEX `I_P_placeID_UNIQUE` (`placeID` ASC),
  PRIMARY KEY (`placeID`),
  INDEX `I_P_placeTypeID_idx` (`placeTypeID` ASC),
  CONSTRAINT `FK_P_PLACE_placeTypeID`
    FOREIGN KEY (`placeTypeID`)
    REFERENCES `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`PLACES_IN_ROUTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`PLACES_IN_ROUTE` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`PLACES_IN_ROUTE` (
  `routeID` INT NOT NULL,
  `SEQNR` INT NOT NULL,
  `placeID` INT NOT NULL,
  INDEX `I_PIR_routeID_idx` (`routeID` ASC),
  INDEX `I_PIR_placeID_idx` (`placeID` ASC),
  CONSTRAINT `FK_PIR_routeID`
    FOREIGN KEY (`routeID`)
    REFERENCES `monaco`.`ROUTE` (`routeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PIR_placeID`
    FOREIGN KEY (`placeID`)
    REFERENCES `monaco`.`PLACE` (`placeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`REVIEW`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`REVIEW` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`REVIEW` (
  `reviewID` INT NOT NULL AUTO_INCREMENT,
  `creatorID` INT NOT NULL,
  `placeID` INT NULL,
  `routeID` INT NULL,
  `title` VARCHAR(100) NOT NULL,
  `body` VARCHAR(300) NOT NULL,
  `creationDate` DATETIME NULL,
  `imageUrl` VARCHAR(200) NULL,
  PRIMARY KEY (`reviewID`),
  UNIQUE INDEX `I_REVIEW_reviewID_UNIQUE` (`reviewID` ASC),
  INDEX `I_REVIEW_placeID_idx` (`placeID` ASC),
  INDEX `I_REVIEW_routeID_idx` (`routeID` ASC),
  CONSTRAINT `FK_REWIEW_creatorID`
    FOREIGN KEY (`creatorID`)
    REFERENCES `monaco`.`USER` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_REWIEW_placeID`
    FOREIGN KEY (`placeID`)
    REFERENCES `monaco`.`PLACE` (`placeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_REWIEW_routeID`
    FOREIGN KEY (`routeID`)
    REFERENCES `monaco`.`ROUTE` (`routeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`COMMENT_ON_REVIEW`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`COMMENT_ON_REVIEW` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`COMMENT_ON_REVIEW` (
  `commentID` INT NOT NULL AUTO_INCREMENT,
  `commenterID` INT NOT NULL,
  `reviewID` INT NOT NULL,
  `body` VARCHAR(200) NOT NULL,
  `commentDate` DATE NULL,
  PRIMARY KEY (`commentID`),
  UNIQUE INDEX `I_COR_commentID_UNIQUE` (`commentID` ASC),
  INDEX `I_COR_reviewID_idx` (`reviewID` ASC),
  CONSTRAINT `FK_COR_reviewID`
    FOREIGN KEY (`reviewID`)
    REFERENCES `monaco`.`REVIEW` (`reviewID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COR_commenterID`
    FOREIGN KEY (`commenterID`)
    REFERENCES `monaco`.`USER` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `monaco`.`EVENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `monaco`.`EVENT` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `monaco`.`EVENT` (
  `eventID` INT NOT NULL AUTO_INCREMENT,
  `eventTitle` VARCHAR(100) NULL,
  `eventDescription` VARCHAR(500) NULL,
  `eventLink` VARCHAR(150) NULL,
  `userID` INT NULL,
  `placeID` INT NULL,
  `eventDate` DATETIME NULL,
  `eventRecordDate` DATETIME NULL,
  PRIMARY KEY (`eventID`),
  UNIQUE INDEX `I_EVENT_eventID_UNIQUE` (`eventID` ASC),
  INDEX `I_EVENT_userID_idx` (`userID` ASC),
  INDEX `I_EVENT_placeID_idx` (`placeID` ASC),
  CONSTRAINT `FK_EVENT_userID`
    FOREIGN KEY (`userID`)
    REFERENCES `monaco`.`USER` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_EVENT_placeID`
    FOREIGN KEY (`placeID`)
    REFERENCES `monaco`.`PLACE` (`placeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `monaco`.`TAGS_REF`
-- -----------------------------------------------------
START TRANSACTION;
USE `monaco`;
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (101, 'Hipster');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (102, 'Classic');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (103, 'Rock');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (104, 'Tourist');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (105, 'Sport');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (106, 'Gop');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (107, 'Romantic');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (108, 'Food');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (109, 'Culture');
INSERT INTO `monaco`.`TAGS_REF` (`TAG_NAME_ID`, `TAG_NAME`) VALUES (110, 'Sightseeing');

COMMIT;


-- -----------------------------------------------------
-- Data for table `monaco`.`COUNTRY_REF`
-- -----------------------------------------------------
START TRANSACTION;
USE `monaco`;
INSERT INTO `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`, `COUNTRY_NAME`, `COUNTRY_SHORT_NAME`) VALUES (401, 'Latvia', 'LV');
INSERT INTO `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`, `COUNTRY_NAME`, `COUNTRY_SHORT_NAME`) VALUES (402, 'Lithuania', 'LT');
INSERT INTO `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`, `COUNTRY_NAME`, `COUNTRY_SHORT_NAME`) VALUES (403, 'Estonia', 'EE');
INSERT INTO `monaco`.`COUNTRY_REF` (`COUNTRY_NAME_ID`, `COUNTRY_NAME`, `COUNTRY_SHORT_NAME`) VALUES (404, 'Monaco', 'MC');

COMMIT;


-- -----------------------------------------------------
-- Data for table `monaco`.`CITY_REF`
-- -----------------------------------------------------
START TRANSACTION;
USE `monaco`;
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (301, 'Riga', 401);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (302, 'Liepaja', 401);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (303, 'Ventspils', 401);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (304, 'Daugavpils', 401);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (305, 'Jelgava', 401);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (306, 'Vilnius', 402);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (307, 'Tallin', 403);
INSERT INTO `monaco`.`CITY_REF` (`CITY_NAME_ID`, `CITY_NAME`, `CITY_COUNTRY_ID`) VALUES (308, 'Monaco', 404);

COMMIT;


-- -----------------------------------------------------
-- Data for table `monaco`.`PLACE_TYPE_REF`
-- -----------------------------------------------------
START TRANSACTION;
USE `monaco`;
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (201, 'Cafe');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (202, 'Club');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (203, 'Monument');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (204, 'Museum');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (205, 'Restaurant');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (206, 'Park');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (207, 'Shopping Center');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (208, 'Station');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (209, 'Exhibition');
INSERT INTO `monaco`.`PLACE_TYPE_REF` (`PLACE_TYPE_ID`, `PLACE_TYPE`) VALUES (210, 'Bar');

COMMIT;

USE `monaco`;

DELIMITER $$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`USER_BEFORE_INSERT` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`USER_BEFORE_INSERT` BEFORE INSERT ON `USER` FOR EACH ROW
SET NEW.creationDate = NOW()$$

SHOW WARNINGS$$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`ROUTE_BEFORE_INSERT` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`ROUTE_BEFORE_INSERT` BEFORE INSERT ON `ROUTE` FOR EACH ROW
SET NEW.creationDate = NOW()$$

SHOW WARNINGS$$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`REVIEW_BEFORE_INSERT` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`REVIEW_BEFORE_INSERT` BEFORE INSERT ON `REVIEW` FOR EACH ROW
SET NEW.creationDate = NOW()$$

SHOW WARNINGS$$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`COMMENT_ON_REVIEW_BEFORE_INSERT` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`COMMENT_ON_REVIEW_BEFORE_INSERT` BEFORE INSERT ON `COMMENT_ON_REVIEW` FOR EACH ROW
SET NEW.commentDate = NOW()$$

SHOW WARNINGS$$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`EVENT_BEFORE_INSERT` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`EVENT_BEFORE_INSERT` BEFORE INSERT ON `EVENT` FOR EACH ROW
SET NEW.eventRecordDate = NOW()$$

SHOW WARNINGS$$

USE `monaco`$$
DROP TRIGGER IF EXISTS `monaco`.`EVENT_BEFORE_UPDATE` $$
SHOW WARNINGS$$
USE `monaco`$$
CREATE DEFINER = CURRENT_USER TRIGGER `monaco`.`EVENT_BEFORE_UPDATE` BEFORE UPDATE ON `EVENT` FOR EACH ROW
SET NEW.eventRecordDate = NOW()$$

SHOW WARNINGS$$

DELIMITER ;
