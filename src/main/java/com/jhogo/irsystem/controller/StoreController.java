package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.StoreDTO;
import com.jhogo.irsystem.model.Store;
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

    @GetMapping
    public List<StoreDTO> getAllStores () throws SQLException {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById (int storeId) throws SQLException {
        StoreDTO storeDTO =  storeService.getStoreById(storeId);
        return new ResponseEntity<>(storeDTO, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<StoreDTO> addStore (@RequestBody StoreDTO storeDTO) throws SQLException {
        storeService.addStore(storeDTO);
        return ResponseEntity.ok(storeDTO);
    }
}
