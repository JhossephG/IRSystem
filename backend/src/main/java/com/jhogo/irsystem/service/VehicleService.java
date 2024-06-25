package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.Vehicle;
import com.jhogo.irsystem.repository.VehicleDAO;
import com.jhogo.irsystem.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements Converter<Vehicle, VehicleDTO> {
    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleService (VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void addVehicle (VehicleDTO vehicleDTO) {
        try {
            vehicleDAO.insertVehicle(convertToModel(vehicleDTO));
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new vehicle", e);
        }
    }

    public List<VehicleDTO> getAllVehicles () {
        try {
            List<Vehicle> cars = vehicleDAO.getAllVehicles();
            return cars.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting vehicles list", e);
        }
    }

    public VehicleDTO getVehicleById (int vehicleId) {
        try {
            Vehicle vehicle = vehicleDAO.getVehicleById(vehicleId);
            return convertToDTO(vehicle);
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting vehicle with id "+vehicleId, e);
        }
    }

    public void updateVehicle (VehicleDTO vehicleDTO, int vehicleId) {
        try {
        vehicleDAO.updateVehicle(convertToModel(vehicleDTO), vehicleId);
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

    @Override
    public Vehicle convertToModel(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setVehicleIdNumber(vehicleDTO.getVehicleIdNumber());
        vehicle.setManufactureYear(vehicleDTO.getManufactureYear());
        vehicle.setSaleValue(vehicleDTO.getSaleValue());
        vehicle.setPurchaseValue(vehicleDTO.getPurchaseValue());
        vehicle.setAvailability(vehicleDTO.isAvailability());
        return vehicle;
    }

    @Override
    public VehicleDTO convertToDTO(Vehicle vehicle) {
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
    }
}
