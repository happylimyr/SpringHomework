package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nulp.bat.travelagency.model.PersonalData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    Optional<PersonalData> findByEmail(String email);

    boolean existsByEmail(String email);

    List<PersonalData> findAll();

}
