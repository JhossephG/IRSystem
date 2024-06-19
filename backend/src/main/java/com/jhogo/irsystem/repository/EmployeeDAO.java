package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertEmployee(Employee employees) throws SQLException {
        String sql = "INSERT INTO Employee (fullName, role, address, username, password, birthDate, wage, idNumber, phoneNumber, email) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, employees.getFullName());
            statement.setString(2, employees.getRole());
            statement.setString(3, employees.getAddress());
            statement.setString(4, employees.getUsername());
            statement.setString(5, employees.getPassword());
            statement.setDate(6, employees.getBirthDate());
            statement.setBigDecimal(7, employees.getWage());
            statement.setString(8, employees.getIdNumber());
            statement.setString(9, employees.getPhoneNumber());
            statement.setString(10, employees.getEmail());
            statement.executeUpdate();
        }
    }

    public Employee getEmployeeById (int employeeId) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    Employee employee = new Employee();
                    employee.setId(result.getInt("id"));
                    employee.setEmail(result.getString("email"));
                    employee.setIdNumber(result.getString("idNumber"));
                    employee.setPhoneNumber(result.getString("password"));
                    employee.setPhoneNumber(result.getString("phoneNumber"));
                    employee.setAddress(result.getString("address"));
                    employee.setBirthDate(result.getDate("birthDate"));
                    employee.setFullName(result.getString("name"));
                    employee.setRole(result.getString("role"));
                    employee.setWage(result.getBigDecimal("wage"));
                    employee.setStoreId(result.getInt("store_id"));
                    return employee;
                }
            }
        }
        return null;
    }
    
    public List<Employee> getAllEmployees () throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT FROM Employee";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFullName(resultSet.getString("fullName"));
                    employee.setRole(resultSet.getString("role"));
//                    employee.setAddress(resultSet.getString("address"));
                    employee.setUsername(resultSet.getString("username"));
//                    employee.setPassword(resultSet.getString("password"));
                    employee.setBirthDate(resultSet.getDate("birthDate"));
//                    employee.setWage(resultSet.getBigDecimal("wage"));
                    employees.add(employee);
                }
            }
            return employees;
    }

    public void updateEmployee (Employee employees) throws SQLException {
        String sql = "UPDATE Employee SET fullName=?, role=?, address=?, username=?, password=?, birthDate=?, wage=?, idNumber=?, phoneNumber=?, email=? WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employees.getFullName());
            statement.setString(2, employees.getRole());
            statement.setString(3, employees.getAddress());
            statement.setString(4, employees.getUsername());
            statement.setString(5, employees.getPassword());
            statement.setDate(6, employees.getBirthDate());
            statement.setBigDecimal(7, employees.getWage());
            statement.setString(8, employees.getIdNumber());
            statement.setString(9, employees.getPhoneNumber());
            statement.setString(10, employees.getEmail());
            statement.executeUpdate();
        }
    }

    public void deleteEmployee (int employeeId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        }
    }
    
}
