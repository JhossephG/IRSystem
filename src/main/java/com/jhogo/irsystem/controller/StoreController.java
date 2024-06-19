package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.StoreDTO;
import com.jhogo.irsystem.exception.CustomSQLException;
import com.jhogo.irsystem.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreDTO> addStore (@RequestBody StoreDTO storeDTO) {
        storeService.addStore(storeDTO);
        return new ResponseEntity<>(storeDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StoreDTO> getAllStores () throws SQLException {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById (@PathVariable int storeId) {
        StoreDTO storeDTO =  storeService.getStoreById(storeId);
        return new ResponseEntity<>(storeDTO, HttpStatus.OK);
    }
//    @PutMapping("/{id}")
//    public void updateStore(@PathVariable int id, @RequestBody StoreDTO storeDTO) throws SQLException {
//        store.setId(id);
//        storeService.updateStore(store);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore (@PathVariable int id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
