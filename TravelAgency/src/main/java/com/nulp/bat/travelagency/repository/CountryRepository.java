package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Country;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);

    List<Country> findAll();
}


