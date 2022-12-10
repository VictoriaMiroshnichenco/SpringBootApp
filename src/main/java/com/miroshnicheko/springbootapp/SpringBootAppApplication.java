package com.miroshnicheko.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication
                (SpringBootSimpleApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment,
                                    Class<?> sourceClass, PrintStream out) {
                out.print("\n\n\tThis is my own banner!\n\n".toUpperCase());
            }
        });
        app.run(args);
    }

}
