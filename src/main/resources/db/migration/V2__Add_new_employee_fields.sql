
-- Adicionar a coluna 'address' se ela não existir
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Employee' AND COLUMN_NAME='address');
SET @sql = IF(@exists = 0, 'ALTER TABLE Employee ADD COLUMN address VARCHAR(200)', 'SELECT "Column address already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Adicionar a coluna 'birthday' se ela não existir
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Employee' AND COLUMN_NAME='birthday');
SET @sql = IF(@exists = 0, 'ALTER TABLE Employee ADD COLUMN birthday DATE', 'SELECT "Column birthday already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Alterar colunas existentes
ALTER TABLE Employee CHANGE COLUMN name name VARCHAR(100);
ALTER TABLE Employee CHANGE COLUMN role role VARCHAR(50);
ALTER TABLE Employee CHANGE COLUMN username username VARCHAR(100);
ALTER TABLE Employee CHANGE COLUMN password password VARCHAR(100);
ALTER TABLE Employee CHANGE COLUMN store_id store_id INT;
