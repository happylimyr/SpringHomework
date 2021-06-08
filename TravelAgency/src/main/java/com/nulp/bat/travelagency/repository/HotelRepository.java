package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Hotel;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String name);

    List<Hotel> findAll();
}
