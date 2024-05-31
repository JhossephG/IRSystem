package com.jhogo.irsystem.employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertEmployee(Employee employees) throws SQLException {
        String sql = "INSERT INTO Employee (name, role, address, username, password, birthday) VALEUS (?,?,?,?,?,?)"; 
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, employees.getName());
            statement.setString(2, employees.getRole());
            statement.setString(3, employees.getAddress());
            statement.setString(4, employees.getUserName());
            statement.setString(5, employees.getPassword());
            statement.setDate(6, employees.getBirthday());
            statement.executeUpdate();
        }
    }
    
    public List<Employee> getAllEmployees () throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT FROM Employee";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setRole(resultSet.getString("role"));
                    employee.setAddress(resultSet.getString("address"));
                    employee.setUserName(resultSet.getString("username"));
                    employee.setPassword(resultSet.getString("password"));
                    employee.setBirthday(resultSet.getDate("birthday"));
                    employees.add(employee);
                }
            }
            return employees;
    }

    public void updateEmployee (Employee employees) throws SQLException {
        String sql = "UPDATE Employee SET name=?, role=?, address=?, username=?, password=?, birthday=? WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employees.getName());
            statement.setString(2, employees.getRole());
            statement.setString(3, employees.getAddress());
            statement.setString(4, employees.getUserName());
            statement.setString(5, employees.getPassword());
            statement.setDate(6, employees.getBirthday());
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
