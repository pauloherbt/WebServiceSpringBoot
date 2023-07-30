package com.peaga.webservice.resources;

import com.peaga.webservice.entities.Category;
import com.peaga.webservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable int id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}
