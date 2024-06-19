package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.FinanceDTO;
import com.jhogo.irsystem.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping
    public ResponseEntity<FinanceDTO> createExpense (String description, BigDecimal value, int carId) {
        financeService.addExpense(description, value, carId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
