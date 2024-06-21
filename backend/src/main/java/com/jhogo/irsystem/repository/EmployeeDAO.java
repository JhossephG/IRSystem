package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO  {
    private final DataSource dataSource;

    @Autowired
    public EmployeeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertEmployee(Employee employees) throws SQLException {
        String sql = "INSERT INTO Employee (fullName, role, address, username, password, birthDate, wage, idNumber, phoneNumber, email, store_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, employees.getFullName());
            stmt.setString(2, employees.getRole());
            stmt.setString(3, employees.getAddress());
            stmt.setString(4, employees.getUsername());
            stmt.setString(5, employees.getPassword());
            stmt.setDate(6, employees.getBirthDate());
            stmt.setBigDecimal(7, employees.getWage());
            stmt.setString(8, employees.getIdNumber());
            stmt.setString(9, employees.getPhoneNumber());
            stmt.setString(10, employees.getEmail());
            stmt.setInt(11, employees.getStore_id());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employees.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Employee getEmployeeById (int employeeId) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
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
                    employee.setStore_id(result.getInt("store_id"));
                    return employee;
                }
            }
        }
        return null;
    }
    
    public List<Employee> getAllEmployees () throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT FROM Employee";
        try(Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(sql)){
                while (result.next()) {
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
                    employee.setStore_id(result.getInt("store_id"));
                    employees.add(employee);
                }
            }
            return employees;
    }

    public void updateEmployee (Employee employees, int employeeId) throws SQLException {
        String sql = "UPDATE Employee SET fullName=?, role=?, address=?, username=?, password=?, birthDate=?, wage=?, idNumber=?, phoneNumber=?, email=? WHERE id=?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employees.getFullName());
            stmt.setString(2, employees.getRole());
            stmt.setString(3, employees.getAddress());
            stmt.setString(4, employees.getUsername());
            stmt.setString(5, employees.getPassword());
            stmt.setDate(6, employees.getBirthDate());
            stmt.setBigDecimal(7, employees.getWage());
            stmt.setString(8, employees.getIdNumber());
            stmt.setString(9, employees.getPhoneNumber());
            stmt.setString(10, employees.getEmail());
            stmt.setInt(11, employeeId);
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee (int employeeId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        }
    }
    
}
