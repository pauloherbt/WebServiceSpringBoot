package com.peaga.webservice.resources;

import com.peaga.webservice.entities.OrderItem;
import com.peaga.webservice.entities.User;
import com.peaga.webservice.services.OrderItemService;
import com.peaga.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderitens")
public class OrderItemResource {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll(){
        return ResponseEntity.ok().body(orderItemService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(@PathVariable int id){
        return ResponseEntity.ok().body(orderItemService.findById(id));
    }
    @GetMapping(value = "/del/{id}")
    public void deleteById(@PathVariable int id){
        orderItemService.deleteById(id);
    }
}
