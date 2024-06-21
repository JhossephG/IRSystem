package com.jhogo.irsystem.dto;

import com.jhogo.irsystem.common.Person;
import com.jhogo.irsystem.model.Vehicle;

import java.util.List;

public class UserDTO extends Person {
    private List<Vehicle> cars;

    public List<Vehicle> getCars() {
        return cars;
    }
}
