-- V3__Update_schema_with_relationship_fields.sql
ALTER TABLE Vehicle ADD COLUMN IF NOT EXISTS user_id INT;
