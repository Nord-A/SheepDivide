CREATE DATABASE  IF NOT EXISTS `sheepdivide` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sheepdivide`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: sheepdivide.crebnxmqviyd.eu-west-2.rds.amazonaws.com    Database: sheepdivide
-- ------------------------------------------------------
-- Server version	5.6.37-log

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
-- Table structure for table `sheep`
--

DROP TABLE IF EXISTS `sheep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sheep` (
  `sheepId` varchar(45) NOT NULL,
  `weightKg` int(3) NOT NULL,
  `typeOfSheep` varchar(45) NOT NULL,
  `wool` int(11) NOT NULL,
  `horns` int(11) NOT NULL,
  `legs` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `fieldId` int(11) DEFAULT '1',
  PRIMARY KEY (`sheepId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sheep`
--

LOCK TABLES `sheep` WRITE;
/*!40000 ALTER TABLE `sheep` DISABLE KEYS */;
INSERT INTO `sheep` VALUES ('10',55,'Ewe',0,0,0,NULL,'',1),('11',57,'Male lamb',1,2,-1,NULL,'',1),('12',130,'Ram',-1,2,-2,NULL,'den er alt for fed og tyk. hornene er dårlige og skal files hvert år.',1),('12f',34,'Ewe lamb',1,-1,2,NULL,'',1),('14r',78,'Ewe',2,1,-2,NULL,'',1),('15',20,'Ewe',0,0,0,NULL,'',1),('1aa',31,'Ewe lamb',0,0,0,NULL,'',1),('1e21',66,'Ewe',-2,1,0,NULL,'',1),('1f',66,'Ewe',0,0,0,NULL,'',1),('1h',77,'Ewe',0,0,0,NULL,'',1),('1j',61,'Ewe',0,0,0,NULL,'',1),('1ja',106,'Ram',0,0,0,NULL,'',1),('1nb',41,'Ewe',0,0,0,NULL,'',1),('1nt',109,'Ram',0,0,0,NULL,'',1),('1op',57,'Ewe',0,0,0,NULL,'',1),('1rq',89,'Ram',0,0,0,NULL,'',1),('1s',28,'Male lamb',1,2,0,NULL,'',1),('1uu',77,'Male lamb',0,0,0,NULL,'',1),('200',67,'Male lamb',-2,2,0,NULL,'',1),('312',51,'Male lamb',1,2,0,NULL,'',1),('41',23,'Ewe lamb',1,-2,-2,NULL,'',1),('421k',99,'Ram',2,2,-2,NULL,'',1),('511',78,'Ewe',2,1,2,NULL,'',1),('5k1',39,'Ewe lamb',2,0,-2,NULL,'',1),('65g',67,'Ewe',0,0,0,NULL,'',1),('71',54,'Male lamb',2,-2,1,NULL,'',1),('77',11,'Ewe',0,0,0,NULL,'',1),('dwa',59,'Ewe',0,-2,0,NULL,'',1),('k1',34,'Ewe lamb',0,0,0,NULL,'',1),('koko',90,'Male lamb',2,1,0,NULL,'',1),('koko2',75,'Ewe lamb',0,0,0,NULL,'',1),('nma',111,'Ram',0,0,0,NULL,'',1),('nmw',64,'Male lamb',0,0,0,NULL,'',1),('p2',26,'Ewe lamb',0,0,0,NULL,NULL,1),('p2kk',26,'Ewe lamb',0,0,0,NULL,NULL,1),('p2kw',26,'Ewe lamb',0,0,0,NULL,NULL,1),('p2kwa',26,'Ewe lamb',0,0,0,NULL,NULL,1);
/*!40000 ALTER TABLE `sheep` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13 13:06:55
