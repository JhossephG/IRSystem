package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final DataSource dataSource;

    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVehicle(Vehicle car) throws SQLException {
        String sql ="INSERT INTO Vehicle (model, brand, vehicleIdNumber, manufactureYear, saleValue, purchaseValue, availability) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, car.getModel());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getVehicleIdNumber());
            stmt.setInt(4, car.getManufactureYear());
            stmt.setBigDecimal(5, car.getSaleValue());
            stmt.setBigDecimal(6, car.getPurchaseValue());
            stmt.setBoolean(7, car.isAvailability());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    car.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try (Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
            ResultSet resul = stmt.executeQuery(sql)) {
                while (resul.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resul.getInt("id"));
                    car.setModel(resul.getString("model"));
                    car.setBrand(resul.getString("brand"));
                    car.setVehicleIdNumber(resul.getString("vehicleIdNumber"));
                    car.setManufactureYear(resul.getInt("manufactureYear"));
                    car.setSaleValue(resul.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    car.setAvailability(resul.getBoolean("availability"));
                    cars.add(car); 
                }
            }
            return cars;
    }

    public Vehicle getVehicleById (int vehicleId) throws SQLException {
        String sql = "SELECT * FROM Vehicle WHERE id = ?";
       try (Connection connection = dataSource.getConnection();
               PreparedStatement stmt = connection.prepareStatement(sql)) {
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
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet resul = stmt.executeQuery()) {
                while (resul.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resul.getInt("id"));
                    car.setModel(resul.getString("model"));
                    car.setBrand(resul.getString("brand"));
                    car.setVehicleIdNumber(resul.getString("vehicleIdNumber"));
                    car.setManufactureYear(resul.getInt("manufactureYear"));
                    car.setSaleValue(resul.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    car.setAvailability(resul.getBoolean("availability"));
                    car.setStore_id(resul.getInt("store_id"));
                    car.setUser_id(resul.getInt("user_id"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    public List<Vehicle> getVehiclesByStoreId(int storeId) throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE store_id=?";
        try(Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, storeId);
            try(ResultSet resul = stmt.executeQuery()) {
                while (resul.next()) {
                    Vehicle car = new Vehicle();
                    car.setId(resul.getInt("id"));
                    car.setModel(resul.getString("model"));
                    car.setBrand(resul.getString("brand"));
                    car.setVehicleIdNumber(resul.getString("getVehicleIdNumber"));
                    car.setManufactureYear(resul.getInt("manufactureYear"));
                    car.setSaleValue(resul.getBigDecimal("saleValue"));
                    car.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    car.setAvailability(resul.getBoolean("inStore"));
                    car.setStore_id(resul.getInt("store_id"));
                    car.setUser_id(resul.getInt("user_id"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    public void updateVehicle(Vehicle car) throws SQLException {
        String sql = "UPDATE Car SET model=?, brand=?, vehicleIdNumber=?, manufactureYear=?, saleValue=?, purchaseValue=?, availability=? WHERE id=?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, car.getModel());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getVehicleIdNumber());
            stmt.setInt(4, car.getManufactureYear());
            stmt.setBigDecimal(5, car.getSaleValue());
            stmt.setBigDecimal(6, car.getPurchaseValue());
            stmt.setBoolean(7, car.isAvailability());
            stmt.setInt(8, car.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteVehicle(int carId) throws SQLException {
        String sql = "DELETE FROM Car WHERE id=?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, carId);
            stmt.executeUpdate();
        } 
    }
}
