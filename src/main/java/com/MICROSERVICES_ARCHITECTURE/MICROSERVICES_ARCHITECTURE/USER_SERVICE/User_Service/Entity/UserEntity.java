package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
}

