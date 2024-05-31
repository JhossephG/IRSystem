package src.main.java.com.jhogo.irsystem.employees;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesService {
    private EmployeesDAO employeesDAO;

    private void employeesService (EmployeesDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    private void addEmployee(EmployeesDTO employeesDTO) throws SQLException {
        Employees employees = new Employees();
        employees.setName(employeesDTO.getName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthday(employeesDTO.getBirthday());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUserName(employeesDTO.getUserName());
        employeesDAO.insertEmployee(employees);
    }

    private List<EmployeesDTO> getAllEmployees() throws SQLException {
        List<Employees> employees = employeesDAO.getAllEmployees();
        return employees.stream().map(employee -> {
            EmployeesDTO employeesDTO = new EmployeesDTO();
            employeesDTO.setId(employee.getId());
            employeesDTO.setName(employee.getName());
            employeesDTO.setAddress(employee.getAddress());
            employeesDTO.setBirthday(employee.getBirthday());
            employeesDTO.setPassword(employee.getPassword());
            employeesDTO.setRole(employee.getRole());
            employeesDTO.setUserName(employee.getUserName());
            return employeesDTO;
        }).collect(Collectors.toList());
    }

    private void updateEmployee (EmployeesDTO employeesDTO, int employeeId) throws SQLException {
        Employees employees = new Employees();
        employees.setId(employeesDTO.getId());
        employees.setName(employeesDTO.getName());
        employees.setAddress(employeesDTO.getAddress());
        employees.setBirthday(employeesDTO.getBirthday());
        employees.setPassword(employeesDTO.getPassword());
        employees.setRole(employeesDTO.getRole());
        employees.setUserName(employeesDTO.getUserName());
        employeesDAO.updateEmployee(employees);

    }

    private void removeEmployee(int employeeId) throws SQLException {
        employeesDAO.deleteEmployee(employeeId);
    }
}
