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

CREATE TABLE `Car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `chassis` varchar(100) DEFAULT NULL,
  `manufactureYear` int DEFAULT NULL,
  `saleValue` decimal(10,2) DEFAULT NULL,
  `purchaseValue` decimal(10,2) DEFAULT NULL,
  `inStore` tinyint(1) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `Car_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`)
);

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(200),
    idNumber VARCHAR(100),
    phoneNumber VARCHAR(100),
    email VARCHAR(100),
    lastUpdated TIMESTAMP,
    password VARCHAR(100)
); 

CREATE TABLE `Employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `Employee_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`)
);
