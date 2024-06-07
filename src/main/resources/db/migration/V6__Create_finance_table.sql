CREATE TABLE Finance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    carId INT,
    value DECIMAL(10,2) DEFAULT 0,
    description VARCHAR(255),
    indicator DECIMAL(10,2) DEFAULT 0,
    businessHealth BOOLEAN,
    CONSTRAINT fk_finance_car FOREIGN KEY (carId) REFERENCES Car(id)
);

DROP TABLE IF EXISTS Car;

CREATE TABLE IF NOT EXISTS Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    manufactureYear INT,
    userId INT,
    storeId INT,
    saleValue DECIMAL(10,2),
    purchaseValue DECIMAL(10,2),
    model VARCHAR(100),
    brand VARCHAR(200),
    vehicleIdNumber(150),
    availability BOOLEAN
);

ALTER TABLE Employee
    ADD COLUMN IF NOT EXISTS idNumber VARCHAR(100),
    ADD COLUMN IF NOT EXISTS email VARCHAR(100) UNIQUE,
    ADD COLUMN IF NOT EXISTS phoneNumber VARCHAR(100);

ALTER TABLE User
    ADD COLUMN IF NOT EXISTS lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN IF NOT EXISTS idNumber VARCHAR(100),
    ADD COLUMN IF NOT EXISTS phoneNumber VARCHAR(100),
    ADD COLUMN IF NOT EXISTS username VARCHAR(100);


