/*
SQLyog Ultimate v8.32 
MySQL - 5.5.39 : Database - easycms_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easycms_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easycms_db`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`id`,`username`,`password`) values (1,'测试123','123'),(2,'测试456','123'),(3,'测试789','123'),(4,'测试122200','123'),(5,'测试189555','123'),(34,'006','Susan'),(25,'??189555','123'),(9,'SDAFSDAF','123456'),(10,'SADWERWER23423423434','123456'),(11,'SADWE4323434','234234'),(12,'DFDFDFS','234234'),(13,'121321123123','123123123'),(14,'E234','123123123'),(15,'测试a','123456'),(16,'测试b','123456'),(17,'测试c','123456'),(18,'测试d','123456'),(19,'测试e','123456'),(20,'测试f','123456'),(21,'测试g','123456'),(22,'测试aa','123456'),(23,'测试bb','123456'),(24,'??189555','123'),(26,'??189555','123'),(27,'??189555','123'),(28,'??189555','123'),(29,'测试189555','123'),(37,'006','Susan'),(31,'测试444','444444444444444'),(32,'测试444','444444444444444'),(33,'006','Susan'),(35,'006','Susan'),(36,'006','Susan'),(38,'006','Susan'),(39,'006','Susan');

/*Table structure for table `ec_shop_category` */

DROP TABLE IF EXISTS `ec_shop_category`;

CREATE TABLE `ec_shop_category` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类编号 主键',
  `cat_name` varchar(100) NOT NULL COMMENT '分类名称',
  `cat_path` varchar(100) NOT NULL COMMENT '分类路径',
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_shop_category` */

/*Table structure for table `ec_shop_product` */

DROP TABLE IF EXISTS `ec_shop_product`;

CREATE TABLE `ec_shop_product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品编号 主键',
  `dealer_id` bigint(20) NOT NULL COMMENT '商家编号 外键',
  `product_name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `category_id` bigint(20) DEFAULT NULL COMMENT '产品分类编号 外键',
  `product_intro` varchar(255) DEFAULT NULL COMMENT '产品描述',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_shop_product` */

/*Table structure for table `ec_sys_dealer` */

DROP TABLE IF EXISTS `ec_sys_dealer`;

CREATE TABLE `ec_sys_dealer` (
  `dealer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商家编号 主键',
  `group_id` bigint(20) NOT NULL COMMENT '商家组编号 外键',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号 外键',
  `dealer_name` varchar(100) NOT NULL COMMENT '商家名称',
  `store_id` bigint(20) NOT NULL COMMENT '店铺编号 外键',
  `dealer_logo` varchar(50) DEFAULT NULL COMMENT '商家LOGO',
  `dealer_phone` varchar(20) DEFAULT NULL COMMENT '商家电话',
  `dealer_mobile` varchar(20) DEFAULT NULL COMMENT '商家手机',
  `dealer_legal` varchar(50) DEFAULT NULL COMMENT '商家法人',
  `dealer_address` varchar(100) DEFAULT NULL COMMENT '商家地址',
  PRIMARY KEY (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_dealer` */

/*Table structure for table `ec_sys_dealer_group` */

DROP TABLE IF EXISTS `ec_sys_dealer_group`;

CREATE TABLE `ec_sys_dealer_group` (
  `group_id` bigint(20) DEFAULT NULL COMMENT '商家组编号 主键',
  `name` varchar(50) DEFAULT NULL,
  `score` varchar(20) DEFAULT NULL,
  `discount` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_dealer_group` */

/*Table structure for table `ec_sys_member` */

DROP TABLE IF EXISTS `ec_sys_member`;

CREATE TABLE `ec_sys_member` (
  `member_id` bigint(20) NOT NULL COMMENT '会员编号 主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号 外键',
  `group_id` bigint(20) NOT NULL COMMENT '会员组编号 外键',
  `member_gender` tinyint(1) DEFAULT NULL COMMENT '会员性别',
  `member_birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `member_intro` varchar(255) DEFAULT NULL COMMENT '会员简介',
  `member_address` varchar(100) DEFAULT NULL COMMENT '会员联系地址',
  `member_qq` varchar(20) DEFAULT NULL COMMENT '会员QQ',
  `member_phone` varchar(20) DEFAULT NULL COMMENT '会员手机',
  `member_tel` varchar(20) DEFAULT NULL COMMENT '会员电话',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_member` */

/*Table structure for table `ec_sys_member_address` */

DROP TABLE IF EXISTS `ec_sys_member_address`;

CREATE TABLE `ec_sys_member_address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员地址编号 主键',
  `member_id` bigint(20) NOT NULL COMMENT '会员编号 外键',
  `city_id` varchar(20) DEFAULT NULL,
  `country_id` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_member_address` */

/*Table structure for table `ec_sys_member_group` */

DROP TABLE IF EXISTS `ec_sys_member_group`;

CREATE TABLE `ec_sys_member_group` (
  `group_id` bigint(20) NOT NULL COMMENT '会员组编号 主键',
  `name` varchar(50) NOT NULL COMMENT '会员组名称',
  `score` varchar(20) NOT NULL COMMENT '会员组积分',
  `discount` varchar(20) NOT NULL COMMENT '会员组折扣率',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_member_group` */

/*Table structure for table `ec_sys_resource` */

DROP TABLE IF EXISTS `ec_sys_resource`;

CREATE TABLE `ec_sys_resource` (
  `resource_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号 主键',
  `resource_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符串',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可以 1可用，0不可用',
  `resource_type` varchar(50) DEFAULT NULL COMMENT '资源类型 1菜单，2按钮',
  `resource_pid` bigint(20) DEFAULT NULL COMMENT '父编号',
  `resource_pids` varchar(100) DEFAULT NULL COMMENT '父编号列表',
  `priority` int(11) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_resource` */

insert  into `ec_sys_resource`(`resource_id`,`resource_name`,`permission`,`available`,`resource_type`,`resource_pid`,`resource_pids`,`priority`) values (1,'菜单',NULL,NULL,'menu',NULL,NULL,NULL),(2,'按钮',NULL,NULL,'button',NULL,NULL,NULL),(3,'超链接',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `ec_sys_role` */

DROP TABLE IF EXISTS `ec_sys_role`;

CREATE TABLE `ec_sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号 主键',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `resource_ids` varchar(100) DEFAULT NULL COMMENT '授权的资源(角色拥有的权限列表)',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用 1可用，0不可用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_role` */

insert  into `ec_sys_role`(`role_id`,`role_name`,`resource_ids`,`role_desc`,`available`) values (1,'超级管理员',NULL,NULL,NULL),(2,'商家管理员',NULL,NULL,NULL),(3,'会员管理员',NULL,NULL,NULL);

/*Table structure for table `ec_sys_role_resource` */

DROP TABLE IF EXISTS `ec_sys_role_resource`;

CREATE TABLE `ec_sys_role_resource` (
  `resource_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源编号',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色编号',
  PRIMARY KEY (`resource_id`,`role_id`),
  KEY `FK_EC_SYS_ROLE_RESOURCE_RESOURCE_ID` (`resource_id`),
  KEY `FK_EC_SYS_ROLE_RESOURCE_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_EC_SYS_ROLE_RESOURCE_RESOURCE_ID` FOREIGN KEY (`resource_id`) REFERENCES `ec_sys_resource` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EC_SYS_ROLE_RESOURCE_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `ec_sys_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_role_resource` */

insert  into `ec_sys_role_resource`(`resource_id`,`role_id`) values (1,1),(1,2),(2,1),(2,3),(3,2);

/*Table structure for table `ec_sys_user` */

DROP TABLE IF EXISTS `ec_sys_user`;

CREATE TABLE `ec_sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '加密盐',
  `locked` tinyint(1) DEFAULT '1' COMMENT '账号是否被锁定',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(15) DEFAULT NULL COMMENT '注册IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '最后登录IP',
  `login_count` bigint(20) DEFAULT '0' COMMENT '登录次数',
  `activation_key` varchar(50) DEFAULT NULL COMMENT '用户激活KEY',
  `forgot_key` varchar(50) DEFAULT NULL COMMENT '找回密码KEY',
  `forgot_pwd` varchar(50) DEFAULT NULL COMMENT '重置密码',
  `error_time` datetime DEFAULT NULL COMMENT '登人错误时间',
  `error_count` bigint(20) DEFAULT NULL COMMENT '等人错误次数',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_user` */

insert  into `ec_sys_user`(`user_id`,`username`,`password`,`salt`,`locked`,`email`,`register_time`,`register_ip`,`last_login_time`,`last_login_ip`,`login_count`,`activation_key`,`forgot_key`,`forgot_pwd`,`error_time`,`error_count`) values (1,'moocss','123456',NULL,1,'moocss@gmail.com',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL),(2,'fuxin','456789',NULL,1,'fuxin@gmail.com',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `ec_sys_user_role` */

DROP TABLE IF EXISTS `ec_sys_user_role`;

CREATE TABLE `ec_sys_user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_EC_SYS_USER_ROLE_USER_ID` (`user_id`),
  KEY `FK_EC_SYS_USER_ROLE_ROLE_ID` (`role_id`),
  CONSTRAINT `FK_EC_SYS_USER_ROLE_ROLE_ID` FOREIGN KEY (`role_id`) REFERENCES `ec_sys_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EC_SYS_USER_ROLE_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `ec_sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ec_sys_user_role` */

insert  into `ec_sys_user_role`(`user_id`,`role_id`) values (1,1),(1,2),(1,3),(2,1),(2,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
