package com.jhogo.irsystem.user;
import java.sql.Timestamp;
import java.util.List;

import com.jhogo.irsystem.vehicle.Vehicle;
import com.jhogo.irsystem.common.Person;

public class User extends Person {
    private List<Vehicle> cars;
    private Timestamp lastUpdated;
    
    // Getters and setters for additional fields
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public List<Vehicle> getCars() {
        return cars;
    }
    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }
}
