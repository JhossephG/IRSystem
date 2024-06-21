package com.jhogo.irsystem.config;

import com.jhogo.irsystem.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public EmployeeDAO employeeDAO(DataSource dataSource) {
        return new EmployeeDAO(dataSource);
    }

    @Bean
    public StoreDAO storeDAO(DataSource dataSource) {
        return new StoreDAO(dataSource);
    }

    @Bean
    public UserDAO userDAO(DataSource dataSource) {
        return new UserDAO(dataSource);
    }

    @Bean
    public VehicleDAO vehicleDAO(DataSource dataSource) {
        return new VehicleDAO(dataSource);
    }

    @Bean
    public FinanceDAO financeDAO(DataSource dataSource) {
        return  new FinanceDAO(dataSource);
    }
}
