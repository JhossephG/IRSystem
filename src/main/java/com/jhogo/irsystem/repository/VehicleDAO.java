package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private Connection connection;

    public VehicleDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertVehicle(Vehicle car) throws SQLException {
        String sql ="INSERT INTO Car (model, brand, vehicleIdNumber, manufactureYear, saleValue, purchaseValue, availability) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getVehicleIdNumber());
            statement.setInt(4, car.getManufactureYear());
            statement.setBigDecimal(5, car.getSaleValue());
            statement.setBigDecimal(6, car.getPurchaseValue());
            statement.setBoolean(7, car.isAvailability());
            statement.executeUpdate();
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resultSet.getInt("id"));
                    car.setModel(resultSet.getString("model"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setVehicleIdNumber(resultSet.getString("vehicleIdNumber"));
                    car.setManufactureYear(resultSet.getInt("manufactureYear"));
                    car.setSaleValue(resultSet.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resultSet.getBigDecimal("purchaseValue"));
                    car.setAvailability(resultSet.getBoolean("availability"));
                    cars.add(car); 
                }
            }
            return cars;
    }

    public Vehicle getVehicleById (int vehicleId) throws SQLException {
        String sql = "SELECT * FROM Vehicle WHERE id = ?";
       try (PreparedStatement stmt = connection.prepareStatement(sql)) {
           stmt.setInt(1, vehicleId);
           try (ResultSet result = stmt.executeQuery()) {
               if (result.next()) {
                   Vehicle vehicle = new Vehicle();
                   vehicle.setId(result.getInt("id"));
                   vehicle.setModel(result.getString("model"));
                   vehicle.setBrand(result.getString("brand"));
                   vehicle.setVehicleIdNumber(result.getString("vehicleIdNumber"));
                   vehicle.setManufactureYear(result.getInt("manufactureYear"));
                   vehicle.setSaleValue(result.getBigDecimal("saleValue"));
                   vehicle.setPurchaseValue(result.getBigDecimal("purchaseValue"));
                   vehicle.setAvailability(result.getBoolean("availability"));
                   return vehicle;
               }
           }
       }
       return null;
    }

    public List<Vehicle> getVehiclesByUserId(int userId) throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE user_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resultSet.getInt("id"));
                    car.setModel(resultSet.getString("model"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setVehicleIdNumber(resultSet.getString("vehicleIdNumber"));
                    car.setManufactureYear(resultSet.getInt("manufactureYear"));
                    car.setSaleValue(resultSet.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resultSet.getBigDecimal("purchaseValue"));
                    car.setAvailability(resultSet.getBoolean("availability"));
                    car.setStoreId(resultSet.getInt("store_id"));
                    car.setUserId(resultSet.getInt("user_id"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    public List<Vehicle> getVehiclesByStoreId(int storeId) throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE store_id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, storeId);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resultSet.getInt("id"));
                    car.setModel(resultSet.getString("model"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setVehicleIdNumber(resultSet.getString("getVehicleIdNumber"));
                    car.setManufactureYear(resultSet.getInt("manufactureYear"));
                    car.setSaleValue(resultSet.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resultSet.getBigDecimal("purchaseValue"));
                    car.setAvailability(resultSet.getBoolean("inStore"));
                    car.setStoreId(resultSet.getInt("store_id"));
                    car.setUserId(resultSet.getInt("user_id"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    public void updateVehicle(Vehicle car) throws SQLException {
        String sql = "UPDATE Car SET model=?, brand=?, vehicleIdNumber=?, manufactureYear=?, saleValue=?, purchaseValue=?, availability=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getVehicleIdNumber());
            statement.setInt(4, car.getManufactureYear());
            statement.setBigDecimal(5, car.getSaleValue());
            statement.setBigDecimal(6, car.getPurchaseValue());
            statement.setBoolean(7, car.isAvailability());
            statement.setInt(8, car.getId());
            statement.executeUpdate(); 
        }
    }

    public void deleteVehicle(int carId) throws SQLException {
        String sql = "DELETE FROM Car WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, carId);
            statement.executeUpdate();
        } 
    }
}
