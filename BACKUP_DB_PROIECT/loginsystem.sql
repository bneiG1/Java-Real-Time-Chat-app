-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2022 at 02:06 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loginsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

CREATE TABLE `friends` (
  `Username` varchar(128) NOT NULL,
  `Username_friend` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`Username`, `Username_friend`) VALUES
('goga', 'admin'),
('admin', 'goga'),
('admin', 'iosif'),
('admin', 'beni');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `Username_sender` varchar(128) NOT NULL,
  `Username_reciver` varchar(128) NOT NULL,
  `Message` varchar(1234) NOT NULL,
  `Date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`Username_sender`, `Username_reciver`, `Message`, `Date`) VALUES
('admin', 'beni', 'Hello!', '2022-01-01 15:12:55'),
('goga', 'admin', 'Helou!', '2022-01-01 15:48:45'),
('admin', 'goga', '1', '2022-01-01 16:20:39'),
('admin', 'goga', '2', '2022-01-01 16:20:50'),
('admin', 'goga', '3', '2022-01-01 16:20:51'),
('goga', 'admin', 'hellou', '2022-01-01 20:49:16');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `usersUid` varchar(128) NOT NULL,
  `usersEmail` varchar(128) NOT NULL,
  `usersPwd` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`usersUid`, `usersEmail`, `usersPwd`) VALUES
('admin', 'admin', 'admin'),
('goga', 'goga.iosif.beniamin@gmail.com', '123'),
('iosif', 'iosif.goga01@e-uvt.ro', '123'),
('beni', 'benig1@yahoo.com', '123'),
('user1', 'user1@email.com', '123'),
('user2', 'user2@email.com', '123'),
('user3', 'user3@email.com', '123'),
('user4', 'user4@email.com', '123'),
('user5', 'user5@email.com', '123'),
('user6', 'user6@email.com', '123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
