-- MySQL dump 10.16  Distrib 10.1.20-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.20-MariaDB

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
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `answer` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (59,31,3,'A'),(60,32,3,'B'),(61,18,3,'A'),(62,36,3,'C'),(63,21,3,'A'),(64,8,3,'D'),(65,15,3,'A'),(66,11,3,'D'),(67,35,3,'B'),(68,15,5,'A'),(69,18,5,'C'),(70,19,5,'A'),(71,17,5,'B'),(72,26,5,'B'),(73,14,5,'C'),(74,25,5,'C'),(75,25,5,'A'),(76,27,5,'A');
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(80) DEFAULT NULL,
  `prompt` varchar(800) DEFAULT NULL,
  `answer_one` varchar(600) DEFAULT NULL,
  `answer_two` varchar(600) DEFAULT NULL,
  `answer_three` varchar(600) DEFAULT NULL,
  `answer_four` varchar(600) DEFAULT NULL,
  `correct` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (13,'Software Architecture','The collaboration diagram','Is a unique view of object behavior','Models the connections between the different views','Models the relationship between software and hardware components','Models the way objects communicate','D'),(14,'Software Architecture','In class diagram, inside each class what is to be printed?','Its name, attributes, operations and derived class','Its name, attributes and operations','Its name and attributes','Its name and operations','B'),(15,'Software Architecture','The object is represented in UML notation by','A comment or a explanatory note associated with a class','A rectangular box with the name of the object','\"A rectangular box with the instantiated object, separated from the class name by a \"\":\"\", and underlined, to show an instantiation.\"','A thin vertical line with key method calls shown by outward arrow','C'),(16,'Software Architecture','Which diagram in UML is used to describe the physical components their distribution and association?','Component diagram','Object diagram','Deployment diagram','Interaction diagram','C'),(17,'Software Architecture','What can UML interfaces be used for?','\"To provide concrete classes with the stereotype \"\"interface\"\"\"','To program in Java and C++, but not in C#','To define executable logic that can be reused in several classes','To specify required services for types of objects','D'),(18,'Software Architecture','The interface is represented in UML notation by','Circle with the name below the circle','Dotted eclipse with the name inside the eclipse','Rectangular box with the name of interface inside it','Dotted circle with the name inside it','A'),(19,'Software Architecture','What is true about UML stereotypes?','A stereotype is used for extending the UML language.','A stereotyped class must be abstract.','The stereotype {frozen} indicates that the UML element cannot be changed.','UML Profiles can be stereotyped for backward compatibility.','A'),(20,'Software Architecture','Key elements of use-case diagrams are','People, computer','Actors, use cases','People, classes and objects','Uses, cases','B'),(21,'Software Architecture','If you need to show the physical relationship between software components and the hardware in the delivered system, which diagram can you use?','Component diagram','Deployment diagram','Class diagram','Network diagram','B'),(22,'Software Architecture','Aggregation (encapsulation) relationship is represented in UML notation by','Line with solid diamond at one end','Line with hollow diamond at one end','Line with an arrow at one end','Line without an arrow','B'),(23,'Software Architecture','Which diagram is NOT commonly used for illustrating use cases?','System sequence diagram','Activity diagram','Use case diagram','Collaboration diagram','D'),(24,'Software Architecture','Which diagram models the life cycle of a single object?','visibility diagram','state transition','sequence','state machine','D'),(25,'Software Architecture','Inheritance relationships are represented in the UML notation by','Lines with solid diamond at one end','Lines with hollow diamond at one end','Lines with hollow triangular arrow at one end','Lines with solid triangular arrow at both ends','C'),(26,'Software Architecture','What does a simple name in UML Class and objects consists of ?','Letters','Digits','Punctuation Characters','?All of the mentioned','D'),(27,'Software Architecture','What Does a Composite name consists of in a UML Class and object diagram ?','Delimiter','Simple names','Digits','All of the mentioned','D'),(28,'Software Architecture','A Class consists of which of these abstractions?','Set of the objects','Operations','Attributes','All of the mentioned','D'),(29,'Software Architecture','A class is divided into which of these compartments ?','Name Compartment','Attribute Compartment','Operation Compartment','All of the mentioned','D'),(30,'Software Architecture','An attribute is a data item held by which of the following ?','Class','Object','All of the mentioned','None of the mentioned','C'),(31,'Software Architecture','What should be mentioned as attributes for conceptual modelling ?','Initial Values','Names','All of the mentioned','None of the mentioned','C'),(32,'Software Architecture','Which of these are part of class operation specification format ?','name','parameter list','return-type list','All of the mentioned','D'),(33,'Software Architecture','What among these is true ?','Associations may also correspond to relation between instances of three or more classes','Association lines may be unlabeled or they may show association name','All of the mentioned','None of the mentioned','C'),(34,'Software Architecture','Which among these are the rules to be considered to form Class diagrams?','Class symbols must have at least a name compartment','Compartment can be in random order','Attributes and operations can be listed at any suitable place','None of the mentioned','A'),(35,'Software Architecture','An object symbol is divided into what parts ?','Top compartment','Bottom Compartment','All of the mentioned','None of the mentioned','C'),(36,'Software Architecture','A class that contains business-related information and implements the analysis classes is a(n):','interface class','control class','entity class','object-oriented class','C'),(37,'Software Architecture','Which diagram depicts classes that correspond to software components that are used to build the software application?','state transition','design class','state machine','sequence','B'),(38,'Software Architecture','What\'s the question to test?','Answer A','Answer B','Answer C','Answer D','C'),(39,'Software Architecture','What\'s the question to test?','Answer A','Answer B','Answer C','Answer D','C');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_levels`
--

DROP TABLE IF EXISTS `user_levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_levels` (
  `user_level` int(11) NOT NULL,
  `level_description` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`user_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_levels`
--

LOCK TABLES `user_levels` WRITE;
/*!40000 ALTER TABLE `user_levels` DISABLE KEYS */;
INSERT INTO `user_levels` VALUES (1,'Admin'),(2,'Instructor'),(3,'Student');
/*!40000 ALTER TABLE `user_levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_level` int(11) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin','*4ACFE3202A5FF5CF467898FC58AAB1D615029441',NULL),(2,1,'zabra','*293015854B5DEED50E5955E9E1F736905A05DBE3',NULL),(3,3,'victor','*37FD309A6DAE1032F071431A9575C49191A67CBF','Victor'),(4,2,'instructor','*8A413067CDCB1B4F49D35E4B4E58ED0225383443','Instructor');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-03 15:30:20
