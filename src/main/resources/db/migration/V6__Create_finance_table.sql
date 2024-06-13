-- V6__Create_finance_table.sql

-- Criar tabela Finance se não existir
CREATE TABLE IF NOT EXISTS Finance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(10, 2),
    date DATE,
    vehicle_id INT,
    CONSTRAINT fk_finance_vehicle FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

-- Adicionar coluna se não existir
ALTER TABLE Finance ADD COLUMN IF NOT EXISTS some_column VARCHAR(255);
