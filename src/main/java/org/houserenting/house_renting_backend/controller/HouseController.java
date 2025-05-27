package org.houserenting.house_renting_backend.controller;

import org.houserenting.house_renting_backend.dto.HouseDTO;
import org.houserenting.house_renting_backend.model.House;
import org.houserenting.house_renting_backend.model.User;
import org.houserenting.house_renting_backend.service.HouseService;
import org.houserenting.house_renting_backend.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses") // Changed from /houses to /api/houses
@CrossOrigin(origins = "*")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody HouseDTO houseDTO) {
        try {
            User landlord = userServices.getUserById(houseDTO.getLandlordId());
            if (landlord == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
            House house = houseDTO.convertToHouse(landlord);
            houseService.createHouse(house);
            return ResponseEntity.status(HttpStatus.CREATED).body(house);
        } catch (Exception e) {
            // Add logging for better debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<House> updateHouse(@RequestBody House house) {
        try {
            houseService.updateHouse(house);
            return ResponseEntity.status(HttpStatus.OK).body(house);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<House> getHouseById(@PathVariable String houseId) {
        try {
            House house = houseService.getHouseById(houseId);
            return ResponseEntity.status(HttpStatus.OK).body(house);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{houseId}")
    public ResponseEntity<Void> deleteHouse(@PathVariable String houseId) {
        try {
            houseService.deleteHouse(houseId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<House>> getAllHouses() {
        try {
            List<House> houses = houseService.getAllHouses();
            return ResponseEntity.status(HttpStatus.OK).body(houses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/landlord/{landlordId}")
    public ResponseEntity<List<House>> getHousesByLandlordId(@PathVariable String landlordId) {
        try {
            List<House> houses = houseService.getHousesByLandlordId(landlordId);
            return ResponseEntity.status(HttpStatus.OK).body(houses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
