package com.jhogo.irsystem.model;
import com.jhogo.irsystem.common.Product;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Vehicle extends Product {
    private int manufactureYear;
    private String model;
    private String brand;
    private String vehicleIdNumber;

    public int getManufactureYear() {
        return manufactureYear;
    }
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
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
}
    