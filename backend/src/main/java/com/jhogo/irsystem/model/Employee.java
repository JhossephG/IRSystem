package com.jhogo.irsystem.model;
import com.jhogo.irsystem.common.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="employee")
public class Employee extends Person {
    private String role;
    private BigDecimal wage;
    private int storeId;
    
    // Getters and setters for additional fields
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public BigDecimal getWage() {
        return wage;
    }
    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }
}
