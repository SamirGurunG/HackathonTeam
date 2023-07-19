-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2023 at 01:39 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `logdetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `empId` int(11) NOT NULL,
  `eFname` varchar(20) DEFAULT NULL,
  `eLname` varchar(20) DEFAULT NULL,
  `ePhoneNumber` varchar(15) DEFAULT NULL,
  `eEmail` varchar(30) DEFAULT NULL,
  `ePass` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`empId`, `eFname`, `eLname`, `ePhoneNumber`, `eEmail`, `ePass`) VALUES
(1, 'aayush', 'shrestha', '9800000000', 'aayush@gmail.com', '12345'),
(2, 'niwesh', 'waiba', '9866332606', 'newaceyba@gmail.com', 'Password'),
(3, 'niwesh', 'waiba', '98663552606', 'newaceyba11@gmail.com', 'Pwd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`empId`),
  ADD UNIQUE KEY `ePhoneNumber` (`ePhoneNumber`),
  ADD UNIQUE KEY `eEmail` (`eEmail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `empId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
