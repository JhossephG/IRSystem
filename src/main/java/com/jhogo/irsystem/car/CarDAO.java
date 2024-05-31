package com.jhogo.irsystem.car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertCar(Car car) throws SQLException {
        String sql ="INSERT INTO Car (model, brand, chassis, manufactureYear, saleValue, purchaseValue, inStore) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getChassis());
            statement.setInt(4, car.getManufactureYear());
            statement.setDouble(5, car.getSaleValue());
            statement.setDouble(6, car.getPurchaseValue());
            statement.setBoolean(7, car.isInStore());
            statement.executeUpdate();
        }
    }

    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setModel(resultSet.getString("model"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setChassis(resultSet.getString("chassis"));
                    car.setManufactureYear(resultSet.getInt("manufactureYear"));
                    car.setSaleValue(resultSet.getDouble("saleValue"));
                    car.setPurchaseValue(resultSet.getDouble("purchaseValue"));
                    car.setInStore(resultSet.getBoolean("inStore"));
                    cars.add(car); 
                }
            }
            return cars;
    }

    public void updateCar(Car car) throws SQLException {
        String sql = "UPDATE Car SET model=?, brand=?, chassis=?, manufactureYear=?, saleValue=?, purchaseValue=?, inStore=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, car.getModel());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getChassis());
            statement.setInt(4, car.getManufactureYear());
            statement.setDouble(5, car.getSaleValue());
            statement.setDouble(6, car.getPurchaseValue());
            statement.setBoolean(7, car.isInStore());
            statement.setInt(8, car.getId());
            statement.executeUpdate(); 
        }
    }

    public void deleteCar(int carId) throws SQLException {
        String sql = "DELETE FROM Car WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, carId);
            statement.executeUpdate();
        } 
    }
}
