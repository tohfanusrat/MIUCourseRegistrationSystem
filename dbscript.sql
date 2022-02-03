-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: cs-cs425-eregistrar
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic_blocks`
--

DROP TABLE IF EXISTS `academic_blocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_blocks` (
  `academic_block_id` bigint NOT NULL AUTO_INCREMENT,
  `block_code` varchar(255) NOT NULL,
  `block_title` varchar(255) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`academic_block_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_blocks`
--

LOCK TABLES `academic_blocks` WRITE;
/*!40000 ALTER TABLE `academic_blocks` DISABLE KEYS */;
INSERT INTO `academic_blocks` VALUES (1,'Sep-2021','September 2021','2021-09-30','2021-09-01'),(2,'Oct-2021','October 2021','2021-10-31','2021-10-01'),(3,'Nov-2021','November 2021','2021-11-30','2021-11-01');
/*!40000 ALTER TABLE `academic_blocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `block_courses`
--

DROP TABLE IF EXISTS `block_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `block_courses` (
  `block_course_id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `academic_block_id` bigint DEFAULT NULL,
  `course_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`block_course_id`),
  UNIQUE KEY `UK_oqaqt1jcj6keru1ikgiji6qhl` (`course_id`),
  KEY `FK6js92lnm93b2nrgaqxo8uerao` (`academic_block_id`),
  KEY `FKrdp6rsox5y44cu3ffg8l5qe8t` (`user_id`),
  CONSTRAINT `FK6js92lnm93b2nrgaqxo8uerao` FOREIGN KEY (`academic_block_id`) REFERENCES `academic_blocks` (`academic_block_id`),
  CONSTRAINT `FKq9jhg4ch4enqxrbjtuwg143bf` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `FKrdp6rsox5y44cu3ffg8l5qe8t` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_courses`
--

LOCK TABLES `block_courses` WRITE;
/*!40000 ALTER TABLE `block_courses` DISABLE KEYS */;
INSERT INTO `block_courses` VALUES (1,40,1,1,1),(2,30,1,2,2);
/*!40000 ALTER TABLE `block_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_prerequisites`
--

DROP TABLE IF EXISTS `course_prerequisites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_prerequisites` (
  `course_prerequisite_id` bigint NOT NULL AUTO_INCREMENT,
  `pass_grade_point` double NOT NULL,
  PRIMARY KEY (`course_prerequisite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_prerequisites`
--

LOCK TABLES `course_prerequisites` WRITE;
/*!40000 ALTER TABLE `course_prerequisites` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_prerequisites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` bigint NOT NULL AUTO_INCREMENT,
  `course_code` varchar(255) NOT NULL,
  `course_title` varchar(255) NOT NULL,
  `pass_grade_point` double NOT NULL,
  `retakeable_grade_point` double NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'CS390','Fundamental Programming Practices',3,2.7),(2,'CS401','Modern Programming Practices',3,2.7),(3,'CS523','Big Data Technology',2.3,2.3),(4,'CS435','Algorithms',2.7,2.3);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_requests`
--

DROP TABLE IF EXISTS `registration_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration_requests` (
  `registration_request_id` bigint NOT NULL AUTO_INCREMENT,
  `priority_index` int NOT NULL,
  `academic_block_id` bigint NOT NULL,
  `course_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`registration_request_id`),
  KEY `FKhe80asec1b8af90dm3i672t4a` (`academic_block_id`),
  KEY `FK39g8lr421jua7n4vkau6fe8kx` (`course_id`),
  KEY `FK5dpjpcpmxiybm9y4wwi2rcmik` (`user_id`),
  CONSTRAINT `FK39g8lr421jua7n4vkau6fe8kx` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `FK5dpjpcpmxiybm9y4wwi2rcmik` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKhe80asec1b8af90dm3i672t4a` FOREIGN KEY (`academic_block_id`) REFERENCES `academic_blocks` (`academic_block_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_requests`
--

LOCK TABLES `registration_requests` WRITE;
/*!40000 ALTER TABLE `registration_requests` DISABLE KEYS */;
INSERT INTO `registration_requests` VALUES (1,1,1,1,3);
/*!40000 ALTER TABLE `registration_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrations`
--

DROP TABLE IF EXISTS `registrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrations` (
  `registration_id` bigint NOT NULL AUTO_INCREMENT,
  `grade` varchar(255) NOT NULL,
  `grade_point` double NOT NULL,
  `academic_block_id` bigint NOT NULL,
  `course_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`registration_id`),
  UNIQUE KEY `UK_nyj16kaaa4oj5oi6cwmuiclkx` (`academic_block_id`),
  UNIQUE KEY `UK_76xiv3y3snida7n2h2q3x1set` (`course_id`),
  UNIQUE KEY `UK_f7yqbilgjdghhrh9jqneo6i4o` (`user_id`),
  CONSTRAINT `FKhtig5llmfoa392chrg3x1uslt` FOREIGN KEY (`academic_block_id`) REFERENCES `academic_blocks` (`academic_block_id`),
  CONSTRAINT `FKl2iby9n9hp8jwkfj8i96pkxpi` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKsfbbeggcdx583ihht1yngeam6` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrations`
--

LOCK TABLES `registrations` WRITE;
/*!40000 ALTER TABLE `registrations` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'FACULTY'),(3,'STUDENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `building_no` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_number` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_g3brvi3cpqs10ebdf6eqh7wv9` (`user_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'4','Fairfield','(641) 123-1234','asmith@google.com','52557','USA','Main street','Md Anwar','Hossain','123456','613473'),(2,'4','Fairfield','(641) 123-1234','asmith@google.com','52557','USA','Main street','Tohfa','Nusrat','123456','613474'),(3,'15B','Portsmouth','(123) 112-1230','bjones@yahoo.co.uk','12012','USA','West Burlington Avenue','Faysal Hossain','Mazed','123456','613478');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 15:22:27
