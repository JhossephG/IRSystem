package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.EmployeeDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.Employee;
import com.jhogo.irsystem.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private final EmployeeDAO employeesDAO;

    private EmployeeService (EmployeeDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    public void addEmployee(EmployeeDTO employeesDTO, int storeId) {
        try {
            Employee employees = new Employee();
            employees.setFullName(employeesDTO.getFullName());
            employees.setAddress(employeesDTO.getAddress());
            employees.setBirthDate(employeesDTO.getBirthDate());
            employees.setPassword(employeesDTO.getPassword());
            employees.setRole(employeesDTO.getRole());
            employees.setUsername(employeesDTO.getUsername());
            employees.setWage(employeesDTO.getWage());
            employees.setStore_id(storeId);
            employeesDAO.insertEmployee(employees);
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new employee", e);
        }
    }

    public EmployeeDTO getEmployeeById (int employeeId) {
        try {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            Employee employee = employeesDAO.getEmployeeById(employeeId);
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setIdNumber(employee.getIdNumber());
            employeeDTO.setPassword(employee.getPassword());
            employeeDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setBirthDate(employee.getBirthDate());
            employeeDTO.setFullName(employee.getFullName());
            employeeDTO.setRole(employee.getRole());
            employeeDTO.setWage(employee.getWage());
            return employeeDTO;
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting employee using the id "+ employeeId, e);
        }
    }

    public List<EmployeeDTO> getAllEmployees() {
        try {
            List<Employee> employees = employeesDAO.getAllEmployees();
            return employees.stream().map(employee -> {
                EmployeeDTO employeesDTO = new EmployeeDTO();
                employeesDTO.setId(employee.getId());
                employeesDTO.setFullName(employee.getFullName());
                employeesDTO.setAddress(employee.getAddress());
                employeesDTO.setBirthDate(employee.getBirthDate());
                employeesDTO.setPassword(employee.getPassword());
                employeesDTO.setRole(employee.getRole());
                employeesDTO.setUsername(employee.getUsername());
                employeesDTO.setWage(employee.getWage());
                return employeesDTO;
            }).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting employees", e);
        }
    }

    public void updateEmployee (EmployeeDTO employeesDTO, int employeeId) { //missing use the employeeId in DAO layer
        try {
            Employee employee = new Employee();
            employee.setId(employeesDTO.getId());
            employee.setFullName(employeesDTO.getFullName());
            employee.setAddress(employeesDTO.getAddress());
            employee.setBirthDate(employeesDTO.getBirthDate());
            employee.setPassword(employeesDTO.getPassword());
            employee.setRole(employeesDTO.getRole());
            employee.setUsername(employeesDTO.getUsername());
            employee.setWage(employeesDTO.getWage());
            employeesDAO.updateEmployee(employee, employeeId);
        } catch (SQLException e) {
            throw new CustomSQLException("Error updating employee with id "+employeeId, e);
        }
    }

    public void deleteEmployee(int employeeId) {
        try {
            employeesDAO.deleteEmployee(employeeId);
        } catch (SQLException e) {
            throw new CustomSQLException("Error deleting employee with id "+employeeId, e);
        }
    }
}
