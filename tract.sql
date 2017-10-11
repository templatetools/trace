-- MySQL dump 10.13  Distrib 5.7.11, for osx10.11 (x86_64)
--
-- Host: localhost    Database: trace
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Current Database: `trace`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `trace` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `trace`;

--
-- Table structure for table `ListView`
--

DROP TABLE IF EXISTS `ListView`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ListView` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `entityName` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `listable` bit(1) DEFAULT NULL,
  `searchable` bit(1) DEFAULT NULL,
  `updateable` bit(1) DEFAULT NULL,
  `insertable` bit(1) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rules` longtext COLLATE utf8_unicode_ci,
  `itemType` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `refType` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `itemValue` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ListView`
--

LOCK TABLES `ListView` WRITE;
/*!40000 ALTER TABLE `ListView` DISABLE KEYS */;
INSERT INTO `ListView` VALUES ('ff8080815f0a1adb015f0a1af37c0000','org.food.safety.trace.entity.Organization','组织','','\0','\0','\0','organization','{\"required\":true}','Select','Organization','combobox'),('ff8080815f0a1adb015f0a1af4140001','org.food.safety.trace.entity.Organization','名称','','','\0','','name','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4180002','org.food.safety.trace.entity.Organization','创建时间','\0','\0','\0','\0','createTime','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss'),('ff8080815f0a1adb015f0a1af41c0003','org.food.safety.trace.entity.Menu','组织','','\0','\0','','organization','{\"required\":true}','Select','Organization','combobox'),('ff8080815f0a1adb015f0a1af4200004','org.food.safety.trace.entity.Menu','名称','','','\0','','name','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4240005','org.food.safety.trace.entity.Menu','图标','','\0','\0','','icon','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4290006','org.food.safety.trace.entity.Menu','路由','','\0','\0','','route','{\"required\":false}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af42d0007','org.food.safety.trace.entity.Menu','父级菜单','','\0','\0','','mpid','{\"required\":false}','Select','Menu','combobox'),('ff8080815f0a1adb015f0a1af4340008','org.food.safety.trace.entity.Menu','创建时间','\0','\0','\0','\0','createTime','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss'),('ff8080815f0a1adb015f0a1af4380009','org.food.safety.trace.entity.ListView','实体名称','\0','\0','\0','','entityName','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af43c000a','org.food.safety.trace.entity.ListView','标题','\0','\0','\0','','title','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af440000b','org.food.safety.trace.entity.ListView','是否显示到列表','\0','\0','\0','','listable','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af443000c','org.food.safety.trace.entity.ListView','是否支持搜索','\0','\0','\0','','searchable','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af447000d','org.food.safety.trace.entity.ListView','是否修改','\0','\0','\0','','updateable','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af44b000e','org.food.safety.trace.entity.ListView','是否添加','\0','\0','\0','','insertable','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af44f000f','org.food.safety.trace.entity.ListView','列名','\0','\0','\0','','name','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4520010','org.food.safety.trace.entity.ListView','规则','\0','\0','\0','','rules','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4560011','org.food.safety.trace.entity.ListView','渲染元素类型','\0','\0','\0','','itemType','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af45a0012','org.food.safety.trace.entity.ListView','引用数据类型','\0','\0','\0','','refType','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af45e0013','org.food.safety.trace.entity.ListView','备选数据','\0','\0','\0','','itemValue','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4620014','org.food.safety.trace.entity.Reference','目标对象','','','\0','','targetName','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4660015','org.food.safety.trace.entity.Reference','目标','','','\0','','targetId','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af46a0016','org.food.safety.trace.entity.Reference','源对象','','','\0','','sourceName','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4700017','org.food.safety.trace.entity.Reference','源','','','\0','','sourceId','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4740018','org.food.safety.trace.entity.business.PetRace','组织','','\0','\0','','organization','{\"required\":true}','Select','Organization','combobox'),('ff8080815f0a1adb015f0a1af4790019','org.food.safety.trace.entity.business.PetRace','名称','','','\0','','name','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af480001a','org.food.safety.trace.entity.business.PetRace','创建时间','\0','\0','\0','\0','createDate','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss'),('ff8080815f0a1adb015f0a1af484001b','org.food.safety.trace.entity.business.PetRace','创建人','\0','\0','\0','\0','createUserId','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af489001c','org.food.safety.trace.entity.business.PetRace','更新时间','\0','\0','\0','\0','updateDate','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss'),('ff8080815f0a1adb015f0a1af48e001d','org.food.safety.trace.entity.business.PetRace','更新人','\0','\0','\0','\0','updateUserId','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af492001e','org.food.safety.trace.entity.business.PetRace','状态','\0','\0','\0','\0','status','{}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af497001f','org.food.safety.trace.entity.UserEntity','组织','','\0','\0','','organization','{\"required\":true}','Select','Organization','combobox'),('ff8080815f0a1adb015f0a1af49d0020','org.food.safety.trace.entity.UserEntity','角色','','\0','\0','','roles','{\"required\":true}','Select','Role','multiple'),('ff8080815f0a1adb015f0a1af4a30021','org.food.safety.trace.entity.UserEntity','用户名','','','\0','','name','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4a80022','org.food.safety.trace.entity.UserEntity','密码','\0','','\0','','password','{\"required\":true}','Input',NULL,'password'),('ff8080815f0a1adb015f0a1af4ad0023','org.food.safety.trace.entity.UserEntity','昵称','','','\0','','nickName','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4b40024','org.food.safety.trace.entity.UserEntity','年龄','\0','\0','\0','','age','{\"type\":\"number\",\"required\":true}','InputNumber',NULL,NULL),('ff8080815f0a1adb015f0a1af4b90025','org.food.safety.trace.entity.UserEntity','性别','\0','\0','\0','','isMale','{\"type\":\"boolean\",\"required\":true}','Radio',NULL,'[{\"text\":\"男\", \"val\":true},{\"text\":\"女\", \"val\":false}]'),('ff8080815f0a1adb015f0a1af4bd0026','org.food.safety.trace.entity.UserEntity','电话','\0','','\0','','phone','{\"pattern\":\"\\/^1[34578]\\\\d{9}$\\/\",\"message\":\"The input is not valid phone!\",\"required\":true}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4c80027','org.food.safety.trace.entity.UserEntity','电子邮件','\0','\0','\0','','email','{\"pattern\":\"\\/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+\\/\",\"message\":\"The input is not valid E-mail!\",\"required\":true}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4cd0028','org.food.safety.trace.entity.UserEntity','联系地址','\0','\0','\0','','address','{\"required\":true}',NULL,NULL,NULL),('ff8080815f0a1adb015f0a1af4d30029','org.food.safety.trace.entity.UserEntity','创建时间','\0','\0','\0','\0','createTime','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss'),('ff8080815f0a1adb015f0a1af4d9002a','org.food.safety.trace.entity.Role','组织','','\0','\0','','organization','{\"required\":true}','Select','Organization','combobox'),('ff8080815f0a1adb015f0a1af4e0002b','org.food.safety.trace.entity.Role','名称','','','\0','','name','{\"required\":true}','Input',NULL,NULL),('ff8080815f0a1adb015f0a1af4e4002c','org.food.safety.trace.entity.Role','菜单','','\0','\0','','menus','{\"required\":true}','Select','Menu','multiple'),('ff8080815f0a1adb015f0a1af4e8002d','org.food.safety.trace.entity.Role','创建时间','\0','\0','\0','\0','createTime','{}','DatePicker',NULL,'yyyy-MM-dd HH:mm:ss');
/*!40000 ALTER TABLE `ListView` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menu` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `organization` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `route` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mpid` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` VALUES ('ff8080815f0a1adb015f0a1afa82002e','default','首页','laptop','/dashboard',NULL,'2017-10-11 14:24:21'),('ff8080815f0a1adb015f0a1afa8f002f','default','设置','setting',NULL,NULL,'2017-10-11 14:24:21'),('ff8080815f0a1adb015f0a1afa930030','default','角色管理','laptop','/rest/Role','ff8080815f0a1adb015f0a1afa8f002f','2017-10-11 14:24:21'),('ff8080815f0a1adb015f0a1afa970031','default','用户管理','user','/rest/UserEntity','ff8080815f0a1adb015f0a1afa8f002f','2017-10-11 14:24:21'),('ff8080815f0a1adb015f0a1afa9a0032','default','菜单管理','menu-fold','/rest/Menu','ff8080815f0a1adb015f0a1afa8f002f','2017-10-11 14:24:21'),('ff8080815f0a1adb015f0a1afa9d0033','default','组织管理','team','/rest/Organization','ff8080815f0a1adb015f0a1afa8f002f','2017-10-11 14:24:21'),('ff8080815f0a1cda015f0a2097480001','ff8080815f0a1cda015f0a23d41e0002','宠物种类','book','/rest/PetRace','ff8080815f0a1cda015f0a24e4470003','2017-10-11 14:30:28'),('ff8080815f0a1cda015f0a24e4470003','ff8080815f0a1cda015f0a23d41e0002','基础数据','anticon anticon-database',NULL,'','2017-10-11 14:35:10'),('ff8080815f0a1cda015f0a2882200007','ff8080815f0a1cda015f0a23d41e0002','设置','setting',NULL,NULL,'2017-10-11 14:39:07'),('ff8080815f0a1cda015f0a292a280008','ff8080815f0a1cda015f0a23d41e0002','菜单管理','menu-fold','/rest/Menu','ff8080815f0a1cda015f0a2882200007','2017-10-11 14:39:50'),('ff8080815f0a1cda015f0a29cce50009','ff8080815f0a1cda015f0a23d41e0002','员工管理','user','/rest/UserEntity','ff8080815f0a1cda015f0a24e4470003','2017-10-11 14:40:32');
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Organization`
--

DROP TABLE IF EXISTS `Organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Organization` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `organization` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Organization`
--

LOCK TABLES `Organization` WRITE;
/*!40000 ALTER TABLE `Organization` DISABLE KEYS */;
INSERT INTO `Organization` VALUES ('default','default','default','2017-10-10 16:57:59'),('ff8080815f0a1cda015f0a23d41e0002','ff8080815f0a1cda015f0a23d41e0002','北京锐捷网络','2017-10-11 14:34:01');
/*!40000 ALTER TABLE `Organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reference`
--

DROP TABLE IF EXISTS `Reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reference` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `targetName` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `targetId` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sourceName` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sourceId` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reference`
--

LOCK TABLES `Reference` WRITE;
/*!40000 ALTER TABLE `Reference` DISABLE KEYS */;
INSERT INTO `Reference` VALUES ('ff8080815f055144015f05580af40006','Role','ff8080815f055144015f0557b58e0001','UserEntity','admin'),('ff8080815f0a1cda015f0a2a1ac4000a','Menu','ff8080815f0a1cda015f0a24e4470003','Role','ff8080815f0a1cda015f0a26af980004'),('ff8080815f0a1cda015f0a2a1ac4000b','Menu','ff8080815f0a1cda015f0a2097480001','Role','ff8080815f0a1cda015f0a26af980004'),('ff8080815f0a1cda015f0a2a1ac5000c','Menu','ff8080815f0a1cda015f0a292a280008','Role','ff8080815f0a1cda015f0a26af980004'),('ff8080815f0a1cda015f0a2a1ac5000d','Menu','ff8080815f0a1cda015f0a29cce50009','Role','ff8080815f0a1cda015f0a26af980004'),('ff8080815f0a1cda015f0a2a1ac6000e','Menu','ff8080815f0a1cda015f0a2882200007','Role','ff8080815f0a1cda015f0a26af980004'),('ff8080815f0a1cda015f0a2aba860010','Role','ff8080815f0a1cda015f0a26af980004','UserEntity','ff8080815f0a1cda015f0a2aba7e000f');
/*!40000 ALTER TABLE `Reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `organization` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menus` longtext COLLATE utf8_unicode_ci,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES ('ff8080815f055144015f0557b58e0001','default','admin',NULL,'2017-10-10 16:12:35'),('ff8080815f0a1cda015f0a26af980004','ff8080815f0a1cda015f0a23d41e0002','enterprise-admin',NULL,'2017-10-11 14:37:08');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserEntity`
--

DROP TABLE IF EXISTS `UserEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserEntity` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `organization` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci,
  `name` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `isMale` bit(1) DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserEntity`
--

LOCK TABLES `UserEntity` WRITE;
/*!40000 ALTER TABLE `UserEntity` DISABLE KEYS */;
INSERT INTO `UserEntity` VALUES ('admin','default','','admin','admin','admin',1,'','15801632955','1@1.com','1','2017-10-10 16:10:36'),('ff8080815f0a1cda015f0a2aba7e000f','ff8080815f0a1cda015f0a23d41e0002',NULL,'fiona','fiona','fiona',1,'','15801632955','1@1.com','北京','2017-10-11 14:41:33');
/*!40000 ALTER TABLE `UserEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pet_race`
--

DROP TABLE IF EXISTS `t_pet_race`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pet_race` (
  `id` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `organization` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user_id` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pet_race`
--

LOCK TABLES `t_pet_race` WRITE;
/*!40000 ALTER TABLE `t_pet_race` DISABLE KEYS */;
INSERT INTO `t_pet_race` VALUES ('1aa38af8-efd0-4fbb-8c78-d12d17cc9605','ff8080815f0a1cda015f0a23d41e0002','小型犬','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','OK'),('326209c2-59aa-474a-b714-49f3cba8675f','ff8080815f0a1cda015f0a23d41e0002','猫','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','OK'),('34ff5c2e-6625-4d6d-ad39-d1745755b3a8','ff8080815f0a1cda015f0a23d41e0002','中型犬','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','OK'),('41fa0032-2400-4ffc-8e16-ed4ec2e6d1c5','ff8080815f0a1cda015f0a23d41e0002','兔','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','OK'),('aa00b4e5-4668-494a-9799-b2ec542a7205','ff8080815f0a1cda015f0a23d41e0002','大型犬','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','2016-10-24 04:37:28','fc5db3b3-4063-4a12-a511-880ba19e4b58','OK');
/*!40000 ALTER TABLE `t_pet_race` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-11 15:31:32
