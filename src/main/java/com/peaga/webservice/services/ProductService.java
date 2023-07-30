package com.peaga.webservice.services;

import com.peaga.webservice.entities.Product;
import com.peaga.webservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(int id){
        Optional<Product> prod=productRepository.findById(id);
        return prod.get();
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
