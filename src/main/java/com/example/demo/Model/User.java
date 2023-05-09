package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "kullanici")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User extends BaseEntity{
    private String userName;
    private String mail;
    @Enumerated(EnumType.STRING)
    private Role role;

}
