package com.peaga.webservice.services;

import com.peaga.webservice.entities.Order;
import com.peaga.webservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order findById(int id){
        Optional<Order> order=orderRepository.findById(id);
        return order.get();
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

}
