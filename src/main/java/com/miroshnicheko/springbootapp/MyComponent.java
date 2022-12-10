package com.miroshnicheko.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
  //  private static final Logger log = LoggerFactory.getLogger
  //          (MyComponent.class);
    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enable = args.containsOption("enable");
        if(enable) {
           // log.info("## > You are enabled!");
            System.out.println("## > You are enabled!");
        }else{
          //  log.info("## > You are not enabled!");
            System.out.println("## > You are NOT enabled!");
        }
    }
}
