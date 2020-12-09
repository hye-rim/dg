-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 10.10.30.17    Database: DOG_GI
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `answer_seq` bigint NOT NULL AUTO_INCREMENT COMMENT '답안 코드',
  `problem_seq` bigint NOT NULL COMMENT '문제 코드',
  `language_code` varchar(100) NOT NULL COMMENT '언어 코드',
  `user_seq` bigint NOT NULL COMMENT '유저 코드',
  `answer` longtext NOT NULL COMMENT '답안',
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
  `updt_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `success_yn` varchar(2) NOT NULL DEFAULT 'N' COMMENT '성공 여부',
  `open_yn` varchar(2) NOT NULL DEFAULT 'Y' COMMENT '답안 공개 여부',
  `time` bigint NOT NULL COMMENT '시간',
  `memory` bigint NOT NULL COMMENT '메모리',
  PRIMARY KEY (`answer_seq`,`problem_seq`,`language_code`,`user_seq`),
  KEY `FK_TB_USER_TO_TB_ANSWER_idx` (`user_seq`),
  KEY `FK_TB_PROBLEM_TO_TB_ANSWER_idx` (`problem_seq`),
  CONSTRAINT `FK_TB_PROBLEM_TO_TB_ANSWER` FOREIGN KEY (`problem_seq`) REFERENCES `problem` (`problem_seq`),
  CONSTRAINT `FK_TB_USER_TO_TB_ANSWER` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,'C1001',1,'System.out.println(\'hello,world\');','2020-11-29 00:00:00','2020-11-29 00:00:00','N','Y',13,10),(2,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 00:00:00','2020-11-29 00:00:00','N','Y',23,20),(3,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 00:00:00','2020-11-29 00:00:00','N','Y',23,20),(4,1,'C1001',1,'System.out.println(\'hello,123131\');','2020-11-29 00:00:00','2020-11-29 00:00:00','N','Y',23,20),(5,1,'C1001',1,'System.out.println(\'hello 123,\');','2020-11-29 21:29:58','2020-11-29 21:29:58','N','Y',23,20),(6,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 22:44:52','2020-11-29 22:44:52','N','Y',23,20),(7,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 22:57:14','2020-11-29 22:57:14','N','Y',23,20),(8,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 00:00:00','2020-11-29 00:00:00','N','Y',23,20),(9,1,'C1001',1,'System.out.println(\'hello,\');','2020-11-29 22:58:31','2020-11-29 22:58:31','N','Y',23,20);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code` (
  `code` varchar(100) NOT NULL COMMENT '코드명',
  `code_group` varchar(100) NOT NULL COMMENT '코드그룹',
  `code_name` varchar(100) NOT NULL,
  `code_discription` varchar(1000) NOT NULL COMMENT '코드설명',
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
  `updt_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES ('C1000','C1000','언어코드','언어코드','2020-11-29 12:49:32','2020-11-29 12:49:32'),('C1001','C1000','JAVA','자바','2020-11-29 12:50:16','2020-11-29 12:50:16'),('C2000','C2000','문제난이도코드','문제난이도','2020-11-29 12:53:37','2020-11-29 12:53:37'),('C2001','C2000','easy','문제난이도 : easy','2020-11-29 12:54:40','2020-11-29 12:54:40'),('C2002','C2000','normal','문제난이도 : normal','2020-11-29 12:55:32','2020-11-29 12:55:32'),('C2003','C2000','hard','문제난이도 : hard','2020-11-29 12:55:32','2020-11-29 12:55:32'),('C3000','C3000','승인여부코드','문제 승인 관련 코드','2020-12-02 08:24:33','2020-12-02 08:24:33'),('C3001','C3000','대기','문제 대기상태','2020-12-02 08:24:32','2020-12-02 08:24:32'),('C3002','C3000','승인','문제 승인상태','2020-12-02 08:24:32','2020-12-02 08:24:32'),('C3003','C3000','반려','문제반려상태','2020-12-02 08:24:33','2020-12-02 08:24:33');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email` (
  `email_seq` bigint NOT NULL AUTO_INCREMENT,
  `user_seq` bigint NOT NULL,
  `contents` varchar(3000) NOT NULL,
  `send_yn` varchar(2) NOT NULL DEFAULT 'N',
  `auth_yn` varchar(2) NOT NULL DEFAULT 'N',
  `reg_date` datetime DEFAULT NULL,
  `updt_date` datetime DEFAULT NULL,
  PRIMARY KEY (`email_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_answer`
--

DROP TABLE IF EXISTS `like_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_answer` (
  `like_seq` bigint NOT NULL AUTO_INCREMENT COMMENT '좋아요번호',
  `answer_seq` bigint NOT NULL COMMENT '답안 코드',
  `user_seq` bigint NOT NULL COMMENT '유저 코드',
  `reg_date` datetime NOT NULL COMMENT '등록일',
  `updt_date` datetime NOT NULL COMMENT '수정일',
  PRIMARY KEY (`like_seq`,`answer_seq`,`user_seq`),
  KEY `FK_TB_ANSWER_TO_TB_LIKE_idx` (`answer_seq`),
  KEY `FK_TB_USER_TO_TB_LIKE_idx` (`user_seq`),
  CONSTRAINT `FK_TB_ANSWER_TO_TB_LIKE` FOREIGN KEY (`answer_seq`) REFERENCES `answer` (`answer_seq`),
  CONSTRAINT `FK_TB_USER_TO_TB_LIKE` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_answer`
--

LOCK TABLES `like_answer` WRITE;
/*!40000 ALTER TABLE `like_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `like_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problem` (
  `problem_seq` bigint NOT NULL AUTO_INCREMENT COMMENT '문제 코드',
  `user_seq` bigint NOT NULL COMMENT '유저 코드',
  `level` varchar(100) NOT NULL COMMENT '문제 난이도',
  `problem_title` varchar(200) NOT NULL COMMENT '문제 제목',
  `problem_contents` longtext NOT NULL COMMENT '문제 내용',
  `reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
  `updt_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
  `input` longtext COMMENT '입력',
  `output` longtext COMMENT '출력',
  `status` varchar(45) DEFAULT 'C3001',
  PRIMARY KEY (`problem_seq`,`user_seq`),
  KEY `FK_TB_USER_TO_TB_PLOBLEM_idx` (`user_seq`),
  CONSTRAINT `FK_TB_USER_TO_TB_PLOBLEM` FOREIGN KEY (`user_seq`) REFERENCES `user` (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES (1,1,'C2001','hello,world','hello world를 출력하자','2020-11-29 13:31:51','2020-11-29 13:31:51','','hello world','C3001'),(2,15,'C2001','A+B','A와 B를 더한 값을 출력하자','2020-11-29 20:38:20','2020-11-29 20:38:20','1, 2','3','C3001');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_seq` bigint NOT NULL AUTO_INCREMENT COMMENT '유저 코드',
  `user_name` varchar(200) NOT NULL COMMENT '유저 이름',
  `email` varchar(200) NOT NULL COMMENT '이메일',
  `nickname` varchar(30) NOT NULL COMMENT '별명',
  `password` varchar(30) NOT NULL COMMENT '비밀번호',
  `mobile` int NOT NULL COMMENT '휴대폰',
  `try_count` int NOT NULL DEFAULT '0' COMMENT '문제 시도 횟수',
  `success_count` int NOT NULL DEFAULT '0' COMMENT '성공 횟수',
  `reg_date` datetime NOT NULL COMMENT '등록일',
  `updt_date` datetime NOT NULL COMMENT '수정일',
  `DELETE_YN` varchar(2) DEFAULT 'N',
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jhr','jjj@abc.com','Joo','dream1004!!!!',1099999999,0,0,'2020-10-14 22:40:43','2020-11-25 00:00:00','N'),(15,'정서연','seoyeon@mail.com','seoyeon','tjdusl',1012345678,0,0,'2020-11-29 16:03:13','2020-11-29 16:03:13','N'),(16,'서연','seoyeon2@mail.com','seoyeon2','tjdusl123',1098765423,0,0,'2020-11-29 18:33:41','2020-11-29 18:33:41','N'),(17,'서연2','seoyeon2@mail.com','seoyeon3','tjdusl1234',1011112222,0,0,'2020-11-29 21:22:31','2020-11-29 21:22:31','N'),(18,'서연','seoyeon2@mail.com','seoyeon2','tjdusl123',1098765423,0,0,'2020-11-29 22:40:10','2020-11-29 22:40:10','N'),(19,'서연','seoyeon2@mail.com','seoyeon2','tjdusl123',1098765423,0,0,'2020-11-29 22:43:43','2020-11-29 22:43:43','N'),(20,'서연','seoyeon2@mail.com','seoyeon2','tjdusl123',1098765423,0,0,'2020-11-29 22:57:03','2020-11-29 22:57:03','N'),(21,'서연3','seoyeon2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 00:00:00','2020-12-02 06:33:18','N'),(22,'서연4','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 06:36:28','2020-12-02 06:36:28','N'),(23,'서연5','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 00:00:00','2020-12-02 06:37:42','N'),(24,'서연5','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 00:00:00','2020-12-02 06:41:36','N'),(25,'서연6','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 00:00:00','2020-12-02 06:41:46','N'),(26,'서연7','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 00:00:00','2020-12-02 06:42:41','N'),(27,'서연8','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 06:52:10','2020-12-02 06:52:10','N'),(28,'서연9','seoyeo1n2@naver.com','seoyeon3','tjdusl1233',1198765423,0,0,'2020-12-02 07:26:37','2020-12-02 07:26:37','N');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'DOG_GI'
--

--
-- Dumping routines for database 'DOG_GI'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 13:35:06
