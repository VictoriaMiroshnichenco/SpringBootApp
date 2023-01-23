package com.miroshnicheko.springbootapp.controller;

import com.miroshnicheko.data.Entity;
import com.miroshnicheko.springbootapp.repository.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController("/myapi")
public class MyEntityController {
    Logger logger = LoggerFactory.getLogger(MyEntityController.class);
    @Autowired
    private EntityRepository repository;

    @GetMapping("/logtest")
    public String  logtest(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
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

    public ResponseEntity<?> createEntity(@Valid @RequestBody Entity entity, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(MyEntityValidationErrorBuilder.fromBindingErrors(errors));
        }
        Entity e = repository.save(entity);
        //todo rework path to created item
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(e.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Entity> deleteToDo(@PathVariable String id){
        repository.delete(Entity.builder().id(id).build());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MyEntityValidationError handleException(Exception exception) {
        return new MyEntityValidationError(exception.getMessage());
    }
}
