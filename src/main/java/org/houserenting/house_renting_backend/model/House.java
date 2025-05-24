package org.houserenting.house_renting_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class House {

    @Id
    private String houseId = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String location;

    @Column
    private String amenities;

    @Column
    private int beds;

    @Column
    private int baths;

    @Column
    private double size;

    @Column
    private double price;

    @Column
    private String image;

    @Column(length = 1000)
    private String about;

    @Column
    private String moveInDate;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private User landlord;
}
