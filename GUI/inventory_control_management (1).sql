-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2020 at 08:54 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_control_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `sup_id` int(11) NOT NULL,
  `item_name` varchar(40) NOT NULL,
  `item_des` longtext NOT NULL,
  `crt_stk` int(11) NOT NULL,
  `anual_cons` int(11) NOT NULL,
  `order_cost` int(11) NOT NULL,
  `prdct_unt` int(11) NOT NULL,
  `prdct_price` int(11) NOT NULL,
  `load_time` int(11) NOT NULL,
  `stck_mant` int(11) NOT NULL,
  `eoq` int(11) NOT NULL,
  `re_order_lvl` int(11) NOT NULL,
  `safty_stk` int(11) NOT NULL,
  `lt_siz` int(11) NOT NULL,
  `no_odr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `sup_id`, `item_name`, `item_des`, `crt_stk`, `anual_cons`, `order_cost`, `prdct_unt`, `prdct_price`, `load_time`, `stck_mant`, `eoq`, `re_order_lvl`, `safty_stk`, `lt_siz`, `no_odr`) VALUES
(1, 10, 'Bread', 'Consumables', 120, 10000, 8, 20, 2400, 1, 2, 400, 1080, 0, 40, 27),
(14, 8, 'Cookies', 'Bakery Products', 92, 2500, 8, 20, 2000, 2, 2, 200, 308, 8, 50, 6),
(15, 3, 'Chips', 'Consumables', 52, 2500, 6, 15, 900, 2, 1, 173, 188, 8, 30, 6);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `Usr` text NOT NULL,
  `pswd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `Usr`, `pswd`) VALUES
(5, 'deepit1510@gmail.com', 'passw0rd*'),
(6, 'mehak4081998@gmail.com', 'mehak123');

-- --------------------------------------------------------

--
-- Table structure for table `re_order`
--

CREATE TABLE `re_order` (
  `odr_id` int(11) NOT NULL,
  `sup_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `odr_date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `re_order`
--

INSERT INTO `re_order` (`odr_id`, `sup_id`, `item_id`, `odr_date`) VALUES
(6, 10, 1, '03/07/2020');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `sup_id` int(11) NOT NULL,
  `sup_name` varchar(40) NOT NULL,
  `sup_email` varchar(30) NOT NULL,
  `gst_no` varchar(16) NOT NULL,
  `sup_address` longtext NOT NULL,
  `sup_phn` bigint(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sup_id`, `sup_name`, `sup_email`, `gst_no`, `sup_address`, `sup_phn`) VALUES
(2, 'Apoorv Pandey', 'apoorv296@gmail.com', '04AABCH0054N1ZI', 'E6A Sec-27 Noida, Uttar Pradesh', 9654938755),
(3, 'Harsh Gupta', 'harshgupta12@gmail.com', '29AABPH0526A2PS', 'F-27 Andheri East, Mumbai, Maharashtra', 9315004812),
(4, 'Manku Agencies', 'sales@mankuagro.com', '03AAACH0086N1ZO', 'F26 Block-A Model Town Baddai', 9315847931),
(5, 'Sandeep Aggarwal', 'sandag@gmail.com', '42ABBCH1146D1ZT', 'N95 sec-41 Chandigarh Haryana-12406', 9876543884),
(6, 'Vasu Tomar', 'tomarvau@gmail.com', '03ZZACH0126N1Z0', 'G29 ground floor tech park building 4 Bangalore ', 9874563268),
(7, 'Kartar Agro', 'sales@kartaragro.com', '03ABBCH0126A1Z0', 'A-24, Sector-23, Bandra West, Mumbai-150002', 6541685236),
(8, 'Ashish Mehta', 'ashishmehta07@gmail.com', '07AGHCH0086N1ZI', 'Shop No.4, E-55, Sector-45, Chandigarh', 9526354215),
(9, 'Tarun Kumar', 'tarunkumar456@gmail.com', '05AAACH0056N2ZP', 'F-65A, Vasundhra Enclave, Delhi-160023', 9887456532),
(10, 'Mehak Aggarwal', 'mehak4081998@gmail.com', '04AAPH14560N', '#51-A, Model Town, Delhi', 9652325418);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `sup_id` (`sup_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `re_order`
--
ALTER TABLE `re_order`
  ADD PRIMARY KEY (`odr_id`),
  ADD KEY `sup_id` (`sup_id`),
  ADD KEY `order_ibfk_2` (`item_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`sup_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `re_order`
--
ALTER TABLE `re_order`
  MODIFY `odr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `sup_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`sup_id`) REFERENCES `supplier` (`sup_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `re_order`
--
ALTER TABLE `re_order`
  ADD CONSTRAINT `re_order_ibfk_1` FOREIGN KEY (`sup_id`) REFERENCES `supplier` (`sup_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `re_order_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
