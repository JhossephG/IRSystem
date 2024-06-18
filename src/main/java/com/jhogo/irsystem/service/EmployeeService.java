package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.EmployeeDTO;
import com.jhogo.irsystem.model.Employee;
import com.jhogo.irsystem.repository.EmployeeDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeDAO employeesDAO;

    private EmployeeService (EmployeeDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    public void addEmployee(EmployeeDTO employeesDTO) throws SQLException {
        Employee employees = new Employee();
        employees.setFullName(employeesDTO.getFullName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthDate(employeesDTO.getBirthDate());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUsername(employeesDTO.getUsername());
        employees.setWage(employeesDTO.getWage());
        employeesDAO.insertEmployee(employees);
    }

    public EmployeeDTO getEmployeeById (int employeeId) throws SQLException {
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
            employeeDTO.setStoreId(employee.getStoreId());
            return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() throws SQLException {
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
    }

    public void updateEmployee (EmployeeDTO employeesDTO, int employeeId) throws SQLException {
        Employee employees = new Employee();
        employees.setId(employeesDTO.getId());
        employees.setFullName(employeesDTO.getFullName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthDate(employeesDTO.getBirthDate());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUsername(employeesDTO.getUsername());
        employees.setWage(employeesDTO.getWage());
        employeesDAO.updateEmployee(employees);

    }

    public void deleteEmployee(int employeeId) throws SQLException {
        employeesDAO.deleteEmployee(employeeId);
    }
}
