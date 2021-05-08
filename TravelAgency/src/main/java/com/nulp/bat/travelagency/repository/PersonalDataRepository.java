package com.nulp.bat.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.nulp.bat.travelagency.model.PersonalData;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    Optional<PersonalData> findByEmail(String email);

    boolean existsByEmail(String email);

}
