package org.houserenting.house_renting_backend.dto;

import lombok.*;
import org.houserenting.house_renting_backend.model.House;
import org.houserenting.house_renting_backend.model.User;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HouseDTO {
    private String houseId = UUID.randomUUID().toString();
    private String location;
    private String amenities;
    private int beds;
    private int baths;
    private double size;
    private double price;
    private String image;
    private String about;
    private String moveInDate;
    private String landlordId; // only the ID for DTO
    private Date createdAt;

    public House convertToHouse(User landlord) {
        House house = new House();
        house.setHouseId(this.houseId);
        house.setLocation(this.location);
        house.setAmenities(this.amenities);
        house.setBeds(this.beds);
        house.setBaths(this.baths);
        house.setSize(this.size);
        house.setPrice(this.price);
        house.setImage(this.image);
        house.setAbout(this.about);
        house.setMoveInDate(this.moveInDate);
        house.setCreatedAt(java.sql.Date.valueOf(java.time.LocalDate.now()));
        house.setLandlord(landlord);
        return house;
    }
}
