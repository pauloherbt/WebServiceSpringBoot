package com.peaga.webservice.repositories;

import com.peaga.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
