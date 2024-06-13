-- V4__Update_schema_with_user_table.sql

-- Adicionar a coluna lastUpdated na tabela User se não existir
ALTER TABLE User ADD COLUMN IF NOT EXISTS lastUpdated TIMESTAMP;
