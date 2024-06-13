package com.jhogo.irsystem.store;

import com.jhogo.irsystem.finance.FinanceDAO;
import com.jhogo.irsystem.finance.FinanceService;
import com.jhogo.irsystem.vehicle.VehicleDTO;
import com.jhogo.irsystem.vehicle.VehicleService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StoreService {
   private final StoreDAO storeDAO;
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
            ids = storeService.getStoreId();
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

    public List<Integer> getStoreId () throws SQLException {
       List <Integer> ids = new ArrayList<>();
       ids= storeDAO.getStoreId();
       return ids;
   }
}
