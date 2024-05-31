CREATE TABLE Store (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(255)
);

CREATE TABLE Car (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(100),
    brand VARCHAR(100),
    chassis VARCHAR(100),
    manufactureYear INT,
    saleValue DECIMAL(10, 2),
    purchaseValue DECIMAL(10, 2),
    inStore BOOLEAN,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);

CREATE TABLE Client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    contact VARCHAR(100),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    role VARCHAR(50),
    username VARCHAR(100),
    password VARCHAR(100),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(id)
);
