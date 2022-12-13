package com.miroshnicheko.springbootapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication
                (SpringBootAppApplication.class);
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
