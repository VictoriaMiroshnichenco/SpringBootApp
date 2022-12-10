package com.miroshnicheko.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication app =
                new SpringApplication(SpringBootSimpleApplication.class);
        // put additional settings here
        app.run(args);
    }

}
