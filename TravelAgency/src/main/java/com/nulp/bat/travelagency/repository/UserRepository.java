package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.model.Tour;
import com.nulp.bat.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByloginUser(String login);

    Optional<User> findById(Long id);

    List<User> findAll();
//
//    @Query("SELECT * FROM user u WHERE u.login_user = :login_user")
//    public User getUserByUsername(@Param("login_user") String login_user);

}
