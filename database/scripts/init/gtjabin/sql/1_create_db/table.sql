-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 192.168.33.97    Database: gtja
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_customer_data`
--

DROP TABLE IF EXISTS `t_customer_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_data` (
  `I_CUSTOMER_DATA` int(11) NOT NULL,
  `ACCOUNT_OPENING_DATE` datetime DEFAULT NULL,
  `BUSINESS_DEPARTMENT` varchar(255) DEFAULT NULL,
  `CAPITAL_ACCOUNT` int(11) DEFAULT NULL,
  `CHILDREN_AGE` varchar(255) DEFAULT NULL,
  `CHILDREN_SITUATION` varchar(255) DEFAULT NULL,
  `CUSTOMER_FEEDBACK` varchar(255) DEFAULT NULL,
  `CUSTOMER_NAME` varchar(255) DEFAULT NULL,
  `EXTERNAL_RESOURCES` varchar(255) DEFAULT NULL,
  `EXTRADIVISIONAL_ASSETS` int(11) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `INTERNAL_ASSETS` int(11) DEFAULT NULL,
  `INTERNAL_ASSETS_TYPE` varchar(255) DEFAULT NULL,
  `INVESTMENT_PREFERENCE` varchar(255) DEFAULT NULL,
  `LIQUIDITY_REQUIREMENTS` varchar(255) DEFAULT NULL,
  `MARKETING_CONTENT` varchar(255) DEFAULT NULL,
  `NEXT_MARKETING_DATE` datetime DEFAULT NULL,
  `NEXT_MARKETING_TARGET` varchar(255) DEFAULT NULL,
  `OCCUPATION` varchar(255) DEFAULT NULL,
  `OTHER_REMARKS` varchar(255) DEFAULT NULL,
  `PREVIOUS_MARKETING_CONTENT` varchar(255) DEFAULT NULL,
  `PREVIOUS_MARKETING_DATE` datetime DEFAULT NULL,
  `USER_PROTRAIT` varchar(255) DEFAULT NULL,
  `YEAR_OF_BIRTH` int(11) DEFAULT NULL,
  PRIMARY KEY (`I_CUSTOMER_DATA`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `I_USER` int(11) NOT NULL,
  `ACCOUNTS` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `DEPARTMENT` varchar(30) DEFAULT NULL,
  `POSITION` varchar(30) DEFAULT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `USER_TYPE` varchar(30) DEFAULT NULL,
  `ROLE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`I_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-10 15:05:10
