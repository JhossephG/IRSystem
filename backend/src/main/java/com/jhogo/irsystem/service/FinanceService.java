package com.jhogo.irsystem.service;

import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.model.Finance;
import com.jhogo.irsystem.repository.FinanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

// The purpose of this class is to follow the SRP (Single Responsibility Principle) representing the financial logic
@Service
public class FinanceService {
    private final FinanceDAO financeDAO;

    @Autowired
    public FinanceService(FinanceDAO financeDAO) {
        this.financeDAO = financeDAO;
    }

    public void addExpense(String description, BigDecimal value, int carId) {
        try {
            Finance expense = new Finance();
            expense.setDescription(description);
            expense.setValue(value);
            expense.setVehicle_id(carId);
            financeDAO.insertExpense(expense);
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding new expense", e);
        }
    }

    public void addToBalance (BigDecimal value, int storeId) {
        try {
            if (value.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Negative values are not allowed.");
                return;
            }
            financeDAO.addToBalance(value, storeId);
        } catch (SQLException e) {
           throw new CustomSQLException("Error adding value to balance", e);
        }
    }
}
