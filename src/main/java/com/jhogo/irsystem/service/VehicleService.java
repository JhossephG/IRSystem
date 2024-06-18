package com.jhogo.irsystem.service;
import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.model.Vehicle;
import com.jhogo.irsystem.repository.VehicleDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
    private final VehicleDAO vehicleDAO;

    public VehicleService(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void addCar(VehicleDTO vehicleDTO) throws SQLException {
        Vehicle car = new Vehicle();
        car.setModel(vehicleDTO.getModel());
        car.setBrand(vehicleDTO.getBrand());
        car.setVehicleIdNumber(vehicleDTO.getVehicleIdNumber());
        car.setManufactureYear(vehicleDTO.getManufactureYear());
        car.setSaleValue(vehicleDTO.getSaleValue());
        car.setPurchaseValue(vehicleDTO.getPurchaseValue());
        car.setAvailability(vehicleDTO.isAvailability());
        vehicleDAO.insertVehicle(car);
    }

    public List<VehicleDTO> getAllCars() throws SQLException {
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
    }

    public void updateCar(VehicleDTO vehicleDTO, int carId) throws SQLException {
        Vehicle car = new Vehicle();
        car.setId(carId);
        car.setModel(vehicleDTO.getModel());
        car.setBrand(vehicleDTO.getBrand());
        car.setVehicleIdNumber(vehicleDTO.getVehicleIdNumber());
        car.setManufactureYear(vehicleDTO.getManufactureYear());
        car.setSaleValue(vehicleDTO.getSaleValue());
        car.setPurchaseValue(vehicleDTO.getPurchaseValue());
        car.setAvailability(vehicleDTO.isAvailability());
        vehicleDAO.updateVehicle(car);
    }

    public void removeCarFromStore(int carId) throws SQLException {
        vehicleDAO.deleteVehicle(carId);
    }
}
