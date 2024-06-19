-- V1__Initial_schema.sql
CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(255),
    model VARCHAR(255),
    year INT
);

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
