package com.jhogo.irsystem.car;
import java.math.BigDecimal;
public class CarDTO {

    private int manufactureYear,id;
    private BigDecimal saleValue, purchaseValue;
    private String model, brand, chassis;
    private boolean inStore;
    
    // public Car(int manufactureYear, int saleValue, int purchaseValue, String model, String brand) {
    //     this.manufactureYear = manufactureYear;
    //     this.saleValue = saleValue;
    //     this.purchaseValue = purchaseValue;
    //     this.model = model;
    //     this.brand = brand;
    // }

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
    
    public String getChassis() {
        return chassis;
    }
    
    public void setChassis(String chassis) {
        this.chassis = chassis;
    }
    
    public boolean isInStore() {
        return inStore;
    }
    
    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    }
    