package com.jhogo.irsystem.service;

import com.jhogo.irsystem.dto.StoreDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.repository.FinanceDAO;
import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.model.Store;
import com.jhogo.irsystem.repository.StoreDAO;
import com.jhogo.irsystem.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class StoreService implements Converter<Store, StoreDTO> {
    private final StoreDAO storeDAO;
    private StoreDTO storeDTO;
    private StoreService storeService;
    private FinanceDAO financeDAO;
    private FinanceService financeService;
    private VehicleService vehicleService;

    @Autowired
    public StoreService (StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public void addStore (StoreDTO storeDTO) {
        try {
            storeDAO.insertStore(convertToModel(storeDTO));
        } catch (SQLException e) {
            throw new CustomSQLException("Error adding store", e);
        }
    }

    public List<Integer> getStoresId() {
        try {
            return storeDAO.getStoresId();
        } catch (SQLException e) {
            throw new CustomSQLException("Error retrieving id's from Stores", e);
        }
    }

    public int getIdByStoreName (String storeName) {
        try {
            return storeDAO.getIdByStoreName(storeName);
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting id from store with name " + storeName, e);
        }
    }

    public StoreDTO getStoreById (int storeId) {
        try {
            Store store = storeDAO.getStoreById(storeId);
            return convertToDTO(store);
        } catch (SQLException e) {
            throw new CustomSQLException("Error retrieving Store by id", e);
        }
    }

    public void deleteStore (int storeId) {
        try {
            storeDAO.deleteStore(storeId);
        } catch (SQLException e) {
            throw new CustomSQLException("Error deleting Store", e);
        }
    }

    public List<StoreDTO> getAllStores () {
        try {
            List<Store> stores = storeDAO.getAllStores();
            return stores.stream().map(this::convertToDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new CustomSQLException("Error getting all stores", e);
        }
    }

    public void sellVehicle() {
        try (Scanner scan = new Scanner(System.in)) {
            List<VehicleDTO> vehiclesList = vehicleService.getAllVehicles();

            if (vehiclesList.isEmpty()) {
                System.out.println("No vehicles available for sale.");
                return;
            }
            // Display the list of vehicles with indices
            for (int i = 0; i < vehiclesList.size(); i++) {
                System.out.println(i + ": " + vehiclesList.get(i));
            }
            System.out.println("Select the index of the vehicle to sell:");
            int vehicleIndex = scan.nextInt();
            if (vehicleIndex < 0 || vehicleIndex >= vehiclesList.size()) {
                System.out.println("Invalid vehicle index selected.");
                return;
            }

            VehicleDTO vehicleDTO = vehiclesList.get(vehicleIndex);
            vehicleDTO.setAvailability(false);
            vehicleService.updateVehicle(vehicleDTO, vehicleDTO.getId());
            List<Integer> ids = new ArrayList<>();
            ids = storeService.getStoresId();
            int storeId = ids.get(0);
            financeDAO.addToBalance(vehicleDTO.getSaleValue(), storeId);
            System.out.println("Vehicle sold successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid index.");
        } catch (SQLException e) {
            throw new CustomSQLException("Error while selling the vehicle", e);
        }
    }

    @Override
    public Store convertToModel (StoreDTO storeDTO) {
        Store store = new Store();
        store.setName(storeDTO.getName());
        store.setAddress(storeDTO.getAddress());
        store.setRegisterNumber(storeDTO.getRegisterNumber());
        store.setBalance(storeDTO.getBalance());
        return store;
    }

    @Override
    public StoreDTO convertToDTO (Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setName(store.getName());
        storeDTO.setAddress(store.getAddress());
        storeDTO.setRegisterNumber(store.getRegisterNumber());
        storeDTO.setPhoneNumber(store.getPhoneNumber());
        storeDTO.setExpenses(store.getExpenses());
        storeDTO.setBalance(store.getBalance());
        storeDTO.setTotalOfEmployees(store.getTotalOfEmployees());
        storeDTO.setTotalOfCars(store.getTotalOfCars());
        return storeDTO;
    }
}