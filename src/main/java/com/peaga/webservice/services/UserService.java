package com.peaga.webservice.services;

import com.peaga.webservice.entities.User;
import com.peaga.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
