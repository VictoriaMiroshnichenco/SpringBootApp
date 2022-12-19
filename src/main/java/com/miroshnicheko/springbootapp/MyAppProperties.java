package com.miroshnicheko.springbootapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="myapp")
public class MyAppProperties {
    private String myappproperties;
    public String getMyappproperties() {
        return myappproperties;
    }

    public void setMyappproperties(String myappproperties) {
        this.myappproperties = myappproperties;
    }


}
