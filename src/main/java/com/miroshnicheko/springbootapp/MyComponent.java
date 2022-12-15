package com.miroshnicheko.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyComponent {
  //  private static final Logger log = LoggerFactory.getLogger
  //          (MyComponent.class);

    @Value("${server.name}")
    String serverName;
    @Autowired
    public MyComponent(ApplicationArguments args) {
        System.out.println("====from constructor MyComponent =====> serverName = " +serverName);
    }


}
