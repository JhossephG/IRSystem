package com.jhogo.irsystem.store;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {
    private Connection connection;

    public StoreDAO(Connection connection) {
        this.connection=connection;
    }

    public void insertStore(Store store) throws SQLException {
        String sql = "INSERT * INTO Store (name, address, registerNumber, balance) VALUES (?,?,?,?)";
        try(PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, store.getName());
            pst.setString(2, store.getAddress());
            pst.setString(3, store.getRegisterNumber());
            pst.setBigDecimal(4, store.getBalance());
            pst.executeUpdate();
        }
    }
    public List<Integer> getStoreId () throws SQLException{
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT * FROM Store";
        try (Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
               int id = result.getInt("id");
               ids.add(id);
            }
        }
        return ids;
    }
}
