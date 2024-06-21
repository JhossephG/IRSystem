package com.jhogo.irsystem.model;

import java.math.BigDecimal;

// The purpose of this class is to follow the SRP (Single Responsibility Principle) representing the financial data
public class Finance {

    private int id;
    private Integer vehicle_id; // Relationship field with vehicle
    private BigDecimal value;
    private BigDecimal indicator; // Value to be defined by the admin of the company as a limit value to indicate the business "health"
    private String description;
    private boolean businessHealth;

    public Integer getVehicle_id() {
        return vehicle_id;
    }
    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
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
