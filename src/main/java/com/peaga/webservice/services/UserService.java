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

    public User insert(User obj){
       return userRepository.save(obj);
    }
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
    public User update(Integer id,User obj){
        User aux = userRepository.getReferenceById(id);
        if(obj.getName()!=null)
            aux.setName(obj.getName());
        if(obj.getEmail()!=null)
            aux.setEmail(obj.getEmail());
        if(obj.getPhone()!=null)
            aux.setPhone(obj.getPhone());
        return userRepository.save(aux);
    }
}
