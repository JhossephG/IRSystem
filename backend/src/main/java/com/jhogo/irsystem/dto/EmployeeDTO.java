package com.jhogo.irsystem.dto;
import com.jhogo.irsystem.common.Person;

import java.math.BigDecimal;

public class EmployeeDTO extends Person {
    private String role;
    private BigDecimal wage;

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
}
