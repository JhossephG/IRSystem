package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.EmployeeDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.Employee;
import com.jhogo.irsystem.repository.EmployeeDAO;
import com.jhogo.irsystem.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements Converter<Employee, EmployeeDTO> {

    private final EmployeeDAO employeesDAO;
    private final StoreService storeService;

    @Autowired
    public EmployeeService (EmployeeDAO employeesDAO, StoreService storeService){
        this.employeesDAO = employeesDAO;
        this.storeService = storeService;
    }

    public void addEmployee(EmployeeDTO employeeDTO, int storeId) {
        try {
            List<Integer> storeIds = storeService.getStoresId();
            if (storeIds.contains(storeId)) {
                employeesDAO.insertEmployee(convertToModel(employeeDTO), storeId);
            }
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new employee", e);
        }
    }

    public EmployeeDTO getEmployeeById (int employeeId) {
        try {
            Employee employee = employeesDAO.getEmployeeById(employeeId);
            return convertToDTO(employee);
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

    @Override
    public Employee convertToModel(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFullName(employeeDTO.getFullName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setPassword(employeeDTO.getPassword());
        employee.setRole(employeeDTO.getRole());
        employee.setUsername(employeeDTO.getUsername());
        employee.setWage(employeeDTO.getWage());
        return employee;
    }

    @Override
    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
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
    }
}
