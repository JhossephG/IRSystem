package com.jhogo.irsystem.dto;

import java.math.BigDecimal;

public class StoreDTO {
    private int id;
    private int totalOfEmployees;
    private int totalOfCars;
    private String name;
    private String address;
    private String registerNumber;
    private String phoneNumber;
    private BigDecimal balance;
    private BigDecimal expenses;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTotalOfEmployees() {
        return totalOfEmployees;
    }
    public void setTotalOfEmployees(int totalOfEmployees) {
        this.totalOfEmployees = totalOfEmployees;
    }
    public int getTotalOfCars() {
        return totalOfCars;
    }
    public void setTotalOfCars(int totalOfCars) {
        this.totalOfCars = totalOfCars;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRegisterNumber() {
        return registerNumber;
    }
    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getExpenses() {
        return expenses;
    }
    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }
}
