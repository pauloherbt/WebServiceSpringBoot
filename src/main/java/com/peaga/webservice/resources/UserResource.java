package com.peaga.webservice.resources;

import com.peaga.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1,"Paulo Herbert","paulo12herbert@gmail.com","889319891","senha");
        return ResponseEntity.ok().body(user);
    }
}
