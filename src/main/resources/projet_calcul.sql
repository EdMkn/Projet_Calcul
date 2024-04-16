-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 16, 2024 at 06:52 PM
-- Server version: 8.0.36-0ubuntu0.22.04.1
-- PHP Version: 8.1.2-1ubuntu2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projet_calcul`
--

-- --------------------------------------------------------

--
-- Table structure for table `Niveau`
--

CREATE TABLE `Niveau` (
  `niveau` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Niveau`
--

INSERT INTO `Niveau` (`niveau`) VALUES
('Difficile'),
('Facile'),
('Moyen');

-- --------------------------------------------------------

--
-- Table structure for table `propositions`
--

CREATE TABLE `propositions` (
  `Réponse` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `propositions`
--

INSERT INTO `propositions` (`Réponse`) VALUES
(1),
(3),
(10),
(1),
(3),
(10),
(1),
(3),
(10),
(1),
(3),
(10);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `numero` int NOT NULL,
  `Enoncé` varchar(60) NOT NULL,
  `Réponse` int NOT NULL,
  `Niveau` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`numero`, `Enoncé`, `Réponse`, `Niveau`) VALUES
(1, '1+1 ?', 2, 'Facile'),
(2, '20*20 ?', 400, 'Moyen'),
(3, '20*0+1 ?', 1, 'Facile');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Niveau`
--
ALTER TABLE `Niveau`
  ADD KEY `niveau` (`niveau`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `Niveau` (`Niveau`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `numero` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `niveau` FOREIGN KEY (`Niveau`) REFERENCES `Niveau` (`niveau`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
