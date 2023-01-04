package com.miroshnicheko.data;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Builder
public class Entity {
    @NotNull
    private String id ;
    @NotNull
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

//    public Entity(){
//        this.id = UUID.randomUUID().toString();
//        this.description =id + "Constructor  test";
//        this.createdDate = LocalDateTime.now();
//    }
//    public Entity(String description){
//        this();
//        this.description=description;
//    }
}
