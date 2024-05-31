package src.main.java.com.jhogo.irsystem.employees;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    private Connection connection;

    public EmployeesDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertEmployee(Employees employees) throws SQLException {
        String sql = "INSERT INTO Employee (name, role, address, username, password, birthday) VALEUS (?,?,?,?,?,?)"; 
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, employees.getName());
            statement.setString(2, employees.getRole());
            statement.setString(3, employees.getAddress());
            statement.setString(4, employees.getUserName());
            statement.setString(5, employees.getPassword());
            statement.setDate(6, employees.getBirthday());
        }
    }
    
    public List<Employees> getAllEmployees () throws SQLException {
        List<Employees> employees = new ArrayList<>();
        String sql = "SELECT FROM Employee";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
                while (resultSet.next()) {
                    Employees employee = new Employees();
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setRole(resultSet.getString("role"));
                    employee.setAddress(resultSet.getString("addres"));
                    employee.setUserName(resultSet.getString("username"));
                    employee.setPassword(resultSet.getString("password"));
                    employee.setBirthday(resultSet.getDate("birthday"));
                    employees.add(employee);
                }
            }
            return employees;
    }
    
}
