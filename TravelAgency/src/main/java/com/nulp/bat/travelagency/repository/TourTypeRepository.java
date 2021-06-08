package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.TourType;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourTypeRepository extends JpaRepository<TourType, Long> {

    Optional<TourType> findByName(String name);

    List<TourType> findAll();
}
