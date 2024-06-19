package com.jhogo.irsystem.dto;
import java.math.BigDecimal;

public class VehicleDTO {

    private int id;
    private int manufactureYear;
    private BigDecimal saleValue;
    private BigDecimal purchaseValue;
    private String model;
    private String brand;
    private String vehicleIdNumber;
    private boolean availability;

    public int getManufactureYear() {
        return manufactureYear;
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
    