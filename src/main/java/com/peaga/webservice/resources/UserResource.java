package com.peaga.webservice.resources;

import com.peaga.webservice.entities.User;
import com.peaga.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
    @GetMapping(value = "/del/{id}")
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);
    }
}
