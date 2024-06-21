package com.jhogo.irsystem.repository;

import com.jhogo.irsystem.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

public class FinanceDAO {
    private final DataSource dataSource;

    public FinanceDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertExpense(Finance expense) throws SQLException {
        String sql = "INSERT INTO Finance (description, value, carId) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, expense.getDescription());
            stmt.setBigDecimal(2, expense.getValue());
            if (expense.getVehicle_id() != null) {
                stmt.setInt(3, expense.getVehicle_id());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    expense.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public void addToBalance(BigDecimal value, int storeId) throws  SQLException{
        String sql = "UPDATE Store SET balance=balance + ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBigDecimal(1, value);
            stmt.executeUpdate();
        }
    }
}
