package src.main.java.com.jhogo.irsystem.employees;
import java.sql.SQLException;

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
}
