package com.jhogo.irsystem.finance;

import java.math.BigDecimal;

// The purpose of this class is to follow the SRP (Single Responsibility Principle) representing the financial data
public class FinanceDTO {
    private int id;
    private BigDecimal value;
    private BigDecimal indicator; // Valor a ser definido pelo administrador da empresa como valor limite para indicar a "saude" do negocio
    private String description;
    private boolean businessHealth;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public BigDecimal getIndicator() {
        return indicator;
    }
    public void setIndicator(BigDecimal indicator) {
        this.indicator = indicator;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isBusinessHealth() {
        return businessHealth;
    }
    public void setBusinessHealth(boolean businessHealth) {
        this.businessHealth = businessHealth;
    }
}
