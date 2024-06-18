package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.UserDTO;
import  com.jhogo.irsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser (@RequestBody UserDTO userDTO) throws SQLException {
        userService.addUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> getAllUsers () throws SQLException {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable int userId) throws SQLException {
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser (@RequestBody UserDTO userDTO) throws SQLException {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser (@PathVariable int userId) throws SQLException {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
