package com.jhogo.irsystem.controller;

import com.jhogo.irsystem.dto.VehicleDTO;
import com.jhogo.irsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDTO> addVehicle (@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicles () throws SQLException {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> getVehicleById (@PathVariable int vehicleId) {
        return new ResponseEntity<>(vehicleService.getVehicleById(vehicleId), HttpStatus.OK);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> updateVehicle (@RequestBody VehicleDTO vehicleDTO, @PathVariable int vehicleId) {
        vehicleService.updateVehicle(vehicleDTO, vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle (@PathVariable int vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
