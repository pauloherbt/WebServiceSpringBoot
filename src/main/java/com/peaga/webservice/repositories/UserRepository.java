package com.peaga.webservice.repositories;

import com.peaga.webservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> { //classe do rep e pk

}
