ALTER TABLE `Vehicle` ADD COLUMN `manufacturer` varchar(100);
ALTER TABLE `Vehicle` ADD COLUMN `description` varchar(400);
ALTER TABLE `Vehicle` ADD COLUMN `evaluation`` int DEFAULT NULL;
ALTER TABLE `Vehicle` ADD COLUMN `title` varchar(150);
ALTER TABLE `Vehicle` CHANGE user_id order_id int;

CREATE TABLE ProductImages (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `entity_id`` INT,
    `entity_type` varchar(50),
    `image_url` varchar(250),
);

CREATE TABLE ProductReviews (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `entity_id`` INT,
    `entity_type` varchar(50),
    `review` varchar(250),
);

CREATE TABLE Food (
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
     KEY `user_id` (`user_id`),
     CONSTRAINT `Food_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `Store` (`id`),
     CONSTRAINT `Food_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`)
);
