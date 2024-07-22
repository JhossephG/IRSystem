package com.jhogo.irsystem.repository;

import javax.sql.DataSource;

public class OrderDAO {
    private final DataSource dataSource;

    public OrderDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
