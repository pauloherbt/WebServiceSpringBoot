package com.peaga.webservice.services;

import com.peaga.webservice.entities.User;
import com.peaga.webservice.repositories.UserRepository;
import com.peaga.webservice.services.exceptions.DbException;
import com.peaga.webservice.services.exceptions.ResourceNotfoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return user.orElseThrow(()-> new ResourceNotfoundException(id));
    }
    public void deleteById(Integer id){
        try{
            userRepository.delete(findById(id));
        }
        catch (ResourceNotfoundException e){
            throw new ResourceNotfoundException(id);
        }catch (DataIntegrityViolationException er){
            throw new DbException(er.getMessage());
        }
    }
    public User update(Integer id,User obj){
        User aux=null;
        try{
            aux = userRepository.getReferenceById(id);
            if(obj.getName()!=null) //impede de atualizar com valor null
                aux.setName(obj.getName());
            if(obj.getEmail()!=null)
                aux.setEmail(obj.getEmail());
            if(obj.getPhone()!=null)
                aux.setPhone(obj.getPhone());
        }catch (EntityNotFoundException e){
            throw new ResourceNotfoundException(id);
        }
        return userRepository.save(aux);
    }
}
