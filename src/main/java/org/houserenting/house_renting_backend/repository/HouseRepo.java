package org.houserenting.house_renting_backend.repository;

import org.houserenting.house_renting_backend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, String> {

    List<House> findByLandlord_UserId(String userId);

    List<House> findByLocationContainingIgnoreCase(String location);
}
