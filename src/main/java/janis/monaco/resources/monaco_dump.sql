-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: monaco
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CITY_REF`
--

DROP TABLE IF EXISTS `CITY_REF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CITY_REF` (
  `CITY_NAME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(45) NOT NULL,
  `CITY_COUNTRY_ID` int(11) NOT NULL,
  PRIMARY KEY (`CITY_NAME_ID`),
  UNIQUE KEY `I_CIREF_CITY_NAME_ID_UNIQUE` (`CITY_NAME_ID`),
  KEY `FK_CITYREF_CountryID_idx` (`CITY_COUNTRY_ID`),
  CONSTRAINT `FK_CITYREF_CountryID` FOREIGN KEY (`CITY_COUNTRY_ID`) REFERENCES `COUNTRY_REF` (`COUNTRY_NAME_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=309 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITY_REF`
--

LOCK TABLES `CITY_REF` WRITE;
/*!40000 ALTER TABLE `CITY_REF` DISABLE KEYS */;
INSERT INTO `CITY_REF` VALUES (301,'Riga',401),(302,'Liepaja',401),(303,'Ventspils',401),(304,'Daugavpils',401),(305,'Jelgava',401),(306,'Vilnius',402),(307,'Tallin',403),(308,'Monaco',404);
/*!40000 ALTER TABLE `CITY_REF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMMENT_ON_REVIEW`
--

DROP TABLE IF EXISTS `COMMENT_ON_REVIEW`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMMENT_ON_REVIEW` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `commenterID` int(11) NOT NULL,
  `reviewID` int(11) NOT NULL,
  `body` varchar(200) NOT NULL,
  `commentDate` date DEFAULT NULL,
  `reviews_reviewID` int(11) NOT NULL,
  PRIMARY KEY (`commentID`),
  UNIQUE KEY `I_COR_commentID_UNIQUE` (`commentID`),
  KEY `I_COR_reviewID_idx` (`reviewID`),
  KEY `FK_COR_commenterID` (`commenterID`),
  CONSTRAINT `FK_COR_commenterID` FOREIGN KEY (`commenterID`) REFERENCES `USER` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_COR_reviewID` FOREIGN KEY (`reviewID`) REFERENCES `REVIEW` (`reviewID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMMENT_ON_REVIEW`
--

LOCK TABLES `COMMENT_ON_REVIEW` WRITE;
/*!40000 ALTER TABLE `COMMENT_ON_REVIEW` DISABLE KEYS */;
INSERT INTO `COMMENT_ON_REVIEW` VALUES (1,1,1,'Comment text','2015-11-03',0);
/*!40000 ALTER TABLE `COMMENT_ON_REVIEW` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `monaco`.`COMMENT_ON_REVIEW_BEFORE_INSERT` BEFORE INSERT ON `COMMENT_ON_REVIEW` FOR EACH ROW
SET NEW.commentDate = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `COUNTRY_REF`
--

DROP TABLE IF EXISTS `COUNTRY_REF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COUNTRY_REF` (
  `COUNTRY_NAME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COUNTRY_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`COUNTRY_NAME_ID`),
  UNIQUE KEY `I_COREF_CITY_NAME_ID_UNIQUE` (`COUNTRY_NAME_ID`),
  UNIQUE KEY `I_COREF_COUNTRY_NAME_UNIQUE` (`COUNTRY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COUNTRY_REF`
--

LOCK TABLES `COUNTRY_REF` WRITE;
/*!40000 ALTER TABLE `COUNTRY_REF` DISABLE KEYS */;
INSERT INTO `COUNTRY_REF` VALUES (403,'Estonia'),(401,'Latvia'),(402,'Lithuania'),(404,'Monaco');
/*!40000 ALTER TABLE `COUNTRY_REF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLACE`
--

DROP TABLE IF EXISTS `PLACE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLACE` (
  `placeID` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `imageURL` varchar(100) DEFAULT NULL,
  `placeName` varchar(100) NOT NULL,
  `placeAddress` varchar(100) NOT NULL,
  `placeTypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`placeID`),
  UNIQUE KEY `I_P_placeID_UNIQUE` (`placeID`),
  UNIQUE KEY `I_P_latitude_UNIQUE` (`latitude`),
  UNIQUE KEY `I_P_longitude_UNIQUE` (`longitude`),
  KEY `I_P_placeTypeID_idx` (`placeTypeID`),
  CONSTRAINT `FK_P_PLACE_placeTypeID` FOREIGN KEY (`placeTypeID`) REFERENCES `PLACE_TYPE_REF` (`PLACE_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLACE`
--

LOCK TABLES `PLACE` WRITE;
/*!40000 ALTER TABLE `PLACE` DISABLE KEYS */;
INSERT INTO `PLACE` VALUES (1,56.947645,24.109738,NULL,'St. Peter\'s Church','Skarnu iela 19, Riga, LV-1050',203),(2,56.949319,24.104787,NULL,'Riga Cathedral','Herdera laukums 6, Riga, LV-1050',203);
/*!40000 ALTER TABLE `PLACE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLACES_IN_ROUTE`
--

DROP TABLE IF EXISTS `PLACES_IN_ROUTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLACES_IN_ROUTE` (
  `routeID` int(11) NOT NULL,
  `SEQNR` int(11) NOT NULL,
  `placeID` int(11) NOT NULL,
  KEY `I_PIR_routeID_idx` (`routeID`),
  KEY `I_PIR_placeID_idx` (`placeID`),
  CONSTRAINT `FK_PIR_placeID` FOREIGN KEY (`placeID`) REFERENCES `PLACE` (`placeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PIR_routeID` FOREIGN KEY (`routeID`) REFERENCES `ROUTE` (`routeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLACES_IN_ROUTE`
--

LOCK TABLES `PLACES_IN_ROUTE` WRITE;
/*!40000 ALTER TABLE `PLACES_IN_ROUTE` DISABLE KEYS */;
INSERT INTO `PLACES_IN_ROUTE` VALUES (1,1,1),(1,2,2);
/*!40000 ALTER TABLE `PLACES_IN_ROUTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLACE_TYPE_REF`
--

DROP TABLE IF EXISTS `PLACE_TYPE_REF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLACE_TYPE_REF` (
  `PLACE_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PLACE_TYPE` varchar(100) NOT NULL,
  PRIMARY KEY (`PLACE_TYPE_ID`),
  UNIQUE KEY `I_PTREF_PLACE_TYPE_ID_UNIQUE` (`PLACE_TYPE_ID`),
  UNIQUE KEY `I_PTREF_PLACE_TYPE_UNIQUE` (`PLACE_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLACE_TYPE_REF`
--

LOCK TABLES `PLACE_TYPE_REF` WRITE;
/*!40000 ALTER TABLE `PLACE_TYPE_REF` DISABLE KEYS */;
INSERT INTO `PLACE_TYPE_REF` VALUES (210,'Bar'),(201,'Cafe'),(202,'Club'),(209,'Exhibition'),(203,'Monument'),(204,'Museum'),(206,'Park'),(205,'Restaurant'),(207,'Shopping Center'),(208,'Station');
/*!40000 ALTER TABLE `PLACE_TYPE_REF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REVIEW`
--

DROP TABLE IF EXISTS `REVIEW`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REVIEW` (
  `reviewID` int(11) NOT NULL AUTO_INCREMENT,
  `creatorID` int(11) NOT NULL,
  `placeID` int(11) DEFAULT NULL,
  `routeID` int(11) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `body` varchar(300) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `imageUrl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`reviewID`),
  UNIQUE KEY `I_REVIEW_reviewID_UNIQUE` (`reviewID`),
  KEY `I_REVIEW_placeID_idx` (`placeID`),
  KEY `I_REVIEW_routeID_idx` (`routeID`),
  KEY `FK_REWIEW_creatorID` (`creatorID`),
  CONSTRAINT `FK_REWIEW_creatorID` FOREIGN KEY (`creatorID`) REFERENCES `USER` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_REWIEW_placeID` FOREIGN KEY (`placeID`) REFERENCES `PLACE` (`placeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_REWIEW_routeID` FOREIGN KEY (`routeID`) REFERENCES `ROUTE` (`routeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REVIEW`
--

LOCK TABLES `REVIEW` WRITE;
/*!40000 ALTER TABLE `REVIEW` DISABLE KEYS */;
INSERT INTO `REVIEW` VALUES (1,1,1,1,'Review','Review text','2015-11-03 11:08:30',NULL);
/*!40000 ALTER TABLE `REVIEW` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `monaco`.`REVIEW_BEFORE_INSERT` BEFORE INSERT ON `REVIEW` FOR EACH ROW
SET NEW.creationDate = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ROUTE`
--

DROP TABLE IF EXISTS `ROUTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROUTE` (
  `routeID` int(11) NOT NULL AUTO_INCREMENT,
  `distance` varchar(45) NOT NULL,
  `completionTime` varchar(45) NOT NULL,
  `routeTagID` int(11) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `creatorID` int(11) NOT NULL,
  PRIMARY KEY (`routeID`),
  UNIQUE KEY `I_ROUTE_routeID_UNIQUE` (`routeID`),
  KEY `I_ROUTE_routeTagId_idx` (`routeTagID`),
  KEY `I_ROUTE_creatorID_idx` (`creatorID`),
  CONSTRAINT `FK_ROUTE_creatorID` FOREIGN KEY (`creatorID`) REFERENCES `USER` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROUTE_routeTagId` FOREIGN KEY (`routeTagID`) REFERENCES `TAGS_REF` (`TAG_NAME_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROUTE`
--

LOCK TABLES `ROUTE` WRITE;
/*!40000 ALTER TABLE `ROUTE` DISABLE KEYS */;
INSERT INTO `ROUTE` VALUES (1,'450m ','6min',110,'2015-11-03 10:52:08',1);
/*!40000 ALTER TABLE `ROUTE` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `monaco`.`ROUTE_BEFORE_INSERT` BEFORE INSERT ON `ROUTE` FOR EACH ROW
SET NEW.creationDate = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `TAGS_REF`
--

DROP TABLE IF EXISTS `TAGS_REF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TAGS_REF` (
  `TAG_NAME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TAG_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`TAG_NAME_ID`),
  UNIQUE KEY `I_TR_TAG_NAME_ID_UNIQUE` (`TAG_NAME_ID`),
  UNIQUE KEY `I_TR_TAG_NAME_UNIQUE` (`TAG_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TAGS_REF`
--

LOCK TABLES `TAGS_REF` WRITE;
/*!40000 ALTER TABLE `TAGS_REF` DISABLE KEYS */;
INSERT INTO `TAGS_REF` VALUES (102,'Classic'),(109,'Culture'),(108,'Food'),(106,'Gop'),(101,'Hipster'),(103,'Rock'),(107,'Romantic'),(110,'Sightseeing'),(105,'Sport'),(104,'Tourist');
/*!40000 ALTER TABLE `TAGS_REF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `cityID` int(11) NOT NULL,
  `countryID` int(11) NOT NULL,
  `userTagID` int(11) DEFAULT NULL,
  `userPass` varchar(16) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `I_U_userID_UNIQUE` (`userID`),
  UNIQUE KEY `I_U_nickname_UNIQUE` (`nickname`),
  KEY `I_U_userTagID_idx` (`userTagID`),
  KEY `I_U_cityID_idx` (`cityID`),
  KEY `I_U_countryID_idx` (`countryID`),
  CONSTRAINT `FK_U_cityID` FOREIGN KEY (`cityID`) REFERENCES `CITY_REF` (`CITY_NAME_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_U_countryID` FOREIGN KEY (`countryID`) REFERENCES `COUNTRY_REF` (`COUNTRY_NAME_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_U_userTagID` FOREIGN KEY (`userTagID`) REFERENCES `TAGS_REF` (`TAG_NAME_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'nikocmih',NULL,NULL,'asdf@sdf.com',NULL,301,401,NULL,'password','2015-11-03 09:56:29'),(2,'janis','Janis','Karklins','jjankar@gmail.com',40,305,401,102,'password','2015-12-04 16:01:58');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `monaco`.`USER_BEFORE_INSERT` BEFORE INSERT ON `USER` FOR EACH ROW
SET NEW.creationDate = NOW() */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-08 10:38:27
