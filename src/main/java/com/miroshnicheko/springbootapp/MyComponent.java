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


    @Value("${prop1}")
    String prop1;
    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enable = args.containsOption("enable");
        List<String> myArgs = args.getNonOptionArgs();
        System.out.println("## > Are you  enabled" + enable);
        System.out.println("## > Are you  enabled" + myArgs);
        if(!myArgs.isEmpty())
            myArgs.forEach(a -> System.out.println(a));
    }


}
