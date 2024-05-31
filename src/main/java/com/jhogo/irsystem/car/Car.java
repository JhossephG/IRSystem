package com.jhogo.irsystem.car;
public class Car {

    private int manufactureYear,id;
    private double saleValue, purchaseValue;
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
    
    public double getSaleValue() {
        return saleValue;
    }
    
    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }
    
    public double getPurchaseValue() {
        return purchaseValue;
    }
    
    public void setPurchaseValue(double purchaseValue) {
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
    