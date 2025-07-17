package com.codegym.fooddeliversystem.model.dto;

import com.codegym.fooddeliversystem.model.Role;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String passwordRepeat;
    private Long roleId;
    private String name;
    private String email;
    private String phone;
    private String address;
}
