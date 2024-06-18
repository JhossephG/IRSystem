package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.EmployeeDTO;
import  com.jhogo.irsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee (@RequestBody EmployeeDTO employeeDTO) throws SQLException {
        employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees () throws SQLException {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById (@PathVariable int employeeId) throws SQLException {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee (@RequestBody EmployeeDTO employeeDTO, @PathVariable int employeeId) throws SQLException {
        employeeService.updateEmployee(employeeDTO, employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee (@PathVariable int employeeId) throws SQLException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
