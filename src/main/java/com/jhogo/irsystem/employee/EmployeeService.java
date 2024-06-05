package com.jhogo.irsystem.employee;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private EmployeeDAO employeesDAO;

    private void employeesService (EmployeeDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    private void addEmployee(EmployeeDTO employeesDTO) throws SQLException {
        Employee employees = new Employee();
        employees.setName(employeesDTO.getName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthday(employeesDTO.getBirthday());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUserName(employeesDTO.getUserName());
        employees.setWage(employeesDTO.getWage());
        employeesDAO.insertEmployee(employees);
    }

    private List<EmployeeDTO> getAllEmployees() throws SQLException {
        List<Employee> employees = employeesDAO.getAllEmployees();
        return employees.stream().map(employee -> {
            EmployeeDTO employeesDTO = new EmployeeDTO();
            employeesDTO.setId(employee.getId());
            employeesDTO.setName(employee.getName());
            employeesDTO.setAddress(employee.getAddress());
            employeesDTO.setBirthday(employee.getBirthday());
            employeesDTO.setPassword(employee.getPassword());
            employeesDTO.setRole(employee.getRole());
            employeesDTO.setUserName(employee.getUserName());
            employeesDTO.setWage(employee.getWage());
            return employeesDTO;
        }).collect(Collectors.toList());
    }

    private void updateEmployee (EmployeeDTO employeesDTO, int employeeId) throws SQLException {
        Employee employees = new Employee();
        employees.setId(employeesDTO.getId());
        employees.setName(employeesDTO.getName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthday(employeesDTO.getBirthday());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUserName(employeesDTO.getUserName());
        employees.setWage(employeesDTO.getWage());
        employeesDAO.updateEmployee(employees);

    }

    private void removeEmployee(int employeeId) throws SQLException {
        employeesDAO.deleteEmployee(employeeId);
    }
}
