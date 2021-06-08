package com.nulp.bat.travelagency.repository;

import com.nulp.bat.travelagency.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderName(String orderName);

    Optional<Order> findById(Long idOrder);

    List<Order> findAll();


}
