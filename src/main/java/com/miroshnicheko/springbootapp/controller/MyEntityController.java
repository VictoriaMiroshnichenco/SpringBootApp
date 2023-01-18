package com.miroshnicheko.springbootapp.controller;

import com.miroshnicheko.data.Entity;
import com.miroshnicheko.springbootapp.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/myapi")
public class MyEntityController {

    @Autowired
    private EntityRepository repository;

    @GetMapping("/getAllEntities")
    public ResponseEntity<Iterable<Entity>> getAllEntities(){
        return ResponseEntity.ok(repository.findAll());
    }
}
