package com.jhogo.irsystem.employee;
import com.jhogo.irsystem.common.Person;

public class EmployeeDTO extends Person {
    private String userName;
    private String role;
    private String password;
    
    // Getters and setters for additional fields
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
