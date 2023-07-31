package com.peaga.webservice.services;

import com.peaga.webservice.entities.OrderItem;
import com.peaga.webservice.entities.User;
import com.peaga.webservice.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll(){
        return orderItemRepository.findAll();
    }
    public OrderItem findById(int id){
        Optional<OrderItem> order = orderItemRepository.findById(id);
        return order.get();
    }
    public void deleteById(int id){
        orderItemRepository.deleteById(id);
    }
}
