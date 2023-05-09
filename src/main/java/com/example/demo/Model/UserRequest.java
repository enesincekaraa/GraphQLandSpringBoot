package com.example.demo.Model;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String userName;
    private String mail;
    private Role role;
}
