package com.jhogo.irsystem.repository;

import javax.sql.DataSource;

public class FoodDAO {
    private final DataSource dataSource;

    public FoodDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
