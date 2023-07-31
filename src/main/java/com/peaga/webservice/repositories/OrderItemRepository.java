package com.peaga.webservice.repositories;

import com.peaga.webservice.entities.OrderItem;
import com.peaga.webservice.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
