package com.jhogo.irsystem.finance;

import java.math.BigDecimal;
import java.sql.SQLException;

// The purpose of this class is to follow the SRP (Single Responsibility Principle) representing the financial logic
public class FinanceService {
    private FinanceDAO financeDAO;

    public FinanceService(FinanceDAO financeDAO) {
        this.financeDAO = financeDAO;
    }

    public void addExpense(String description, BigDecimal value, int carId) throws SQLException {
        Finance expense = new Finance();
        expense.setDescription(description);
        expense.setValue(value);
        expense.setCarId(carId);
        financeDAO.insertExpense(expense);
    }
}
