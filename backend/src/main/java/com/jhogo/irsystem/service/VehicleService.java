package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.Vehicle;
import com.jhogo.irsystem.repository.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
    private final VehicleDAO vehicleDAO;

    public VehicleService (VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void addVehicle (VehicleDTO vehicleDTO) {
        try {
            Vehicle car = new Vehicle();
            car.setModel(vehicleDTO.getModel());
            car.setBrand(vehicleDTO.getBrand());
            car.setVehicleIdNumber(vehicleDTO.getVehicleIdNumber());
            car.setManufactureYear(vehicleDTO.getManufactureYear());
            car.setSaleValue(vehicleDTO.getSaleValue());
            car.setPurchaseValue(vehicleDTO.getPurchaseValue());
            car.setAvailability(vehicleDTO.isAvailability());
            vehicleDAO.insertVehicle(car);
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new vehicle", e);
        }
    }

    public List<VehicleDTO> getAllVehicles () {
        try {
            List<Vehicle> cars = vehicleDAO.getAllVehicles();
            return cars.stream().map(car -> {
                VehicleDTO vehicleDTO = new VehicleDTO();
                vehicleDTO.setId(car.getId());
                vehicleDTO.setModel(car.getModel());
                vehicleDTO.setBrand(car.getBrand());
                vehicleDTO.setVehicleIdNumber(car.getVehicleIdNumber());
                vehicleDTO.setManufactureYear(car.getManufactureYear());
                vehicleDTO.setSaleValue(car.getSaleValue());
                vehicleDTO.setPurchaseValue(car.getPurchaseValue());
                vehicleDTO.setAvailability(car.isAvailability());
                return vehicleDTO;
            }).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting vehicles list", e);
        }
    }

    public VehicleDTO getVehicleById (int vehicleId) {
        try {
            Vehicle vehicle = vehicleDAO.getVehicleById(vehicleId);
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setId(vehicle.getId());
            vehicleDTO.setModel(vehicle.getModel());
            vehicleDTO.setBrand(vehicle.getBrand());
            vehicleDTO.setVehicleIdNumber(vehicle.getVehicleIdNumber());
            vehicleDTO.setManufactureYear(vehicle.getManufactureYear());
            vehicleDTO.setSaleValue(vehicle.getSaleValue());
            vehicleDTO.setPurchaseValue(vehicle.getPurchaseValue());
            vehicleDTO.setAvailability(vehicle.isAvailability());
            return vehicleDTO;
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting vehicle with id "+vehicleId, e);
        }
    }

    public void updateVehicle (VehicleDTO vehicleDTO, int vehicleId) {
        try {
        Vehicle car = new Vehicle();
        car.setId(vehicleId);
        car.setModel(vehicleDTO.getModel());
        car.setBrand(vehicleDTO.getBrand());
        car.setVehicleIdNumber(vehicleDTO.getVehicleIdNumber());
        car.setManufactureYear(vehicleDTO.getManufactureYear());
        car.setSaleValue(vehicleDTO.getSaleValue());
        car.setPurchaseValue(vehicleDTO.getPurchaseValue());
        car.setAvailability(vehicleDTO.isAvailability());
        vehicleDAO.updateVehicle(car);
        } catch (SQLException e) {
            throw new CustomSQLException("Error updating vehicle with id "+vehicleId, e);
        }
    }

    public void deleteVehicle(int vehicleId) {
        try {
            vehicleDAO.deleteVehicle(vehicleId);
        } catch (SQLException e) {
            throw new CustomSQLException("Error deleting vehicle with id "+vehicleId, e);
        }
    }
}
