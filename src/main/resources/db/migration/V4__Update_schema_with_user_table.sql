-- Remover a tabela Client, se existir
DROP TABLE IF EXISTS Client;

-- Criar a nova tabela User
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

-- Adicionar a coluna user_id na tabela Car se não existir
ALTER TABLE Car 
    ADD COLUMN IF NOT EXISTS user_id INT;

-- Adicionar a chave estrangeira na tabela Car
ALTER TABLE Car 
    ADD CONSTRAINT fk_car_user FOREIGN KEY (user_id) REFERENCES User(id);
