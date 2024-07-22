package com.jhogo.irsystem.repository;

import javax.sql.DataSource;

public class OrderItemsDAO {
    private final DataSource dataSource;

    public OrderItemsDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
