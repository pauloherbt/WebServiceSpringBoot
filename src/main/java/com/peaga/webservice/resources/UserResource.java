package com.peaga.webservice.resources;

import com.peaga.webservice.entities.User;
import com.peaga.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/ins")
    public ResponseEntity<User> insert(User obj){
        obj=userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").build(obj.getId()); //location onde foi inserido
        return ResponseEntity.created(uri).body(obj);
    }
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User obj){
        obj=userService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }


}
