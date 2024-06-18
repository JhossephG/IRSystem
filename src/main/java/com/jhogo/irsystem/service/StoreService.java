package com.jhogo.irsystem.service;

import com.jhogo.irsystem.dto.StoreDTO;
import com.jhogo.irsystem.repository.FinanceDAO;
import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.model.Store;
import com.jhogo.irsystem.repository.StoreDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StoreService {
   private final StoreDAO storeDAO;
   private StoreDTO storeDTO;
   private StoreService storeService;
    private FinanceDAO financeDAO;
   private FinanceService financeService;
   private VehicleService vehicleService;

   public StoreService (StoreDAO storeDAO) {
       this.storeDAO = storeDAO;
   }

   public void addStore (StoreDTO storeDTO) throws SQLException {
       Store store = new Store();
       store.setName(storeDTO.getName());
       store.setAddress(storeDTO.getAddress());
       store.setRegisterNumber(storeDTO.getRegisterNumber());
       store.setBalance(storeDTO.getBalance());
       storeDAO.insertStore(store);
   }

    public List<Integer> getStoresId() throws SQLException {
       List <Integer> ids = new ArrayList<>();
       ids= storeDAO.getStoresId();
       return ids;
   }

   public int getIdByStoreName (String storeName) throws SQLException {
       return storeDAO.getIdByStoreName(storeName);
   }

   public StoreDTO getStoreById (int storeId) throws SQLException {
       Store store = storeDAO.getStoreById(storeId);
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

   public void deleteStore (int storeId) throws  SQLException {
       storeDAO.deleteStore(storeId);
   }

   public List<StoreDTO> getAllStores () throws  SQLException {
       List<Store> stores = storeDAO.getAllStores();
       return stores.stream().map(store -> {
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
       }).collect(Collectors.toList());
   }

   public void sellVehicle() {
       Scanner scan = new Scanner(System.in);
       try {
           List<VehicleDTO> vehiclesList = vehicleService.getAllCars();

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
           vehicleService.updateCar(vehicleDTO, vehicleDTO.getId());
           List<Integer> ids = new ArrayList<>();
           ids = storeService.getStoresId();
           int storeId = ids.get(0);
           financeDAO.addToBalance(vehicleDTO.getSaleValue(), storeId);
           System.out.println("Vehicle sold successfully.");
       } catch (InputMismatchException e) {
           System.out.println("Invalid input. Please enter a valid index.");
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Error occurred while selling the vehicle.");
       } finally {
           scan.close();  // Ensure the scanner is closed to avoid resource leaks
       }
   }
}
