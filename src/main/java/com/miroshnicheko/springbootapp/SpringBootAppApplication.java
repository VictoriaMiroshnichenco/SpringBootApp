package com.miroshnicheko.springbootapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
               // .bannerMode(Banner.Mode.OFF)
                .sources(SpringBootAppApplication.class)
                .run(args);
        System.out.println("## > App Started!");
    }

}
