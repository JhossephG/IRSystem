package com.jhogo.irsystem.store;

import java.sql.SQLException;

public class StoreService {
   private StoreDAO storeDAO;

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
}
