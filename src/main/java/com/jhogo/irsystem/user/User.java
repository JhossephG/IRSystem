package com.jhogo.irsystem.user;
import java.sql.Timestamp;
import com.jhogo.irsystem.common.Person;

public class User extends Person {
    private String idNumber;
    private String phoneNumber;
    private String email;
    private Timestamp lastUpdated;
    
    // Getters and setters for additional fields
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}