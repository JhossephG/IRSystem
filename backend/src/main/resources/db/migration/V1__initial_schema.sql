CREATE TABLE `Store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `registerNumber` varchar(150) DEFAULT NULL,
  `phoneNumber` varchar(100) DEFAULT NULL,
  `expenses` decimal(10,2) DEFAULT '0.00',
  `balance` decimal(10,2) DEFAULT '0.00',
  `total_of_employees` int DEFAULT '0',
  `total_of_cars` int DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `User` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idNumber` varchar(100) DEFAULT NULL,
  `phoneNumber` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `lastUpdated` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `vehicleIdNumber` varchar(100) DEFAULT NULL,
  `manufactureYear` int DEFAULT NULL,
  `saleValue` decimal(10,2) DEFAULT NULL,
  `purchaseValue` decimal(10,2) DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `Vehicle_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`),
  CONSTRAINT `Vehicle_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
);

CREATE TABLE `Employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(50) DEFAULT NULL,
  `wage` decimal(10,2) DEFAULT '0.00',
  `store_id` int DEFAULT NULL,
  `idNumber` varchar(100) DEFAULT NULL,
  `phoneNumber` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`)
);

CREATE TABLE `Finance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `carId` int DEFAULT NULL,
  `value` decimal(10,2) DEFAULT NULL,
  `indicator` decimal(10,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `businessHealth` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `carId` (`carId`),
  CONSTRAINT `Finance_ibfk_1` FOREIGN KEY (`carId`) REFERENCES `Vehicle` (`id`)
);
