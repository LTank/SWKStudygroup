CREATE DATABASE  IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: db
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'anna hansen',543),(2,'anna hansen',543),(16,'Hanna',121235),(17,'Hanna',125),(18,'Hanna2',125),(19,'ww',125),(20,'Hanna',1),(21,'Hanna',125),(22,'Hanna',125),(23,'Hanna',125),(24,'Hanna',125),(25,'Anna Hansen',250),(26,'Anna Hansen',250),(27,'Hansen',250),(28,'qqq Hansen',2150),(29,'Anna Hansen',250),(30,'Anna Hansen',250),(31,'Anna Hansen',250),(32,'Anna Hansen',250),(33,'Bent',50),(34,'William',432),(35,'William',432),(36,'William',432),(37,'William',432),(38,'William',432),(39,'William',432),(40,'William',432),(41,'William',432),(42,'William',432),(43,'William',432),(44,'William',432),(45,'William',432),(46,'William',432),(47,'William',432),(48,'William',432),(49,'William',432),(50,'William',432),(51,'William',432),(52,'William',432),(53,'William',432),(54,'William',432),(55,'William',432),(56,'William',432),(57,'William',432),(58,'William',432),(59,'William',432),(60,'William',432),(61,'William',432),(62,'William',432),(63,'William',432),(64,'William',432),(65,'William',432),(66,'William',432),(67,'William',432),(68,'William',432),(69,'William',432),(70,'William',432),(71,'William',432),(72,'William',432),(73,'William',432),(74,'William',432),(75,'William',432),(76,'William',432),(77,'William',432),(78,'William',432),(79,'anna',444),(80,'anna',444),(81,'anna',444),(82,'anna',444),(83,'anna',444),(84,'William',432),(85,'William',432),(86,'William',432);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_attempts`
--

DROP TABLE IF EXISTS `login_attempts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_attempts` (
  `bruger` varchar(45) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bruger`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_attempts`
--

LOCK TABLES `login_attempts` WRITE;
/*!40000 ALTER TABLE `login_attempts` DISABLE KEYS */;
INSERT INTO `login_attempts` VALUES ('Jon','2018-03-18 23:00:00','OK'),('Jon','2018-03-19 09:46:53','OK');
/*!40000 ALTER TABLE `login_attempts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-19 11:39:43
