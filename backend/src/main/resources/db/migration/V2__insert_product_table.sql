CREATE TABLE IF NOT EXISTS `ProductImages` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `entity_id` INT,
    `entity_type` varchar(50),
    `image_url` varchar(250)
);

CREATE TABLE IF NOT EXISTS `ProductReviews` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `entity_id` INT,
    `entity_type` varchar(50),
    `review` varchar(250)
);

CREATE TABLE IF NOT EXISTS `Order` (
    `id` int NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
    `store_id` int NOT NULL,
    `order_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `total_amount` DECIMAL(10, 2) NOT NULL,
    `status` varchar(15),
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `Order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
    CONSTRAINT `Order_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`)
);

CREATE TABLE IF NOT EXISTS `OrderItems` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `order_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL,
    `product_name` VARCHAR(255),
    CONSTRAINT `OrderItems_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `Order`(`id`)
);

CREATE TABLE IF NOT EXISTS `Food` (
    `id` int NOT NULL AUTO_INCREMENT,
    `order_id` int DEFAULT NULL,
    `store_id` int DEFAULT NULL,
    `evaluation` int DEFAULT NULL,
    `saleValue` decimal(10,2) DEFAULT NULL,
    `purchaseValue` decimal (10,2) DEFAULT NULL,
    `availability` tinyint(1) DEFAULT NULL,
    `manufacturer` varchar(100),
    `description` varchar(400),
    `name` varchar(150),
    `title` varchar(150),
    `expiryDate` DATE,
    `ingredients` varchar(400),
    `nutritionalInformation` varchar(400),
    `foodType` varchar(100),
    `storageInstructions` varchar(250),
    `preparationInstructions` varchar(400),
    PRIMARY KEY (`id`),
    KEY `store_id` (`store_id`),
    KEY `order_id` (`order_id`),
    CONSTRAINT `Food_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`),
    CONSTRAINT `Food_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`)
);
