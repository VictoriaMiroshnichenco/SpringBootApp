package com.miroshnicheko.client;

import com.miroshnicheko.data.Entity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

//@SpringBootApplication  - todo -  uncomment after moving to separate project
public class TodoClientApplication {


    public static void main(String[] args) {
        SpringApplication app = new
                SpringApplication(TodoClientApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
    private Logger log = LoggerFactory.getLogger
            (TodoClientApplication.class);
    @Bean
    public CommandLineRunner process(ToDoRestClient client){
        return args -> {
            Iterable<Entity> toDos = client.findAll();
            assert toDos != null;
            toDos.forEach( toDo -> log.info(toDo.toString()));

            Entity e = Entity.builder().id("MyId").description("MyDescr").createdDate(LocalDateTime.now()).build();
            Entity newToDo = client.upsert(e);
            assert newToDo != null;
            log.info(newToDo.toString());
            Entity toDo = client.findById(newToDo.getId());
            assert toDos != null;
            log.info(toDo.toString());
            Entity completed = client.setCompleted(newToDo.getId());

            log.info(completed.toString());
            client.delete(newToDo.getId());
            assert client.findById(newToDo.getId()) == null;
        };
    }
}
