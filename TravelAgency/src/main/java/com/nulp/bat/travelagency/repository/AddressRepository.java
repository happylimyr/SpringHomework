package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long > {

    Optional<Address> findByName(String name);
}
