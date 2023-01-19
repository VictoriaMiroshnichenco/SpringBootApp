package com.miroshnicheko.springbootapp.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class MyEntityValidationErrorBuilder {
    public static MyEntityValidationError fromBindingErrors(Errors errors) {
        MyEntityValidationError error = new MyEntityValidationError("My validation message");
        for (ObjectError err : errors.getAllErrors()) {
            error.addValidationError(err.getDefaultMessage());
        }
        return error;
    }
}