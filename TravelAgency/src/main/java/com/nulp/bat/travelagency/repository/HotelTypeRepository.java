package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.HotelType;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelTypeRepository extends JpaRepository<HotelType, Long> {
    Optional<HotelType> findByName(String name);

    List<HotelType> findAll();
}
