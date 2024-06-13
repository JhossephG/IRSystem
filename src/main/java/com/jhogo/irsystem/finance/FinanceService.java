package com.jhogo.irsystem.finance;

import java.math.BigDecimal;
import java.sql.SQLException;

// The purpose of this class is to follow the SRP (Single Responsibility Principle) representing the financial logic
public class FinanceService {
    private final FinanceDAO financeDAO;

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

    public void addToBalance (BigDecimal value, int storeId) throws SQLException {
        if(value.compareTo(BigDecimal.ZERO) < 0)  {
            System.out.println("Negative values are not allowed.");
            return;
        }
        financeDAO.addToBalance(value, storeId);
    }
}
