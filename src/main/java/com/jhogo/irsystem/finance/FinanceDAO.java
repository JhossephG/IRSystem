package com.jhogo.irsystem.finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class FinanceDAO {
    private Connection connection;

    public FinanceDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertExpense(Finance expense) throws SQLException {
        String sql = "INSERT INTO Finance (description, value, carId) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, expense.getDescription());
            statement.setBigDecimal(2, expense.getValue());
            if (expense.getCarId() != null) {
                statement.setInt(3, expense.getCarId());
            } else {
                statement.setNull(3, Types.INTEGER);
            }
            statement.executeUpdate();
        }
    }
}
