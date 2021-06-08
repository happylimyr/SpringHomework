package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.City;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);

    List<City> findAll();
}

