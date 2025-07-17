package com.codegym.fooddeliversystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
