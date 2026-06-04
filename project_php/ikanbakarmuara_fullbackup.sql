-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: ikanbakarmuara3
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detail_pesanan`
--

DROP TABLE IF EXISTS `detail_pesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_pesanan` (
  `pesanan_id` int NOT NULL,
  `menu_id` char(5) NOT NULL,
  `dp_kuantitas` int NOT NULL,
  `dp_total` int DEFAULT NULL,
  KEY `pesanan_id` (`pesanan_id`),
  KEY `idx_menu_id` (`menu_id`),
  CONSTRAINT `detail_pesanan_ibfk_1` FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`pesanan_id`),
  CONSTRAINT `detail_pesanan_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_pesanan`
--

LOCK TABLES `detail_pesanan` WRITE;
/*!40000 ALTER TABLE `detail_pesanan` DISABLE KEYS */;
INSERT INTO `detail_pesanan` VALUES (2,'M0022',5,130000),(5,'M0003',3,69000),(8,'M0001',4,104000),(13,'M0025',5,115000),(16,'M0038',5,10000),(19,'M0030',1,13000),(21,'M0033',1,6000),(24,'M0037',2,18000),(27,'M0002',1,26000),(30,'M0023',3,60000),(32,'M0021',2,56000),(35,'M0039',5,75000),(38,'M0038',5,10000),(43,'M0016',3,51000),(46,'M0033',5,30000),(49,'M0005',5,35000),(51,'M0033',4,24000),(54,'M0029',4,60000),(57,'M0016',5,85000),(60,'M0039',3,45000),(62,'M0014',2,50440),(65,'M0032',5,30000),(68,'M0037',1,9000),(73,'M0026',5,125000),(76,'M0037',4,36000),(79,'M0033',5,30000),(81,'M0010',3,69000),(84,'M0018',5,190000),(87,'M0007',1,105000),(90,'M0004',1,8000),(92,'M0012',1,23000),(95,'M0033',4,24000),(98,'M0009',5,130000),(1,'M0030',1,13000),(4,'M0018',4,152000),(7,'M0024',4,108000),(10,'M0021',4,112000),(12,'M0024',1,27000),(15,'M0026',5,125000),(18,'M0039',5,75000),(23,'M0035',3,21000),(26,'M0035',5,35000),(29,'M0037',5,45000),(31,'M0037',5,45000),(34,'M0013',1,23000),(37,'M0031',3,18000),(40,'M0031',3,18000),(42,'M0026',3,75000),(45,'M0028',5,90000),(48,'M0022',5,130000),(53,'M0001',2,52000),(56,'M0014',5,126100),(59,'M0011',5,115000),(61,'M0011',5,115000),(64,'M0026',3,75000),(67,'M0035',4,28000),(70,'M0004',1,8000),(72,'M0022',2,52000),(75,'M0028',4,72000),(78,'M0020',2,52000),(83,'M0013',3,69000),(86,'M0012',1,23000),(89,'M0029',2,30000),(91,'M0006',5,126100),(94,'M0012',4,92000),(97,'M0019',2,42000),(100,'M0006',4,100880),(3,'M0010',1,23000),(6,'M0019',2,42000),(9,'M0028',5,90000),(11,'M0002',4,104000),(14,'M0018',1,38000),(17,'M0008',4,180000),(20,'M0033',1,6000),(22,'M0031',4,24000),(25,'M0014',3,75660),(28,'M0016',3,51000),(33,'M0029',5,75000),(36,'M0012',4,92000),(39,'M0038',3,6000),(41,'M0029',1,15000),(44,'M0006',3,75660),(47,'M0038',2,4000),(50,'M0002',1,26000),(52,'M0001',1,26000),(55,'M0038',5,10000),(58,'M0014',1,25220),(63,'M0029',1,15000),(66,'M0027',5,75000),(69,'M0020',4,104000),(71,'M0014',2,50440),(74,'M0037',3,27000),(77,'M0023',3,60000),(80,'M0030',2,26000),(82,'M0003',3,69000),(85,'M0025',2,46000),(88,'M0003',1,23000),(93,'M0024',3,81000),(96,'M0036',5,50000),(99,'M0002',2,52000),(2,'M0025',1,23000),(5,'M0013',3,69000),(8,'M0028',5,90000),(13,'M0025',2,46000),(16,'M0019',3,63000),(19,'M0017',2,198000),(21,'M0021',4,112000),(24,'M0017',2,198000),(27,'M0006',5,126100),(30,'M0035',5,35000),(32,'M0023',2,40000),(35,'M0035',3,21000),(38,'M0031',3,18000),(43,'M0003',5,115000),(46,'M0009',3,78000),(49,'M0027',1,15000),(51,'M0039',5,75000),(54,'M0020',4,104000),(57,'M0019',5,105000),(60,'M0022',4,104000),(62,'M0005',2,14000),(65,'M0019',2,42000),(68,'M0002',2,52000),(73,'M0019',3,63000),(76,'M0032',4,24000),(79,'M0032',1,6000),(81,'M0038',4,8000),(84,'M0012',3,69000),(87,'M0025',4,92000),(90,'M0016',1,17000),(92,'M0002',1,26000),(95,'M0004',2,16000),(98,'M0018',1,38000),(1,'M0023',2,40000),(4,'M0034',2,14000),(7,'M0002',2,52000),(10,'M0038',2,4000),(12,'M0004',5,40000),(15,'M0009',2,52000),(18,'M0003',2,46000),(23,'M0021',3,84000),(26,'M0015',1,24000),(29,'M0008',4,180000),(31,'M0009',5,130000),(34,'M0019',5,105000),(37,'M0035',5,35000),(40,'M0017',4,396000),(42,'M0010',1,23000),(45,'M0029',2,30000),(48,'M0030',3,39000),(53,'M0028',4,72000),(56,'M0030',3,39000),(59,'M0002',5,130000),(61,'M0005',5,35000),(64,'M0026',2,50000),(67,'M0020',3,78000),(70,'M0016',2,34000),(72,'M0002',3,78000),(75,'M0006',2,50440),(78,'M0017',1,99000),(83,'M0035',2,14000),(86,'M0001',1,26000),(89,'M0009',5,130000),(91,'M0009',1,26000),(94,'M0003',5,115000),(97,'M0005',5,35000),(100,'M0024',1,27000),(3,'M0015',4,96000),(6,'M0032',4,24000),(9,'M0036',3,30000),(11,'M0038',1,2000),(14,'M0039',3,45000),(17,'M0016',3,51000),(20,'M0017',3,297000),(22,'M0018',4,152000),(25,'M0035',3,21000),(28,'M0026',5,125000),(33,'M0013',1,23000),(36,'M0010',1,23000),(39,'M0022',4,104000),(41,'M0019',3,63000),(44,'M0037',2,18000),(47,'M0015',1,24000),(50,'M0028',1,18000),(52,'M0039',5,75000),(55,'M0022',1,26000),(58,'M0026',1,25000),(63,'M0017',5,495000),(66,'M0005',5,35000),(69,'M0022',5,130000),(71,'M0021',1,28000),(74,'M0030',4,52000),(77,'M0029',5,75000),(80,'M0009',3,78000),(82,'M0023',3,60000),(85,'M0002',3,78000),(88,'M0021',1,28000),(93,'M0028',2,36000),(96,'M0033',5,30000),(99,'M0016',5,85000),(2,'M0032',1,6000),(5,'M0036',2,20000),(8,'M0006',3,75660),(13,'M0019',4,84000),(16,'M0035',3,21000),(19,'M0027',5,75000),(21,'M0031',1,6000),(24,'M0033',1,6000),(27,'M0033',5,30000),(30,'M0010',2,46000),(32,'M0005',3,21000),(35,'M0038',3,6000),(38,'M0012',1,23000),(43,'M0033',4,24000),(46,'M0013',2,46000),(49,'M0019',3,63000),(51,'M0005',1,7000),(54,'M0002',5,130000),(57,'M0027',3,45000),(60,'M0017',4,396000),(62,'M0034',2,14000),(65,'M0018',1,38000),(68,'M0029',4,60000),(73,'M0039',1,15000),(76,'M0014',3,75660),(79,'M0029',5,75000),(81,'M0031',5,30000),(84,'M0004',5,40000),(87,'M0033',4,24000),(90,'M0037',4,36000),(92,'M0020',3,78000),(95,'M0007',1,105000),(98,'M0015',2,48000),(1,'M0019',3,63000),(4,'M0039',3,45000),(7,'M0013',2,46000),(10,'M0015',1,24000),(12,'M0006',3,75660),(15,'M0010',3,69000),(18,'M0009',2,52000),(23,'M0036',3,30000),(26,'M0010',3,69000),(29,'M0019',1,21000),(31,'M0002',5,130000),(34,'M0015',1,24000),(37,'M0032',3,18000),(40,'M0032',4,24000),(42,'M0010',1,23000),(45,'M0015',4,96000),(48,'M0032',4,24000),(53,'M0031',1,6000),(56,'M0033',1,6000),(59,'M0028',3,54000),(61,'M0003',1,23000),(64,'M0035',2,14000),(67,'M0011',1,23000),(70,'M0003',5,115000),(72,'M0034',5,35000),(75,'M0036',5,50000),(78,'M0021',1,28000),(83,'M0037',2,18000),(86,'M0005',3,21000),(89,'M0034',5,35000),(91,'M0009',1,26000),(94,'M0007',3,315000),(97,'M0020',2,52000),(100,'M0036',4,40000),(3,'M0029',3,45000),(6,'M0026',3,75000),(9,'M0033',3,18000),(11,'M0034',5,35000),(14,'M0002',2,52000),(17,'M0032',5,30000),(20,'M0005',4,28000),(22,'M0027',1,15000),(25,'M0005',3,21000),(28,'M0003',5,115000),(33,'M0003',5,115000),(36,'M0033',4,24000),(39,'M0008',4,180000),(41,'M0011',1,23000),(44,'M0013',3,69000),(47,'M0019',5,105000),(50,'M0018',2,76000),(52,'M0036',5,50000),(55,'M0021',1,28000),(58,'M0033',5,30000),(63,'M0002',3,78000),(66,'M0005',2,14000),(69,'M0036',5,50000),(71,'M0012',1,23000),(74,'M0013',3,69000),(77,'M0013',2,46000),(80,'M0012',4,92000),(82,'M0031',4,24000),(85,'M0006',4,100880),(88,'M0024',2,54000),(93,'M0016',2,34000),(96,'M0001',2,52000),(99,'M0035',2,14000),(128,'M0001',4,104000),(128,'M0002',1,26000),(128,'M0008',1,45000),(128,'M0023',1,20000),(129,'M0002',1,26000),(129,'M0003',1,23000),(129,'M0004',1,8000),(130,'M0001',1,26000),(130,'M0002',1,26000),(130,'M0005',1,7000),(130,'M0006',1,25220),(130,'M0007',1,105000),(130,'M0008',1,45000),(131,'M0001',3,78000),(131,'M0010',1,23000),(132,'M0008',6,270000),(132,'M0009',1,26000),(132,'M0010',1,23000),(132,'M0011',1,23000),(132,'M0012',1,23000),(132,'M0013',1,23000),(133,'M0001',3,78000),(133,'M0004',1,8000),(133,'M0005',1,7000),(133,'M0010',1,23000),(133,'M0014',1,25220),(133,'M0016',1,17000),(133,'M0018',1,38000),(133,'M0020',1,26000),(133,'M0022',1,26000),(133,'M0031',1,6000),(134,'M0004',4,32000),(134,'M0005',4,28000),(134,'M0038',4,8000),(134,'M0039',3,45000),(134,'M0001',1,26000),(134,'M0002',1,26000),(134,'M0003',1,23000),(134,'M0006',1,25220),(134,'M0008',1,45000),(134,'M0009',1,26000),(135,'M0001',1,26000),(135,'M0029',1,15000),(136,'M0001',1,26000),(136,'M0002',1,26000),(136,'M0004',6,48000),(136,'M0006',2,50440),(136,'M0008',1,45000),(136,'M0007',7,735000),(137,'M0002',1,26000),(141,'M0001',1,26000),(141,'M0003',1,23000),(141,'M0004',1,8000),(141,'M0005',1,7000),(141,'M0006',1,25220),(141,'M0002',1,26000),(145,'M0002',5,130000),(145,'M0003',1,23000),(145,'M0008',1,45000),(147,'M0001',9,234000),(147,'M0003',1,23000),(147,'M0004',1,8000),(147,'M0005',2,14000),(147,'M0007',1,105000),(147,'M0009',1,26000),(148,'M0001',5,130000),(148,'M0002',5,130000),(150,'M0001',1,26000),(150,'M0003',1,23000),(150,'M0004',1,8000),(150,'M0005',1,7000),(150,'M0006',1,25220),(150,'M0007',1,105000),(150,'M0002',1,26000),(150,'M0011',1,23000),(150,'M0012',1,23000),(150,'M0028',1,18000),(151,'M0005',2,14000),(151,'M0007',3,315000),(151,'M0009',4,104000),(151,'M0011',3,69000),(151,'M0014',3,75660),(152,'M0001',2,52000),(152,'M0002',2,52000),(153,'M0001',3,78000),(153,'M0002',3,60000),(154,'M0002',4,80000),(154,'M0003',10,230000),(154,'M0007',10,1050000);
/*!40000 ALTER TABLE `detail_pesanan` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_validasi_detail_pesanan` BEFORE INSERT ON `detail_pesanan` FOR EACH ROW BEGIN
IF NEW.dp_kuantitas < 1 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Kuantitas tidak valid';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_total` BEFORE INSERT ON `detail_pesanan` FOR EACH ROW BEGIN
DECLARE harga INT;
SELECT menu_harga INTO harga
FROM menu
WHERE menu_id = NEW.menu_id;
SET NEW.dp_total = hitung_dp_total(NEW.dp_kuantitas, harga);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_grandtotal` AFTER INSERT ON `detail_pesanan` FOR EACH ROW BEGIN
    UPDATE pesanan
    SET pesanan_grandtotal = hitung_grandtotal(NEW.pesanan_id)
    WHERE pesanan_id = NEW.pesanan_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `upd_det` BEFORE UPDATE ON `detail_pesanan` FOR EACH ROW begin
declare hargamenu int;
select menu_harga into hargamenu
from menu
where menu_id=old.menu_id;
set new.dp_total=hitung_dp_total(hargamenu,new.dp_kuantitas);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_grandtotal_update` AFTER UPDATE ON `detail_pesanan` FOR EACH ROW BEGIN
    UPDATE pesanan
    SET pesanan_grandtotal = hitung_grandtotal(NEW.pesanan_id)
    WHERE pesanan_id = NEW.pesanan_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_update_grandtotal_delete` AFTER DELETE ON `detail_pesanan` FOR EACH ROW BEGIN
    UPDATE pesanan
    SET pesanan_grandtotal = hitung_grandtotal(OLD.pesanan_id)
    WHERE pesanan_id = OLD.pesanan_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `kasir`
--

DROP TABLE IF EXISTS `kasir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kasir` (
  `kasir_id` char(3) NOT NULL,
  `kasir_nama` varchar(30) NOT NULL,
  `kasir_noHP` varchar(15) DEFAULT NULL,
  `kasir_status` enum('Kasir Jaga','Kasir Jalan') DEFAULT 'Kasir Jaga',
  PRIMARY KEY (`kasir_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kasir`
--

LOCK TABLES `kasir` WRITE;
/*!40000 ALTER TABLE `kasir` DISABLE KEYS */;
INSERT INTO `kasir` VALUES ('K01','Gama','089677889954','Kasir Jalan'),('K02','Fanny','089677765489','Kasir Jaga'),('K03','Hana','089665437899','Kasir Jaga'),('K04','Ilma','089546979965','Kasir Jalan'),('K05','Jaka','081264611114','Kasir Jalan');
/*!40000 ALTER TABLE `kasir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_id` char(5) NOT NULL,
  `menu_nama` varchar(50) NOT NULL,
  `menu_kategori` enum('Makanan','Minuman','Tambahan') NOT NULL,
  `menu_harga` int DEFAULT '0',
  `menu_status` enum('Tersedia','Tidak Tersedia') DEFAULT 'Tersedia',
  PRIMARY KEY (`menu_id`),
  KEY `idx_menu_menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('M0001','Nila Bakar Muara','Makanan',26000,'Tidak Tersedia'),('M0002','Nila Bakar Madu','Makanan',20000,'Tersedia'),('M0003','Nila Goreng','Makanan',23000,'Tersedia'),('M0004','Jeruk Kecil','Minuman',8000,'Tersedia'),('M0005','Lemon Tea','Minuman',7000,'Tersedia'),('M0006','Ayam Bakar Rica','Makanan',25220,'Tersedia'),('M0007','Udang Galah Saos Padang','Makanan',105000,'Tersedia'),('M0008','Udang Wangkang Bakar Madu','Makanan',45000,'Tersedia'),('M0009','Cumi Saos Padang','Makanan',26000,'Tersedia'),('M0010','Nila Saos Lada Hitam','Makanan',23000,'Tersedia'),('M0011','Nila Saos Padang','Makanan',23000,'Tersedia'),('M0012','Nila Saos Asam Manis','Makanan',23000,'Tersedia'),('M0013','Ayam Goreng Kremes New','Makanan',23000,'Tersedia'),('M0014','Ayam Bakar Rica','Makanan',25220,'Tersedia'),('M0015','Ayam Bakar Madu','Makanan',24000,'Tersedia'),('M0016','Kepala Cumi Goreng Tepung','Makanan',17000,'Tersedia'),('M0017','Udang Galah Goreng','Makanan',99000,'Tersedia'),('M0018','Udang Wangkang Goreng','Makanan',38000,'Tersedia'),('M0019','Cumi Goreng Tepung','Makanan',21000,'Tersedia'),('M0020','Cumi Asam Manis','Makanan',26000,'Tersedia'),('M0021','Udang Telur Asin','Makanan',28000,'Tersedia'),('M0022','Cumi Lada Hitam','Makanan',26000,'Tersedia'),('M0023','Kepala Cumi Saos Padang','Makanan',20000,'Tersedia'),('M0024','Cumi Telur Asin','Makanan',27000,'Tersedia'),('M0025','Udang Goreng Tepung','Makanan',23000,'Tersedia'),('M0026','Kerang Saos Padang','Makanan',25000,'Tidak Tersedia'),('M0027','Tumis Pakis','Makanan',15000,'Tersedia'),('M0028','Pakcoy Tofu','Makanan',18000,'Tersedia'),('M0029','Tumis Kangkung','Makanan',15000,'Tersedia'),('M0030','Sayur Asam','Makanan',13000,'Tersedia'),('M0031','Sambal Belacan','Makanan',6000,'Tersedia'),('M0032','Sambal Kecap','Makanan',6000,'Tersedia'),('M0033','Sambal Tomat','Makanan',6000,'Tersedia'),('M0034','Nasi Putih','Makanan',7000,'Tersedia'),('M0035','Kol Goreng','Makanan',7000,'Tersedia'),('M0036','Tahu Goreng','Makanan',10000,'Tersedia'),('M0037','Tempe Goreng','Makanan',9000,'Tersedia'),('M0038','Es Kosong','Minuman',2000,'Tersedia'),('M0039','Jeruk Besar','Minuman',15000,'Tersedia');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_validasi_menu` BEFORE INSERT ON `menu` FOR EACH ROW BEGIN
IF NEW.menu_harga < 1 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Harga menu tidak valid';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `pelanggan`
--

DROP TABLE IF EXISTS `pelanggan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelanggan` (
  `pelanggan_noHP` varchar(15) NOT NULL,
  `pelanggan_nama` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pelanggan_noHP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelanggan`
--

LOCK TABLES `pelanggan` WRITE;
/*!40000 ALTER TABLE `pelanggan` DISABLE KEYS */;
INSERT INTO `pelanggan` VALUES ('',''),('081100000001','Pelanggan 1'),('081100000002','Pelanggan 2'),('081100000003','Pelanggan 3'),('081100000004','Pelanggan 4'),('081100000005','Pelanggan 5'),('081100000006','Pelanggan 6'),('081100000007','Pelanggan 7'),('081100000008','Pelanggan 8'),('081100000009','Pelanggan 9'),('081100000010','Pelanggan 10'),('081100000011','Pelanggan 11'),('081100000012','Pelanggan 12'),('081100000013','Pelanggan 13'),('081100000014','Pelanggan 14'),('081100000015','Pelanggan 15'),('081100000016','Pelanggan 16'),('081100000017','Pelanggan 17'),('081100000018','Pelanggan 18'),('081100000019','Pelanggan 19'),('081100000020','Pelanggan 20'),('081100000021','Pelanggan 21'),('081100000022','Pelanggan 22'),('081100000023','Pelanggan 23'),('081100000024','Pelanggan 24'),('081100000025','Pelanggan 25'),('081100000026','Pelanggan 26'),('081100000027','Pelanggan 27'),('081100000028','Pelanggan 28'),('081100000029','Pelanggan 29'),('081100000030','Pelanggan 30'),('081100000031','Pelanggan 31'),('081100000032','Pelanggan 32'),('081100000033','Pelanggan 33'),('081100000034','Pelanggan 34'),('081100000035','Pelanggan 35'),('081100000036','Pelanggan 36'),('081100000037','Pelanggan 37'),('081100000038','Pelanggan 38'),('081100000039','Pelanggan 39'),('081100000040','Pelanggan 40'),('081100000041','Pelanggan 41'),('081100000042','Pelanggan 42'),('081100000043','Pelanggan 43'),('081100000044','Pelanggan 44'),('081100000045','Pelanggan 45'),('081100000046','Pelanggan 46'),('081100000047','Pelanggan 47'),('081100000048','Pelanggan 48'),('081100000049','Pelanggan 49'),('081100000050','Pelanggan 50'),('081100000051','Pelanggan 51'),('081100000052','Pelanggan 52'),('081100000053','Pelanggan 53'),('081100000054','Pelanggan 54'),('081100000055','Pelanggan 55'),('081100000056','Pelanggan 56'),('081100000057','Pelanggan 57'),('081100000058','Pelanggan 58'),('081100000059','Pelanggan 59'),('081100000060','Pelanggan 60'),('081100000061','Pelanggan 61'),('081100000062','Pelanggan 62'),('081100000063','Pelanggan 63'),('081100000064','Pelanggan 64'),('081100000065','Pelanggan 65'),('081100000066','Pelanggan 66'),('081100000067','Pelanggan 67'),('081100000068','Pelanggan 68'),('081100000069','Pelanggan 69'),('081100000070','Pelanggan 70'),('081100000071','Pelanggan 71'),('081100000072','Pelanggan 72'),('081100000073','Pelanggan 73'),('081100000074','Pelanggan 74'),('081100000075','Pelanggan 75'),('081100000076','Pelanggan 76'),('081100000077','Pelanggan 77'),('081100000078','Pelanggan 78'),('081100000079','Pelanggan 79'),('081100000080','Pelanggan 80'),('081100000081','Pelanggan 81'),('081100000082','Pelanggan 82'),('081100000083','Pelanggan 83'),('081100000084','Pelanggan 84'),('081100000085','Pelanggan 85'),('081100000086','Pelanggan 86'),('081100000087','Pelanggan 87'),('081100000088','Pelanggan 88'),('081100000089','Pelanggan 89'),('081100000090','Pelanggan 90'),('081100000091','Pelanggan 91'),('081100000092','Pelanggan 92'),('081100000093','Pelanggan 93'),('081100000094','Pelanggan 94'),('081100000095','Pelanggan 95'),('081100000096','Pelanggan 96'),('081100000097','Pelanggan 97'),('081100000098','Pelanggan 98'),('081100000099','Pelanggan 99'),('081100000100','Pelanggan 100'),('081234452311','Celine'),('081234567893','Faliha'),('081256901232','Violaine'),('0812569012323','Lalalala'),('081256901234','Violaine'),('081256901278','vio'),('081265361980','Benna'),('089476433298','Edward'),('089547689688','Daniel'),('089698722567','Amy'),('123','sdad'),('12312231231231','eeee'),('1233423','sdfsdf'),('1233423424234','sdfsdf'),('1234123','sdfsdf'),('13323423434','sdfsdf'),('234234','sdfsdf'),('234234234234','sdfsdf'),('23423423434','erwerwerw'),('34232322312','sdfsdf'),('342323223122','sdasd'),('34234234','vio'),('342453453','sdfsdf'),('3432535','vsdov'),('9128392','sdfsdf'),('923489234234','sdfsdf'),('923489234342','sdfsdf');
/*!40000 ALTER TABLE `pelanggan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesanan`
--

DROP TABLE IF EXISTS `pesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pesanan` (
  `pesanan_id` int NOT NULL AUTO_INCREMENT,
  `kasir_id` char(3) DEFAULT NULL,
  `pelanggan_noHP` varchar(15) NOT NULL,
  `pesanan_tanggal` date NOT NULL,
  `pesanan_noMeja` varchar(3) DEFAULT NULL,
  `pesanan_jenis` enum('Dine in','Take away') DEFAULT 'Dine in',
  `pesanan_grandtotal` int DEFAULT '0',
  PRIMARY KEY (`pesanan_id`),
  KEY `kasir_id` (`kasir_id`),
  KEY `pelanggan_noHP` (`pelanggan_noHP`),
  CONSTRAINT `pesanan_ibfk_1` FOREIGN KEY (`kasir_id`) REFERENCES `kasir` (`kasir_id`),
  CONSTRAINT `pesanan_ibfk_2` FOREIGN KEY (`pelanggan_noHP`) REFERENCES `pelanggan` (`pelanggan_noHP`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesanan`
--

LOCK TABLES `pesanan` WRITE;
/*!40000 ALTER TABLE `pesanan` DISABLE KEYS */;
INSERT INTO `pesanan` VALUES (1,'K02','081100000010','2026-01-11','L1','Dine in',0),(2,'K01','081100000009','2026-01-10','2','Take away',0),(3,'K03','081100000008','2026-01-09','1','Dine in',0),(4,'K02','081100000007','2026-01-08','8','Take away',0),(5,'K01','081100000006','2026-01-07','L2','Dine in',0),(6,'K03','081100000005','2026-01-06','L1','Take away',0),(7,'K02','081100000004','2026-01-05','5','Dine in',0),(8,'K01','081100000003','2026-01-04','4','Take away',0),(9,'K03','081100000002','2026-01-03','3','Dine in',0),(10,'K02','081100000001','2026-01-02','L2','Take away',0),(11,'K03','081100000020','2026-01-21','L1','Dine in',0),(12,'K02','081100000019','2026-01-20','4','Take away',0),(13,'K01','081100000018','2026-01-19','3','Dine in',0),(14,'K03','081100000017','2026-01-18','2','Take away',0),(15,'K02','081100000016','2026-01-17','L2','Dine in',0),(16,'K01','081100000015','2026-01-16','L1','Take away',0),(17,'K03','081100000014','2026-01-15','7','Dine in',0),(18,'K02','081100000013','2026-01-14','6','Take away',0),(19,'K01','081100000012','2026-01-13','5','Dine in',0),(20,'K03','081100000011','2026-01-12','L2','Take away',0),(21,'K01','081100000030','2026-01-31','L1','Dine in',0),(22,'K03','081100000029','2026-01-30','6','Take away',0),(23,'K02','081100000028','2026-01-29','5','Dine in',0),(24,'K01','081100000027','2026-01-28','4','Take away',0),(25,'K03','081100000026','2026-01-27','L2','Dine in',0),(26,'K02','081100000025','2026-01-26','L1','Take away',0),(27,'K01','081100000024','2026-01-25','1','Dine in',0),(28,'K03','081100000023','2026-01-24','8','Take away',0),(29,'K02','081100000022','2026-01-23','7','Dine in',0),(30,'K01','081100000021','2026-01-22','L2','Take away',0),(31,'K02','081100000040','2026-02-10','L1','Dine in',0),(32,'K01','081100000039','2026-02-09','8','Take away',0),(33,'K03','081100000038','2026-02-08','7','Dine in',0),(34,'K02','081100000037','2026-02-07','6','Take away',0),(35,'K01','081100000036','2026-02-06','L2','Dine in',0),(36,'K03','081100000035','2026-02-05','L1','Take away',0),(37,'K02','081100000034','2026-02-04','3','Dine in',0),(38,'K01','081100000033','2026-02-03','2','Take away',0),(39,'K03','081100000032','2026-02-02','1','Dine in',0),(40,'K02','081100000031','2026-02-01','L2','Take away',0),(41,'K03','081100000050','2026-02-20','L1','Dine in',0),(42,'K02','081100000049','2026-02-19','2','Take away',0),(43,'K01','081100000048','2026-02-18','1','Dine in',0),(44,'K03','081100000047','2026-02-17','8','Take away',0),(45,'K02','081100000046','2026-02-16','L2','Dine in',0),(46,'K01','081100000045','2026-02-15','L1','Take away',0),(47,'K03','081100000044','2026-02-14','5','Dine in',0),(48,'K02','081100000043','2026-02-13','4','Take away',0),(49,'K01','081100000042','2026-02-12','3','Dine in',0),(50,'K03','081100000041','2026-02-11','L2','Take away',0),(51,'K01','081100000010','2026-03-02','L1','Dine in',0),(52,'K03','081100000009','2026-03-01','4','Take away',0),(53,'K02','081100000008','2026-02-28','3','Dine in',0),(54,'K01','081100000007','2026-02-27','2','Take away',0),(55,'K03','081100000006','2026-02-26','L2','Dine in',0),(56,'K02','081100000005','2026-02-25','L1','Take away',0),(57,'K01','081100000004','2026-02-24','7','Dine in',0),(58,'K03','081100000003','2026-02-23','6','Take away',0),(59,'K02','081100000002','2026-02-22','5','Dine in',0),(60,'K01','081100000001','2026-02-21','L2','Take away',0),(61,'K02','081100000020','2026-03-12','L1','Dine in',0),(62,'K01','081100000019','2026-03-11','6','Take away',0),(63,'K03','081100000018','2026-03-10','5','Dine in',0),(64,'K02','081100000017','2026-03-09','4','Take away',0),(65,'K01','081100000016','2026-03-08','L2','Dine in',0),(66,'K03','081100000015','2026-03-07','L1','Take away',0),(67,'K02','081100000014','2026-03-06','1','Dine in',0),(68,'K01','081100000013','2026-03-05','8','Take away',0),(69,'K03','081100000012','2026-03-04','7','Dine in',0),(70,'K02','081100000011','2026-03-03','L2','Take away',0),(71,'K03','081100000030','2026-03-22','L1','Dine in',0),(72,'K02','081100000029','2026-03-21','8','Take away',0),(73,'K01','081100000028','2026-03-20','7','Dine in',0),(74,'K03','081100000027','2026-03-19','6','Take away',0),(75,'K02','081100000026','2026-03-18','L2','Dine in',0),(76,'K01','081100000025','2026-03-17','L1','Take away',0),(77,'K03','081100000024','2026-03-16','3','Dine in',0),(78,'K02','081100000023','2026-03-15','2','Take away',0),(79,'K01','081100000022','2026-03-14','1','Dine in',0),(80,'K03','081100000021','2026-03-13','L2','Take away',0),(81,'K01','081100000040','2026-04-01','L1','Dine in',0),(82,'K03','081100000039','2026-03-31','2','Take away',0),(83,'K02','081100000038','2026-03-30','1','Dine in',0),(84,'K01','081100000037','2026-03-29','8','Take away',0),(85,'K03','081100000036','2026-03-28','L2','Dine in',0),(86,'K02','081100000035','2026-03-27','L1','Take away',0),(87,'K01','081100000034','2026-03-26','5','Dine in',0),(88,'K03','081100000033','2026-03-25','4','Take away',0),(89,'K02','081100000032','2026-03-24','3','Dine in',0),(90,'K01','081100000031','2026-03-23','L2','Take away',0),(91,'K02','081100000050','2026-04-11','L1','Dine in',0),(92,'K01','081100000049','2026-04-10','4','Take away',0),(93,'K03','081100000048','2026-04-09','3','Dine in',0),(94,'K02','081100000047','2026-04-08','2','Take away',0),(95,'K01','081100000046','2026-04-07','L2','Dine in',0),(96,'K03','081100000045','2026-04-06','L1','Take away',0),(97,'K02','081100000044','2026-04-05','7','Dine in',0),(98,'K01','081100000043','2026-04-04','6','Take away',0),(99,'K03','081100000042','2026-04-03','5','Dine in',0),(100,'K02','081100000041','2026-04-02','L2','Take away',0),(128,'K01','234234','2026-05-29','123','Dine in',195000),(129,'K01','123','2026-05-29','122','Dine in',57000),(130,'K01','234234','2026-05-29','1','Dine in',234220),(131,'K01','34234234','2026-05-29','l2','Dine in',101000),(132,'K01','342453453','2026-05-29','21','Dine in',388000),(133,'K01','3432535','2026-05-29','121','Take away',254220),(134,'K01','1233423','2026-05-29','13','Dine in',284220),(135,'K01','1234123','2026-05-29','12','Take away',41000),(136,'K01','234234','2026-05-29','B1','Dine in',930440),(137,'K01','9128392','2026-05-29','B1','Dine in',26000),(141,'K01','923489234234','2026-05-30','123','Dine in',115220),(145,'K01','342323223122','2026-05-30','12','Dine in',198000),(147,'K01','234234234234','2026-05-30','123','Dine in',410000),(148,'K01','081256901234','2026-05-31','B1','Dine in',260000),(150,'K01','081256901232','2026-05-31','11','Dine in',284220),(151,'K01','081234567893','2026-05-31','\'12','Dine in',577660),(152,'K01','0812569012323','2026-05-31','B1','Dine in',104000),(153,'K01','081256901278','2026-06-04','123','Dine in',138000),(154,'K01','23423423434','2026-06-04','123','Dine in',1360000);
/*!40000 ALTER TABLE `pesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaksi` (
  `transaksi_id` int NOT NULL AUTO_INCREMENT,
  `pesanan_id` int NOT NULL,
  `transaksi_status` enum('Berhasil','Tidak Berhasil') DEFAULT 'Berhasil',
  `transaksi_tanggal` date NOT NULL,
  `transaksi_metode` enum('Tunai','Non-Tunai') DEFAULT 'Tunai',
  PRIMARY KEY (`transaksi_id`),
  KEY `pesanan_id` (`pesanan_id`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`pesanan_id`) REFERENCES `pesanan` (`pesanan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` VALUES (1,132,'Berhasil','2026-05-29','Tunai'),(2,133,'Berhasil','2026-05-29','Non-Tunai'),(3,134,'Berhasil','2026-05-29','Non-Tunai'),(4,135,'Berhasil','2026-05-29','Tunai'),(5,137,'Berhasil','2026-05-29','Non-Tunai'),(6,145,'Berhasil','2026-05-30','Non-Tunai'),(7,147,'Berhasil','2026-05-30','Tunai'),(8,148,'Berhasil','2026-05-31','Non-Tunai'),(9,150,'Berhasil','2026-05-31','Non-Tunai'),(10,151,'Berhasil','2026-05-31','Tunai'),(11,152,'Berhasil','2026-05-31','Tunai'),(12,153,'Berhasil','2026-06-04','Tunai'),(13,154,'Berhasil','2026-06-04','Non-Tunai');
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ikanbakarmuara3'
--

--
-- Dumping routines for database 'ikanbakarmuara3'
--
/*!50003 DROP FUNCTION IF EXISTS `hitung_dp_total` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `hitung_dp_total`(dp_kuantitas int, harga int) RETURNS int
    DETERMINISTIC
BEGIN
RETURN dp_kuantitas * harga;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `hitung_grandtotal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `hitung_grandtotal`(p_pesanan_id int) RETURNS int
    DETERMINISTIC
BEGIN
DECLARE total int;
select sum(dp_total) into total from detail_pesanan where pesanan_id = p_pesanan_id;
return total;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `edit_pesanan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `edit_pesanan`(
IN tp_pesanan_id int,
IN tp_kasir_id char(3),
IN tp_pelanggan_noHP varchar(15),
IN tp_pesanan_tanggal date,
IN tp_pesanan_noMeja varchar(3),
IN tp_pesanan_jenis enum('Dine in', 'Take away'))
begin
update pesanan
set kasir_id = tp_kasir_id,
pelanggan_noHP =  tp_pelanggan_noHP,
pesanan_tanggal = tp_pesanan_tanggal,
pesanan_noMeja = tp_pesanan_noMeja,
pesanan_jenis = tp_pesanan_jenis
where pesanan_id = tp_pesanan_id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pr_edit_pesanan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_edit_pesanan`(
in pr_pesanan_id int,
in pr_menu_id char(5),
in pr_dp_kuantitas int)
begin 
update detail_pesanan set dp_kuantitas = pr_dp_kuantitas where pesanan_id = pr_pesanan_id and menu_id = pr_menu_id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `tambah_pesanan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_pesanan`(
IN tp_kasir_id char(3),
IN tp_pelanggan_noHP varchar(15),
IN tp_pesanan_tanggal date,
IN tp_pesanan_noMeja varchar(3),
IN tp_pesanan_jenis enum('Dine in', 'Take away'))
BEGIN
INSERT INTO pesanan(kasir_id, pelanggan_noHP, pesanan_tanggal, pesanan_noMeja, pesanan_jenis) VALUES(tp_kasir_id, tp_pelanggan_noHP, tp_pesanan_tanggal, tp_pesanan_noMeja, tp_pesanan_jenis);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validasi_transaksi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validasi_transaksi`(IN vt_pesanan_id INT)
BEGIN
DECLARE jumlah INT;
SELECT COUNT(*) INTO jumlah
FROM transaksi
WHERE pesanan_id = vt_pesanan_id AND transaksi_status = 'Berhasil';
IF jumlah > 0 THEN select concat('Pesanan ', vt_pesanan_id, ' berhasil melakukan transaksi') AS hasil;
ELSE
select concat('Pesanan ', vt_pesanan_id, ' tidak berhasil melakukan transaksi') AS hasil;
END IF;
END ;;
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

-- Dump completed on 2026-06-04 16:46:58
