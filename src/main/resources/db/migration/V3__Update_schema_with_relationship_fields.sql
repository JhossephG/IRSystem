-- Atualizar a tabela Car
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Car' AND COLUMN_NAME='store_id');
SET @sql = IF(@exists = 0, 'ALTER TABLE Car ADD COLUMN store_id INT', 'SELECT "Column store_id already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Car' AND COLUMN_NAME='user_id');
SET @sql = IF(@exists = 0, 'ALTER TABLE Car ADD COLUMN user_id INT', 'SELECT "Column user_id already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE Car 
    MODIFY COLUMN saleValue DECIMAL(10, 2),
    MODIFY COLUMN purchaseValue DECIMAL(10, 2);

-- Atualizar a tabela Store
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='id');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN id INT', 'SELECT "Column id already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='name');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN name VARCHAR(100)', 'SELECT "Column name already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='address');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN address VARCHAR(250)', 'SELECT "Column address already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='registerNumber');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN registerNumber VARCHAR(150)', 'SELECT "Column registerNumber already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='phoneNumber');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN phoneNumber VARCHAR(100)', 'SELECT "Column phoneNumber already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='expenses');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN expenses DECIMAL(10, 2) DEFAULT 0', 'SELECT "Column expenses already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='balance');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN balance DECIMAL(10, 2) DEFAULT 0', 'SELECT "Column balance already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='total_of_employees');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN total_of_employees INT DEFAULT 0', 'SELECT "Column total_of_employees already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='Store' AND COLUMN_NAME='total_of_cars');
SET @sql = IF(@exists = 0, 'ALTER TABLE Store ADD COLUMN total_of_cars INT DEFAULT 0', 'SELECT "Column total_of_cars already exists"');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
