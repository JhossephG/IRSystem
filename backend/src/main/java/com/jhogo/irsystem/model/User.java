package com.jhogo.irsystem.model;
import java.sql.Timestamp;
import java.util.List;

import com.jhogo.irsystem.common.Person;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends Person {
    private List<Vehicle> cars;
    private Timestamp lastUpdated;

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
