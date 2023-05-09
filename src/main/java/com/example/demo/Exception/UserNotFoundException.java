package com.example.demo.Exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message){
        super(message);
    }
}
