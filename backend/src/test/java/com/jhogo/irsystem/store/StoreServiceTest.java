//package com.jhogo.irsystem.store;
//
//import com.jhogo.irsystem.dto.StoreDTO;
//import com.jhogo.irsystem.dto.VehicleDTO;
//import com.jhogo.irsystem.model.Store;
//import com.jhogo.irsystem.repository.StoreDAO;
//import com.jhogo.irsystem.service.StoreService;
//import com.jhogo.irsystem.service.VehicleService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.math.BigDecimal;
//
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@ActiveProfiles("test")
//public class StoreServiceTest {
//
//    @Mock
//    private VehicleService vehicleService;
//
//    @InjectMocks
//    private StoreDAO storeDAO;
//
//    @Mock
//    private StoreDTO storeDTO;
//
//    @Mock
//    private Store store;
//
//    @InjectMocks
//    private StoreService storeService;
//
//    private VehicleDTO vehicle1;
//    private VehicleDTO vehicle2;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        MockitoAnnotations.openMocks(this);
//
//        storeDTO = new StoreDTO();
//        storeDTO.setName("Name");
//        storeDTO.setAddress("FooAddress");
//        storeDTO.setRegisterNumber("123ABC");
//        storeDTO.setBalance(new BigDecimal("0"));
//        storeService.addStore(storeDTO);
//
//        vehicle1 = new VehicleDTO("Model1", "Brand1", "VIN1", 2015, new BigDecimal("15000.00"), new BigDecimal("10000.00"), true);
//        vehicle2 = new VehicleDTO("Model2", "Brand2", "VIN2", 2016, new BigDecimal("20000.00"), new BigDecimal("15000.00"), true);
//
//        vehicleService.addVehicle(vehicle1);
//        vehicleService.addVehicle(vehicle2);
//
//        when(vehicleService.getAllVehicles()).thenReturn(Arrays.asList(vehicle1, vehicle2));
//
//    }
//
//    @Test
//    public void testSellVehicle() throws SQLException {
//        Scanner mockScanner = new Scanner("0\n");
//
//        storeService.sellVehicle(mockScanner);
//
//        verify(vehicleService).updateVehicle(vehicle1, vehicle1.getId());
//        verify(storeDAO).updateBalance(vehicle1.getSaleValue(), store.getId());
//    }
//
//    @Test
//    public void testSellVehicleInvalidIndex() throws SQLException {
//        Scanner mockScanner = new Scanner("5\n");
//
//        storeService.sellVehicle(mockScanner);
//
//        assertTrue(vehicle1.isAvailability());
//        assertTrue(vehicle2.isAvailability());
//        verify(vehicleService, never()).updateVehicle(any(), anyInt());
//        verify(storeDAO, never()).updateBalance(any(), anyInt());
//    }
//}
