package com.jhogo.irsystem.employee;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeDAO employeesDAO;

    private EmployeeService (EmployeeDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    private void addEmployee(EmployeeDTO employeesDTO) throws SQLException {
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

    private List<EmployeeDTO> getAllEmployees() throws SQLException {
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

    private void updateEmployee (EmployeeDTO employeesDTO, int employeeId) throws SQLException {
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

    private void removeEmployee(int employeeId) throws SQLException {
        employeesDAO.deleteEmployee(employeeId);
    }
}
