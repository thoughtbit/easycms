/*
SQLyog Ultimate v8.32 
MySQL - 5.5.39 : Database - eshopcms_db
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easycms_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `easycms_db`;

/*Table structure for table `Account` */

DROP TABLE IF EXISTS `Account`;

CREATE TABLE `Account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `Account` */

insert  into `Account`(`id`,`username`,`password`) values (1,'测试123','123'),(2,'测试456','123'),(3,'测试789','123'),(4,'测试122200','123'),(5,'测试189555','123'),(6,'fuxin','123456'),(25,'??189555','123'),(9,'SDAFSDAF','123456'),(10,'SADWERWER23423423434','123456'),(11,'SADWE4323434','234234'),(12,'DFDFDFS','234234'),(13,'121321123123','123123123'),(14,'E234','123123123'),(15,'测试a','123456'),(16,'测试b','123456'),(17,'测试c','123456'),(18,'测试d','123456'),(19,'测试e','123456'),(20,'测试f','123456'),(21,'测试g','123456'),(22,'测试aa','123456'),(23,'测试bb','123456'),(24,'??189555','123'),(26,'??189555','123'),(27,'??189555','123'),(28,'??189555','123'),(29,'测试189555','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
