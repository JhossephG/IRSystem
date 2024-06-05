-- Remover a tabela Client, se existir
DROP TABLE IF EXISTS Client;

-- Criar a nova tabela User se não existir
CREATE TABLE IF NOT EXISTS User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    address VARCHAR(200),
    idNumber VARCHAR(100),
    phoneNumber VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    password VARCHAR(100)
);

-- Adicionar a coluna user_id na tabela Car se não existir
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Car' AND COLUMN_NAME='user_id');
SET @sql = IF(@exists = 0, 'ALTER TABLE Car ADD COLUMN user_id INT', 'SELECT "Column user_id already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Adicionar a chave estrangeira na tabela Car, se não existir
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME='Car' AND CONSTRAINT_NAME='fk_car_user');
SET @sql = IF(@exists = 0, 'ALTER TABLE Car ADD CONSTRAINT fk_car_user FOREIGN KEY (user_id) REFERENCES User(id)', 'SELECT "Foreign key fk_car_user already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
