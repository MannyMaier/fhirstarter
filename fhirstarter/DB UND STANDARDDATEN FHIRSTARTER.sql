-- MariaDB dump 10.19  Distrib 10.4.27-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: fhirstarter
-- ------------------------------------------------------
-- Server version	10.4.27-MariaDB

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
-- Table structure for table `ad_address`
--

DROP TABLE IF EXISTS `ad_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad_address` (
  `ad_city` varchar(255) DEFAULT NULL,
  `ad_country` varchar(255) DEFAULT NULL,
  `ad_district` varchar(255) DEFAULT NULL,
  `ad_pa_id` varchar(255) DEFAULT NULL,
  `ad_pe_id` varchar(255) DEFAULT NULL,
  `ad_postal_code` varchar(255) DEFAULT NULL,
  `ad_pr_id` varchar(255) DEFAULT NULL,
  `ad_state` varchar(255) DEFAULT NULL,
  `ad_text` varchar(255) DEFAULT NULL,
  `ad_typecode` enum('both','physical','postal') DEFAULT NULL,
  `ad_usecode` enum('billing','home','old','temp','work') DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_p6gph995d4kftnhg2ydovaelt` (`ad_pe_id`),
  KEY `FKqrnuo8hgpjbcunw1pj3wsuyhw` (`ad_pr_id`),
  KEY `FK6l02nxelgx3cugcclv0m5i7ea` (`ad_pa_id`),
  CONSTRAINT `FK6l02nxelgx3cugcclv0m5i7ea` FOREIGN KEY (`ad_pa_id`) REFERENCES `pa_patient` (`id`),
  CONSTRAINT `FK81vapv2xago7k29793nq7kvre` FOREIGN KEY (`ad_pe_id`) REFERENCES `pe_period` (`id`),
  CONSTRAINT `FKqrnuo8hgpjbcunw1pj3wsuyhw` FOREIGN KEY (`ad_pr_id`) REFERENCES `pr_practitioner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad_address`
--

LOCK TABLES `ad_address` WRITE;
/*!40000 ALTER TABLE `ad_address` DISABLE KEYS */;
INSERT INTO `ad_address` VALUES ('New York','USA','Manhattan','123 Main St','2022-01-01','10001',NULL,'NY','Home Address','both','home','1'),('San Francisco','USA','Financial District','456 Market St','2022-01-02','94105',NULL,'CA','Work Address','postal','work','2'),('Los Angeles','USA','Hollywood','789 Sunset Blvd','2022-01-03','90028',NULL,'CA','Temporary Address','physical','temp','3');
/*!40000 ALTER TABLE `ad_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ad_line`
--

DROP TABLE IF EXISTS `ad_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad_line` (
  `address_id` varchar(255) NOT NULL,
  `line` varchar(255) DEFAULT NULL,
  KEY `FKqot8jx2vy5gn9itb9609mqbtu` (`address_id`),
  CONSTRAINT `FKqot8jx2vy5gn9itb9609mqbtu` FOREIGN KEY (`address_id`) REFERENCES `ad_address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad_line`
--

LOCK TABLES `ad_line` WRITE;
/*!40000 ALTER TABLE `ad_line` DISABLE KEYS */;
INSERT INTO `ad_line` VALUES ('1','Apartment 5B'),('2','Suite 1000'),('3','Building C');
/*!40000 ALTER TABLE `ad_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `at_at1plf`
--

DROP TABLE IF EXISTS `at_at1plf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `at_at1plf` (
  `at_size` int(11) DEFAULT NULL,
  `at_creation` datetime(6) DEFAULT NULL,
  `at_id` varchar(255) NOT NULL,
  `at_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`at_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `at_at1plf`
--

LOCK TABLES `at_at1plf` WRITE;
/*!40000 ALTER TABLE `at_at1plf` DISABLE KEYS */;
INSERT INTO `at_at1plf` VALUES (1024,'2022-01-01 12:00:00.000000','1','Document 1'),(2048,'2022-01-02 14:30:00.000000','2','Report 1'),(4096,'2022-01-03 10:45:00.000000','3','Presentation 1');
/*!40000 ALTER TABLE `at_at1plf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `at_attachment`
--

DROP TABLE IF EXISTS `at_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `at_attachment` (
  `at_duration` double DEFAULT NULL,
  `at_frames` int(11) DEFAULT NULL,
  `at_height` int(11) DEFAULT NULL,
  `at_pages` int(11) DEFAULT NULL,
  `at_size` int(11) DEFAULT NULL,
  `at_width` int(11) DEFAULT NULL,
  `at_creation` datetime(6) DEFAULT NULL,
  `at_content_type` enum('aac','abw','apng','arc','avi','avif','azw','bin','bmp','bz','bz2','cda','csh','css','csv','doc','docx','eot','epub','gif','gz','htm','html','ico','ics','jar','jpeg','jpg','js','json','jsonld','mid','midi','mjs','mp3','mp4','mpeg','mpkg','odp','ods','odt','oga','ogv','ogx','opus','otf','pdf','php','png','ppt','pptx','rar','rtf','seven_z','sh','svg','tar','three_g2','three_gp','tiff','ts','ttf','txt','vsd','wav','weba','webm','webp','woff','woff2','xhtml','xls','xlsx','xml','xul','zip') DEFAULT NULL,
  `at_hash` varchar(255) DEFAULT NULL,
  `at_language` enum('ar','bg','bg_bg','bn','bs','bs_ba','cs','cs_cz','da','da_dk','de','de_at','de_ch','de_de','el','el_gr','en','en_au','en_ca','en_gb','en_in','en_nz','en_sg','en_us','es','es_ar','es_es','es_uy','et','et_ee','fi','fi_fi','fr','fr_be','fr_ca','fr_ch','fr_fr','fy','fy_nl','hi','hr','hr_hr','is','is_is','it','it_ch','it_it','ja','ko','lt','lt_lt','lv','lv_lv','nl','nl_be','nl_nl','no','no_no','pa','pl','pl_pl','pt','pt_br','pt_pt','ro','ro_ro','ru','ru_ru','sk','sk_sk','sl','sl_si','sr','sr_rs','sv','sv_se','te','zh','zh_cn','zh_hk','zh_sg','zh_tw') DEFAULT NULL,
  `at_pa_id` blob DEFAULT NULL,
  `at_pr_id` varchar(255) DEFAULT NULL,
  `at_title` varchar(255) DEFAULT NULL,
  `at_url` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `at_data` longtext DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgybx26npm2ns5qjtl72kmqv4f` (`at_pr_id`),
  CONSTRAINT `FKgybx26npm2ns5qjtl72kmqv4f` FOREIGN KEY (`at_pr_id`) REFERENCES `pr_practitioner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `at_attachment`
--

LOCK TABLES `at_attachment` WRITE;
/*!40000 ALTER TABLE `at_attachment` DISABLE KEYS */;
INSERT INTO `at_attachment` VALUES (120.5,30,720,10,2048,1280,'2022-01-01 08:30:00.000000','pdf','abcdef123456','en',NULL,NULL,'Attachment 1','http://example.com/attachment1','1',NULL),(180.2,24,1080,15,4096,1920,'2022-01-02 15:45:00.000000','jpg','ghijkl789012','es',NULL,NULL,'Attachment 2','http://example.com/attachment2','2',NULL),(90.7,20,480,5,1024,640,'2022-01-03 11:15:00.000000','docx','mnopqr345678','fr',NULL,NULL,'Attachment 3','http://example.com/attachment3','3',NULL);
/*!40000 ALTER TABLE `at_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cc_codeableconcept`
--

DROP TABLE IF EXISTS `cc_codeableconcept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cc_codeableconcept` (
  `cc_text` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cc_codeableconcept`
--

LOCK TABLES `cc_codeableconcept` WRITE;
/*!40000 ALTER TABLE `cc_codeableconcept` DISABLE KEYS */;
INSERT INTO `cc_codeableconcept` VALUES ('Concept 1','1'),('Concept 2','2'),('Concept 3','3');
/*!40000 ALTER TABLE `cc_codeableconcept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `co_coding`
--

DROP TABLE IF EXISTS `co_coding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `co_coding` (
  `co_user_selected` bit(1) DEFAULT NULL,
  `co_cc_id` varchar(255) DEFAULT NULL,
  `co_code` varchar(255) DEFAULT NULL,
  `co_display` varchar(255) DEFAULT NULL,
  `co_system` varchar(255) DEFAULT NULL,
  `co_version` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdv5g70ehlvk53bls0yo7bykwy` (`co_cc_id`),
  CONSTRAINT `FKdv5g70ehlvk53bls0yo7bykwy` FOREIGN KEY (`co_cc_id`) REFERENCES `cc_codeableconcept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `co_coding`
--

LOCK TABLES `co_coding` WRITE;
/*!40000 ALTER TABLE `co_coding` DISABLE KEYS */;
INSERT INTO `co_coding` VALUES ('','1','A001','Code A','http://example.com/systemA','1.0','1'),('\0','2','B002','Code B','http://example.com/systemB','2.0','2'),('','3','C003','Code C','http://example.com/systemC','3.0','3');
/*!40000 ALTER TABLE `co_coding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `com_communication`
--

DROP TABLE IF EXISTS `com_communication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `com_communication` (
  `com_preferred` bit(1) DEFAULT NULL,
  `com_language` varchar(255) DEFAULT NULL,
  `com_pr_id` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9fm0x4kyn74uyl66rlqra13yd` (`com_language`),
  KEY `FKm3qhbivm5wtx5ab9qfggn1hik` (`com_pr_id`),
  CONSTRAINT `FKm3qhbivm5wtx5ab9qfggn1hik` FOREIGN KEY (`com_pr_id`) REFERENCES `pr_practitioner` (`id`),
  CONSTRAINT `FKsilend3qsudrhj04vyltiuj4b` FOREIGN KEY (`com_language`) REFERENCES `cc_codeableconcept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `com_communication`
--

LOCK TABLES `com_communication` WRITE;
/*!40000 ALTER TABLE `com_communication` DISABLE KEYS */;
/*!40000 ALTER TABLE `com_communication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cp_contactpoint`
--

DROP TABLE IF EXISTS `cp_contactpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cp_contactpoint` (
  `cp_rank` int(11) DEFAULT NULL,
  `cp_contactkind` enum('home','mobile','old','temp','work') DEFAULT NULL,
  `cp_pa_id` varchar(255) DEFAULT NULL,
  `cp_pe_id` varchar(255) DEFAULT NULL,
  `cp_pr_id` varchar(255) DEFAULT NULL,
  `cp_systemcode` enum('email','fax','other','pager','phone','sms','url') DEFAULT NULL,
  `cp_value` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_99t0vx920tj1v4qk8ug9nhe2w` (`cp_pe_id`),
  KEY `FK1ioefhlnsl4oh1vv8v1ctwsg4` (`cp_pr_id`),
  KEY `FK9sskotpwyhdbg3d2itsselguw` (`cp_pa_id`),
  CONSTRAINT `FK1ioefhlnsl4oh1vv8v1ctwsg4` FOREIGN KEY (`cp_pr_id`) REFERENCES `pr_practitioner` (`id`),
  CONSTRAINT `FK238plb12o8pc2fgpm5p1ctrb6` FOREIGN KEY (`cp_pe_id`) REFERENCES `pe_period` (`id`),
  CONSTRAINT `FK9sskotpwyhdbg3d2itsselguw` FOREIGN KEY (`cp_pa_id`) REFERENCES `pa_patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cp_contactpoint`
--

LOCK TABLES `cp_contactpoint` WRITE;
/*!40000 ALTER TABLE `cp_contactpoint` DISABLE KEYS */;
INSERT INTO `cp_contactpoint` VALUES (1,'home','123456789','2022-01-01',NULL,'phone','123-456-7890','1'),(2,'work','work@example.com','2022-01-02',NULL,'email','work@example.com','2'),(3,'temp','987654321','2022-01-03',NULL,'sms','987-654-3210','3');
/*!40000 ALTER TABLE `cp_contactpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `g_greeting`
--

DROP TABLE IF EXISTS `g_greeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `g_greeting` (
  `l` bigint(20) NOT NULL,
  `format` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `g_greeting`
--

LOCK TABLES `g_greeting` WRITE;
/*!40000 ALTER TABLE `g_greeting` DISABLE KEYS */;
INSERT INTO `g_greeting` VALUES (1,'Hello, {name}!','1'),(2,'Greetings, {name}!','2'),(3,'Hi there, {name}!','3');
/*!40000 ALTER TABLE `g_greeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hn_human_name`
--

DROP TABLE IF EXISTS `hn_human_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hn_human_name` (
  `hn_family` varchar(255) DEFAULT NULL,
  `hn_pa_id` varchar(255) DEFAULT NULL,
  `hn_pe_id` varchar(255) DEFAULT NULL,
  `hn_pr_id` varchar(255) DEFAULT NULL,
  `hn_statuscode` enum('anonymus','maiden','nickname','official','old','temp','usual') DEFAULT NULL,
  `hn_text` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_emddjiejsnj0a8xjocq5jfipc` (`hn_pe_id`),
  KEY `FK7ddsd6npngv4p4u6ydrbsyuyn` (`hn_pr_id`),
  KEY `FKootni24rbo33utjt7jq2ocfoy` (`hn_pa_id`),
  CONSTRAINT `FK72a0m7grjv7vge4t4uqds9625` FOREIGN KEY (`hn_pe_id`) REFERENCES `pe_period` (`id`),
  CONSTRAINT `FK7ddsd6npngv4p4u6ydrbsyuyn` FOREIGN KEY (`hn_pr_id`) REFERENCES `pr_practitioner` (`id`),
  CONSTRAINT `FKootni24rbo33utjt7jq2ocfoy` FOREIGN KEY (`hn_pa_id`) REFERENCES `pa_patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hn_human_name`
--

LOCK TABLES `hn_human_name` WRITE;
/*!40000 ALTER TABLE `hn_human_name` DISABLE KEYS */;
INSERT INTO `hn_human_name` VALUES ('Doe',NULL,'2022-01-01',NULL,'official','John Doe','1'),('Smith',NULL,'2022-01-02',NULL,'usual','Jane Smith','2'),('Johnson',NULL,'2022-01-03',NULL,'maiden','Alice Johnson','3');
/*!40000 ALTER TABLE `hn_human_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human_name_given`
--

DROP TABLE IF EXISTS `human_name_given`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human_name_given` (
  `given` varchar(255) DEFAULT NULL,
  `human_name_id` varchar(255) NOT NULL,
  KEY `FKpogbapue2mtpid33aqu8mpa22` (`human_name_id`),
  CONSTRAINT `FKpogbapue2mtpid33aqu8mpa22` FOREIGN KEY (`human_name_id`) REFERENCES `hn_human_name` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human_name_given`
--

LOCK TABLES `human_name_given` WRITE;
/*!40000 ALTER TABLE `human_name_given` DISABLE KEYS */;
INSERT INTO `human_name_given` VALUES ('John','1'),('Jane','2'),('Alice','3');
/*!40000 ALTER TABLE `human_name_given` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human_name_prefix`
--

DROP TABLE IF EXISTS `human_name_prefix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human_name_prefix` (
  `human_name_id` varchar(255) NOT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  KEY `FKbuhytakbm1qeomgddmj19ft06` (`human_name_id`),
  CONSTRAINT `FKbuhytakbm1qeomgddmj19ft06` FOREIGN KEY (`human_name_id`) REFERENCES `hn_human_name` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human_name_prefix`
--

LOCK TABLES `human_name_prefix` WRITE;
/*!40000 ALTER TABLE `human_name_prefix` DISABLE KEYS */;
INSERT INTO `human_name_prefix` VALUES ('1','Mr.'),('2','Ms.'),('3','Mrs.');
/*!40000 ALTER TABLE `human_name_prefix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human_name_suffix`
--

DROP TABLE IF EXISTS `human_name_suffix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human_name_suffix` (
  `human_name_id` varchar(255) NOT NULL,
  `suffix` varchar(255) DEFAULT NULL,
  KEY `FK133k7p7y228fyxfuuksaufm76` (`human_name_id`),
  CONSTRAINT `FK133k7p7y228fyxfuuksaufm76` FOREIGN KEY (`human_name_id`) REFERENCES `hn_human_name` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human_name_suffix`
--

LOCK TABLES `human_name_suffix` WRITE;
/*!40000 ALTER TABLE `human_name_suffix` DISABLE KEYS */;
INSERT INTO `human_name_suffix` VALUES ('1','Jr.'),('2','II'),('3','Sr.');
/*!40000 ALTER TABLE `human_name_suffix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id_identifier`
--

DROP TABLE IF EXISTS `id_identifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id_identifier` (
  `id` varchar(255) NOT NULL,
  `id_cc_id` varchar(255) DEFAULT NULL,
  `id_pa_id` varchar(255) DEFAULT NULL,
  `id_pe_id` varchar(255) DEFAULT NULL,
  `id_pr_id` varchar(255) DEFAULT NULL,
  `id_qu_id` varchar(255) DEFAULT NULL,
  `id_re_id` varchar(255) DEFAULT NULL,
  `id_system` varchar(255) DEFAULT NULL,
  `id_use` enum('official','old','secondary','temp','usual') DEFAULT NULL,
  `id_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_92f8rjj7fti2h7b8j0lvqiq8s` (`id_cc_id`),
  UNIQUE KEY `UK_4sm0tmrb7wcv7l0yybbpr2dxw` (`id_pe_id`),
  UNIQUE KEY `UK_kjckfdxyepsljooccewd3qrc8` (`id_re_id`),
  KEY `FK27srhi9smep09hkhf5xxw4rsq` (`id_qu_id`),
  KEY `FKpflek4t6jc2fcrvkp1qecgx7n` (`id_pr_id`),
  KEY `FKt8dqg13k626mio8y90jgkusk1` (`id_pa_id`),
  CONSTRAINT `FK27srhi9smep09hkhf5xxw4rsq` FOREIGN KEY (`id_qu_id`) REFERENCES `qu_qualification` (`id`),
  CONSTRAINT `FKef7w1umkh6imom5i4elt0nj2i` FOREIGN KEY (`id_re_id`) REFERENCES `re_reference` (`id`),
  CONSTRAINT `FKep4hirhefllk70jjf4sltoxln` FOREIGN KEY (`id_cc_id`) REFERENCES `cc_codeableconcept` (`id`),
  CONSTRAINT `FKifmohadnyglw2ttmxuygsxh2j` FOREIGN KEY (`id_pe_id`) REFERENCES `pe_period` (`id`),
  CONSTRAINT `FKpflek4t6jc2fcrvkp1qecgx7n` FOREIGN KEY (`id_pr_id`) REFERENCES `pr_practitioner` (`id`),
  CONSTRAINT `FKt8dqg13k626mio8y90jgkusk1` FOREIGN KEY (`id_pa_id`) REFERENCES `pa_patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id_identifier`
--

LOCK TABLES `id_identifier` WRITE;
/*!40000 ALTER TABLE `id_identifier` DISABLE KEYS */;
INSERT INTO `id_identifier` VALUES ('1','1','1','1',NULL,NULL,'1','identifiertest','old','value odf identifier');
/*!40000 ALTER TABLE `id_identifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `na_narrative`
--

DROP TABLE IF EXISTS `na_narrative`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `na_narrative` (
  `id` varchar(255) NOT NULL,
  `na_div` varchar(255) DEFAULT NULL,
  `na_status` enum('additional','empty','extensions','generated') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `na_narrative`
--

LOCK TABLES `na_narrative` WRITE;
/*!40000 ALTER TABLE `na_narrative` DISABLE KEYS */;
INSERT INTO `na_narrative` VALUES ('1','<div>Document 1 content</div>','generated'),('2','<div>Report 1 content</div>','additional'),('3','<div>Presentation 1 content</div>','empty');
/*!40000 ALTER TABLE `na_narrative` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pa_patient`
--

DROP TABLE IF EXISTS `pa_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pa_patient` (
  `pa_active` bit(1) DEFAULT NULL,
  `pa_deceasedboolean` bit(1) DEFAULT NULL,
  `pa_birthdate` datetime(6) DEFAULT NULL,
  `pa_deceaseddatetime` datetime(6) DEFAULT NULL,
  `dr_na_id` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `pa_gender` enum('female','male','other','unknown') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l6xm1e53usuiwf15vh292pvra` (`dr_na_id`),
  CONSTRAINT `FK9w5wfg64let7ph5n00pxfqnyq` FOREIGN KEY (`dr_na_id`) REFERENCES `na_narrative` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pa_patient`
--

LOCK TABLES `pa_patient` WRITE;
/*!40000 ALTER TABLE `pa_patient` DISABLE KEYS */;
INSERT INTO `pa_patient` VALUES ('','\0','1990-05-15 00:00:00.000000',NULL,'1','1','male'),('','','1985-03-20 00:00:00.000000','2022-01-02 12:30:00.000000','2','2','female'),('\0','\0','2000-10-10 00:00:00.000000',NULL,'3','3','other');
/*!40000 ALTER TABLE `pa_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_period`
--

DROP TABLE IF EXISTS `pe_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pe_period` (
  `pe_end` datetime(6) DEFAULT NULL,
  `pe_start` datetime(6) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_period`
--

LOCK TABLES `pe_period` WRITE;
/*!40000 ALTER TABLE `pe_period` DISABLE KEYS */;
INSERT INTO `pe_period` VALUES ('2022-01-01 00:00:00.000000','2021-01-01 00:00:00.000000','1'),('2022-01-02 00:00:00.000000','2021-02-01 00:00:00.000000','2'),('2022-01-03 00:00:00.000000','2021-03-01 00:00:00.000000','3');
/*!40000 ALTER TABLE `pe_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pr_practitioner`
--

DROP TABLE IF EXISTS `pr_practitioner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pr_practitioner` (
  `pr_active` bit(1) DEFAULT NULL,
  `pr_birthdate` date DEFAULT NULL,
  `dr_na_id` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `pr_gender` enum('female','male','other','unknown') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r309guhwtde6p4cqlv3vsnpuo` (`dr_na_id`),
  CONSTRAINT `FKldhn0adt9d18uxdb3teq9mmpw` FOREIGN KEY (`dr_na_id`) REFERENCES `na_narrative` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_practitioner`
--

LOCK TABLES `pr_practitioner` WRITE;
/*!40000 ALTER TABLE `pr_practitioner` DISABLE KEYS */;
/*!40000 ALTER TABLE `pr_practitioner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qu_qualification`
--

DROP TABLE IF EXISTS `qu_qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qu_qualification` (
  `id` varchar(255) NOT NULL,
  `qu_cc_id` varchar(255) DEFAULT NULL,
  `qu_pe_id` varchar(255) DEFAULT NULL,
  `qu_pr_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9ervmo9kw88qiwv4w842m9whf` (`qu_cc_id`),
  UNIQUE KEY `UK_jhlhj06cm0tyvo1psw7o4bwqn` (`qu_pe_id`),
  KEY `FK1xmrr27icglnjbq1o5jaa5k7a` (`qu_pr_id`),
  CONSTRAINT `FK1xmrr27icglnjbq1o5jaa5k7a` FOREIGN KEY (`qu_pr_id`) REFERENCES `pr_practitioner` (`id`),
  CONSTRAINT `FKmrqiwf1mcbuafjtvv18mp0wb4` FOREIGN KEY (`qu_cc_id`) REFERENCES `cc_codeableconcept` (`id`),
  CONSTRAINT `FKtomi3e9mx9t9bj1q6k8qn73jh` FOREIGN KEY (`qu_pe_id`) REFERENCES `pe_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qu_qualification`
--

LOCK TABLES `qu_qualification` WRITE;
/*!40000 ALTER TABLE `qu_qualification` DISABLE KEYS */;
/*!40000 ALTER TABLE `qu_qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `re_reference`
--

DROP TABLE IF EXISTS `re_reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `re_reference` (
  `id` varchar(255) NOT NULL,
  `re_display` varchar(255) DEFAULT NULL,
  `re_id_id` varchar(255) DEFAULT NULL,
  `re_pa_id` varchar(255) DEFAULT NULL,
  `re_reference` varchar(255) DEFAULT NULL,
  `re_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_n2jesi79i9jat2ntffcqdc82b` (`re_id_id`),
  KEY `FKmetasd2291ek69hjd3pteherk` (`re_pa_id`),
  CONSTRAINT `FKmetasd2291ek69hjd3pteherk` FOREIGN KEY (`re_pa_id`) REFERENCES `pa_patient` (`id`),
  CONSTRAINT `FKtawctevraruyt0yl5m2366q83` FOREIGN KEY (`re_id_id`) REFERENCES `id_identifier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `re_reference`
--

LOCK TABLES `re_reference` WRITE;
/*!40000 ALTER TABLE `re_reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `re_reference` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-18 20:25:47
