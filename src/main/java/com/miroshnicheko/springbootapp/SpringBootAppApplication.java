package com.miroshnicheko.springbootapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class SpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication app =
                new SpringApplication(SpringBootAppApplication.class);

        // put additional settings here
        Properties properties = new Properties();
        properties.put("prop1","value1__from__app.setDefaultProperties(properties);");

        app.setDefaultProperties(properties);
        ConfigurableApplicationContext context = app.run(args);
        MyComponent component = (MyComponent) context.getBean("myComponent");
        System.out.println("## > App Started!");
        System.out.println("====== from main get bean get field ======> component.prop1 =" + component.prop1);

    }

}
