package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TourRepository extends JpaRepository<Tour, Long> {
    Optional<Tour> findByName(String type);

    Optional<Tour> findById(Long id);

    List<Tour> findAll();

}
