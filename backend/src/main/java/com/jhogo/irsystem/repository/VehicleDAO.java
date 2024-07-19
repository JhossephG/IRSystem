package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.model.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final DataSource dataSource;

    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVehicle(Vehicle vehicle) throws SQLException {
        String sql ="INSERT INTO Vehicle (model, brand, vehicleIdNumber, manufactureYear, saleValue, purchaseValue, availability) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getVehicleIdNumber());
            stmt.setInt(4, vehicle.getManufactureYear());
            stmt.setBigDecimal(5, vehicle.getSaleValue());
            stmt.setBigDecimal(6, vehicle.getPurchaseValue());
            stmt.setBoolean(7, vehicle.isAvailability());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vehicle.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle";
        try (Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
            ResultSet resul = stmt.executeQuery(sql)) {
                while (resul.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resul.getInt("id"));
                    vehicle.setModel(resul.getString("model"));
                    vehicle.setBrand(resul.getString("brand"));
                    vehicle.setVehicleIdNumber(resul.getString("vehicleIdNumber"));
                    vehicle.setManufactureYear(resul.getInt("manufactureYear"));
                    vehicle.setSaleValue(resul.getBigDecimal("saleValue"));
                    vehicle.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    vehicle.setAvailability(resul.getBoolean("availability"));
                    cars.add(vehicle);
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
        String sql = "SELECT * FROM Vehicle WHERE user_id=?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet resul = stmt.executeQuery()) {
                while (resul.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resul.getInt("id"));
                    vehicle.setModel(resul.getString("model"));
                    vehicle.setBrand(resul.getString("brand"));
                    vehicle.setVehicleIdNumber(resul.getString("vehicleIdNumber"));
                    vehicle.setManufactureYear(resul.getInt("manufactureYear"));
                    vehicle.setSaleValue(resul.getBigDecimal("saleValue"));
                    vehicle.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    vehicle.setAvailability(resul.getBoolean("availability"));
                    vehicle.setStore_id(resul.getInt("store_id"));
                    vehicle.setOrder_id(resul.getInt("user_id"));
                    cars.add(vehicle);
                }
            }
        }
        return cars;
    }

    public List<Vehicle> getVehiclesByStoreId(int storeId) throws SQLException {
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE store_id=?";
        try(Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, storeId);
            try(ResultSet resul = stmt.executeQuery()) {
                while (resul.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resul.getInt("id"));
                    vehicle.setModel(resul.getString("model"));
                    vehicle.setBrand(resul.getString("brand"));
                    vehicle.setVehicleIdNumber(resul.getString("getVehicleIdNumber"));
                    vehicle.setManufactureYear(resul.getInt("manufactureYear"));
                    vehicle.setSaleValue(resul.getBigDecimal("saleValue"));
                    vehicle.setPurchaseValue(resul.getBigDecimal("purchaseValue"));
                    vehicle.setAvailability(resul.getBoolean("inStore"));
                    vehicle.setStore_id(resul.getInt("store_id"));
                    vehicle.setOrder_id(resul.getInt("user_id"));
                    cars.add(vehicle);
                }
            }
        }
        return cars;
    }

    public void updateVehicle(Vehicle vehicle, int vehicleId) throws SQLException {
        String sql = "UPDATE Vehicle SET model=?, brand=?, vehicleIdNumber=?, manufactureYear=?, saleValue=?, purchaseValue=?, availability=? WHERE id=?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getVehicleIdNumber());
            stmt.setInt(4, vehicle.getManufactureYear());
            stmt.setBigDecimal(5, vehicle.getSaleValue());
            stmt.setBigDecimal(6, vehicle.getPurchaseValue());
            stmt.setBoolean(7, vehicle.isAvailability());
            stmt.setInt(8, vehicleId);
            stmt.executeUpdate();
        }
    }

    public void deleteVehicle(int vehicleId) throws SQLException {
        String sql = "DELETE FROM Vehicle WHERE id=?";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, vehicleId);
            stmt.executeUpdate();
        } 
    }
}
