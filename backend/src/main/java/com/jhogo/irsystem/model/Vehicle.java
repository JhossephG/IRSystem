package com.jhogo.irsystem.model;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int manufactureYear;
    private int userId;
    private int storeId;
    private BigDecimal saleValue;
    private BigDecimal purchaseValue;
    private String model;
    private String brand;
    private String vehicleIdNumber;
    private boolean availability;

    public int getManufactureYear() {
        return manufactureYear;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public BigDecimal getSaleValue() {
        return saleValue;
    }
    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }
    public BigDecimal getPurchaseValue() {
        return purchaseValue;
    }
    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getVehicleIdNumber() {
        return vehicleIdNumber;
    }
    public void setVehicleIdNumber(String vehicleIdNumber) {
        this.vehicleIdNumber = vehicleIdNumber;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    }
    