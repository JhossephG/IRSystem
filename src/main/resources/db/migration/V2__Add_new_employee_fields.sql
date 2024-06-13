-- V2__Add_new_employee_fields.sql
ALTER TABLE Employee ADD COLUMN IF NOT EXISTS address VARCHAR(255);
