CREATE DATABASE isp;
USE isp;
--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(25) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` VALUES (1,'admin','admin');

--
-- Table structure for table `complain`
--

CREATE TABLE `complain` (
  `ID` int(25) NOT NULL auto_increment,
  `Complaint` varchar(255) NOT NULL,
  `Date` varchar(30) default NULL,
  `Action` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complain`
--

INSERT INTO `complain` VALUES (101,'Internet Speed','2020-02-15','Solved');

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(25) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Plan` varchar(255) default NULL,
  `Sex` varchar(255) NOT NULL,
  `Purpose` varchar(255) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` VALUES (201,'Dinesh Sindhayach','255233','Pune','90 Days','MALE','INDIVIDUAL');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(25) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `JoinDate` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `LeaveDate` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` VALUES (301,'Dinesh Sindhayach','255233','2020-02-15','Pune',NULL);

--
-- Table structure for table `plan`
--

CREATE TABLE `plan` (
  `ID` int(25) NOT NULL,
  `PlanName` varchar(255) NOT NULL,
  `Cost` int(25) NOT NULL,
  `Speed` varchar(25) NOT NULL,
  `Duration` varchar(255) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plan`
--

INSERT INTO `plan` VALUES (101,'Airtel',550,'150 MBPS','90 Days');

--
-- Table structure for table `providers`
--

CREATE TABLE `providers` (
  `name` varchar(100) default NULL,
  `lowest_price` double default NULL,
  `rating` int(45) default NULL,
  `speed` int(45) default NULL,
  `designation` varchar(100) default NULL,
  `mobile` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `url` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `providers`
--

INSERT INTO `providers` VALUES ('Airtel',560,4,150,'Airtel','9876543210','dinu55@gmail.com','www.airtel.com'),('BSNL',660,1,250,'BSNL','7654321089','dinu55@yahoo.com','www.bsnl.com'),('IDEA',660,1,250,'IDEA','9012345678','dinu55@yahoomail.com','www.ideatelecom.com'),('JIO',495,2,170,'Reliance','9876543210','jio@reliance.com','www.jio.com'),('Vodafone',511,3,230,'Vodafone','9076556987','vodafone@yahoo.com','www.vodafone.com'),('Tata Teleservices',420,2,130,'Tata Telecom','7276556987','tata@telecom.com','www.tatatelecom.com'),('MTNL',450,3,230,'BSNL','9852852852','mtnl@bsnl.com','www.mtnl.com'),('ACT Fibernet',750,5,460,'ACT','82082082082','act@act.com','www.act.com');
