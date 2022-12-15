package com.miroshnicheko.springbootapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  new SpringApplicationBuilder()
               // .bannerMode(Banner.Mode.OFF)
                .sources(SpringBootAppApplication.class)
                .run(args);
       MyComponent component = (MyComponent) context.getBean("myComponent");
        System.out.println("## > App Started!");
        System.out.println("====== from main get bean get field ======> component.serverName =" + component.serverName);

    }

}
