package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private final DataSource dataSource;

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertUser (User user) throws SQLException {
        String sql = "INSERT * INTO User (name, address, birthDate, idNumber, password, phoneNumber, email, lastUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getAddress());
            stmt.setDate(3, user.getBirthDate());
            stmt.setString(4, user.getIdNumber());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getPhoneNumber());
            stmt.setString(7, user.getEmail());
            stmt.setTimestamp(8, user.getLastUpdated());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public User getUserById (int userId) throws SQLException {
        String sql = "SELECT * FROM User WHERE id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet result = stmt.executeQuery()){
                if(result.next()){
                    User user = new User();
                    user.setId(result.getInt("id"));
                    user.setEmail(result.getString("email"));
                    user.setIdNumber(result.getString("idNumber"));
                    user.setLastUpdated(result.getTimestamp("lastUpdated"));
                    user.setPhoneNumber(result.getString("password"));
                    user.setPhoneNumber(result.getString("phoneNumber"));
                    user.setAddress(result.getString("address"));
                    user.setBirthDate(result.getDate("birthDate"));
                    user.setFullName(result.getString("name"));
                    return user;
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers () throws SQLException {
        List <User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(sql)) {
                while(result.next()){
                    User user = new User();
                    user.setId(result.getInt("id"));
                    user.setEmail(result.getString("email"));
                    user.setIdNumber(result.getString("idNumber"));
                    user.setLastUpdated(result.getTimestamp("lastUpdated"));
                    user.setPassword(result.getString("password"));
                    user.setPhoneNumber(result.getString("phoneNumber"));
                    user.setAddress(result.getString("address"));
                    user.setBirthDate(result.getDate("birthDate"));
                    user.setFullName(result.getString("name"));
                    users.add(user);
                }
            }
        return users;
    }

    public void updateUser (User user) throws  SQLException{
        String sql = "UPDATE User SET name=?, address=?, birthDate=?, idNumber=?, password=?, phoneNumber=?, email=?, lastUpdated=?, WHERE id=?";
            try(Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, user.getFullName());
                stmt.setString(2, user.getAddress());
                stmt.setDate(3, user.getBirthDate());
                stmt.setString(4, user.getIdNumber());
                stmt.setString(5, user.getPassword());
                stmt.setString(6, user.getPhoneNumber());
                stmt.setString(7, user.getEmail());
                stmt.setTimestamp(8, user.getLastUpdated());
                stmt.setInt(9, user.getId());
                stmt.executeUpdate();
        }
    }

    public void deleteUser (int userId) throws  SQLException {
        String sql = "DELETE * FROM User WHERE id=?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,userId);
            stmt.executeUpdate();
        }
    }
}
