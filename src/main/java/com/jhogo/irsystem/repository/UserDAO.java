package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection=connection;
    }

    public void insertUser (User user) throws SQLException {
        String sql = "INSERT * INTO User (name, address, birthDate, idNumber, password, phoneNumber, email, lastUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getAddress());
            statement.setDate(3, user.getBirthDate());
            statement.setString(4, user.getIdNumber());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPhoneNumber());
            statement.setString(7, user.getEmail());
            statement.setTimestamp(8, user.getLastUpdated());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public User getUserById (int userId) throws SQLException {
        String sql = "SELECT * FROM User WHERE id=?";
        try(PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, userId);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setIdNumber(rs.getString("idNumber"));
                    user.setLastUpdated(rs.getTimestamp("lastUpdated"));
                    user.setPhoneNumber(rs.getString("password"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setAddress(rs.getString("address"));
                    user.setBirthDate(rs.getDate("birthDate"));
                    user.setFullName(rs.getString("name"));
                    return user;
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers () throws SQLException {
        List <User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
                while(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setIdNumber(rs.getString("idNumber"));
                    user.setLastUpdated(rs.getTimestamp("lastUpdated"));
                    user.setPassword(rs.getString("password"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setAddress(rs.getString("address"));
                    user.setBirthDate(rs.getDate("birthDate"));
                    user.setFullName(rs.getString("name"));
                    users.add(user);
                }
            }
        return users;
    }

    public void updateUser (User user) throws  SQLException{
        String sql = "UPDATE User SET name=?, address=?, birthDate=?, idNumber=?, password=?, phoneNumber=?, email=?, lastUpdated=?, WHERE id=?";
            try(PreparedStatement pst = connection.prepareStatement(sql)) {
                pst.setString(1, user.getFullName());
                pst.setString(2, user.getAddress());
                pst.setDate(3, user.getBirthDate());
                pst.setString(4, user.getIdNumber());
                pst.setString(5, user.getPassword());
                pst.setString(6, user.getPhoneNumber());
                pst.setString(7, user.getEmail());
                pst.setTimestamp(8, user.getLastUpdated());
                pst.setInt(9, user.getId());
                pst.executeUpdate();
        }
    }

    public void deleteUser (int userId) throws  SQLException {
        String sql = "DELETE * FROM User WHERE id=?";
        try(PreparedStatement pst = connection.prepareStatement(sql)){
            pst.setInt(1,userId);
            pst.executeUpdate();
        }
    }
}
