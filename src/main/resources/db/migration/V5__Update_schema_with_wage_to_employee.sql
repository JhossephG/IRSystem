-- V5__Update_schema_with_wage_to_employee.sql
ALTER TABLE Employee ADD COLUMN IF NOT EXISTS wage DECIMAL(10, 2);
