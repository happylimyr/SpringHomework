package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Role;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);

    List<Role> findAll();
}
