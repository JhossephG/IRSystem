package com.jhogo.irsystem.user;

import com.jhogo.irsystem.common.Person;

public class UserDTO extends Person {
    private String idNumber;
    private String phoneNumber;
    private String email;
    
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
}
