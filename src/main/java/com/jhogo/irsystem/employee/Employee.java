package com.jhogo.irsystem.employee;
import com.jhogo.irsystem.common.Person;

public class Employee extends Person {
    private String userName;
    private String role;
    private String password;
    private int storeId;
    
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
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
