package com.jhogo.irsystem.model;
import com.jhogo.irsystem.common.Person;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Employee extends Person {
    private String role;
    private BigDecimal wage;
    private int store_id;

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public BigDecimal getWage() {
        return wage;
    }
    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }
    public int getStore_id() {
        return store_id;
    }
    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
}
