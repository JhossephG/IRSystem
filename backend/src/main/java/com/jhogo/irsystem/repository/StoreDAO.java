package com.jhogo.irsystem.repository;
import com.jhogo.irsystem.dto.StoreDTO;
import com.jhogo.irsystem.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreDAO {
    private final DataSource dataSource;

    @Autowired
    public StoreDAO(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    public void insertStore(Store store) throws SQLException {
        String sql = "INSERT INTO Store (name, address, registerNumber, balance) VALUES (?,?,?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, store.getName());
            stmt.setString(2, store.getAddress());
            stmt.setString(3, store.getRegisterNumber());
            stmt.setBigDecimal(4, store.getBalance());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    store.setId(generatedKeys.getInt(1));
                }
            }
        }
    }
    public List<Integer> getStoresId() throws SQLException{
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id FROM Store";
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
                while (result.next()) {
                    ids.add(result.getInt("id"));
                }
            }
        return ids;
    }
    public int getIdByStoreName (String storeName) throws SQLException {
        String sql = "SELECT id FROM Store WHERE name = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, storeName);
            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    return result.getInt("id");
                }
                throw new SQLException("No store found with name "+ storeName);
            }
        }
    }

    public Store getStoreById (int storeId) throws SQLException {
        String sql = "SELECT * FROM Store WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, storeId);
             try (ResultSet result = stmt.executeQuery()) {
                 if (result.next()) {
                     Store store = new Store();
                     store.setId(result.getInt("id"));
                     store.setName(result.getString("name"));
                     store.setAddress(result.getString("address"));
                     store.setRegisterNumber(result.getString("registerNumber"));
                     store.setPhoneNumber(result.getString("phoneNumber"));
                     store.setExpenses(result.getBigDecimal("expenses"));
                     store.setBalance(result.getBigDecimal("balance"));
                     store.setTotalOfEmployees(result.getInt("total_of_employees"));
                     store.setTotalOfCars(result.getInt("total_of_cars"));
                     return store;
                 }
                 throw new SQLException("Store not found");
             }
        }
    }

    public List<Store> getAllStores () throws  SQLException {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT * FROM Store";
        try (Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(sql)) {
                while (result.next()) {
                    Store store = new Store();
                    store.setId(result.getInt("id"));
                    store.setName(result.getString("name"));
                    store.setAddress(result.getString("address"));
                    store.setRegisterNumber(result.getString("registerNumber"));
                    store.setPhoneNumber(result.getString("phoneNumber"));
                    store.setExpenses(result.getBigDecimal("expenses"));
                    store.setBalance(result.getBigDecimal("balance"));
                    store.setTotalOfEmployees(result.getInt("total_of_employees"));
                    store.setTotalOfCars(result.getInt("total_of_cars"));
                    stores.add(store);
                }
            }
        return stores;
    }

    public void deleteStore (int storeId) throws SQLException {
        String sql = "DELETE FROM Store WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, storeId);
            stmt.executeUpdate();
        }
    }
}
