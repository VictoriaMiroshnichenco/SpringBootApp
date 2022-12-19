package com.miroshnicheko.springbootapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "other")
public class OtherAppProperties {
    private String myappproperties;
    public String getMyappproperties() {
        return myappproperties;
    }

    public void setMyappproperties(String myappproperties) {
        this.myappproperties = myappproperties;
    }

}

