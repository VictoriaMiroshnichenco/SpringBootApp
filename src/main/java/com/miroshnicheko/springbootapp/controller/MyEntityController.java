package com.miroshnicheko.springbootapp.controller;

import com.miroshnicheko.data.Entity;
import com.miroshnicheko.springbootapp.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController("/myapi")
public class MyEntityController {

    @Autowired
    private EntityRepository repository;

    @GetMapping("/getAllEntities")
    public ResponseEntity<Iterable<Entity>> getAllEntities(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/get")
    public ResponseEntity<Entity> getEntity(@RequestParam String id){
        return ResponseEntity.ok(repository.findById(id));
    }
    @RequestMapping(value="/create", method = {RequestMethod.POST,
            RequestMethod.PUT})

    public ResponseEntity<Entity> createEntity(@RequestBody Entity entity){
        Entity e = repository.save(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(e.getId()).toUri();
        return ResponseEntity.created(location).build();

    }


}
