package com.jhogo.irsystem.service;

import com.jhogo.irsystem.dto.UserDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.User;
import com.jhogo.irsystem.repository.UserDAO;
import com.jhogo.irsystem.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements Converter<User, UserDTO> {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser (UserDTO userDTO) {
        try {
            userDAO.insertUser(convertToModel(userDTO));
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new user", e);
        }
    }

    public List<UserDTO> getAllUsers () {
        try {
            List<User> users = userDAO.getAllUsers();
            return users.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new CustomSQLException("Error while retrieving users", e);
        }
    }

    public UserDTO getUserById (int id) {
       try {
           User user = userDAO.getUserById(id);
           return convertToDTO(user);
       } catch (SQLException e) {
           throw new CustomSQLException("Error getting user by id "+id, e);
       }
    }

    public void updateUser (UserDTO userDTO) {
        try {
            userDAO.updateUser(convertToModel(userDTO));
        } catch (SQLException e) {
            throw new CustomSQLException("Error updating user", e);
        }
    }

    public void deleteUser (int userId) {
        try {
            userDAO.deleteUser(userId);
        } catch (SQLException e) {
            throw new CustomSQLException("Error deleting user with id "+userId, e);
        }
    }

    @Override
    public User convertToModel(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setBirthDate(userDTO.getBirthDate());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setIdNumber(userDTO.getIdNumber());
        user.setEmail(userDTO.getEmail());
        user.setLastUpdated(user.getLastUpdated());
        return user;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setAddress(user.getAddress());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setIdNumber(user.getIdNumber());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
