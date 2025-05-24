package org.houserenting.house_renting_backend.service;

import org.houserenting.house_renting_backend.model.House;
import org.houserenting.house_renting_backend.repository.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepo houseRepo;

    public void createHouse(House house) {
        house.setCreatedAt(Date.valueOf(LocalDate.now()));
        house.setUpdatedAt(Date.valueOf(LocalDate.now()));
        houseRepo.save(house);
    }

    private Date updatedAt;

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public House getHouseById(String houseId) {
        return houseRepo.findById(houseId).orElse(null);
    }

    public void deleteHouse(String houseId) {
        houseRepo.deleteById(houseId);
    }

    public List<House> getAllHouses() {
        return houseRepo.findAll();
    }

    public List<House> getHousesByLandlordId(String landlordId) {
        return houseRepo.findByLandlord_UserId(landlordId);
    }

    public void updateHouse(House house) {
        house.setUpdatedAt(Date.valueOf(LocalDate.now()));
        houseRepo.save(house);
    }
}
