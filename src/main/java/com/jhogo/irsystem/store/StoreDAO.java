package com.jhogo.irsystem.store;
import java.sql.*;

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
}
