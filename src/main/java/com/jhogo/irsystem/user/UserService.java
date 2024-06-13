package com.jhogo.irsystem.user;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser (UserDTO userDTO) throws SQLException{
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
        userDAO.insertUser(user);
    }

    public List<UserDTO> getAllUsers () throws SQLException {
        List<User> users = userDAO.getAllUsers();
        return users.stream().map(user -> {
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
        }).collect(Collectors.toList());
    }

    public void updateUser (UserDTO userDTO) throws SQLException {
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
        userDAO.updateUser(user);
    }

    public void deleteUser (int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }
}
