package com.jhogo.irsystem.vehicle;
import com.jhogo.irsystem.model.Store;
import com.jhogo.irsystem.model.Vehicle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class VehicleServiceTest {
    @Test
    public void testSellVehicle() {
        Store store = new Store();
        Vehicle car = new Vehicle();
        car.setSaleValue(new BigDecimal("50000"));


    }
}
