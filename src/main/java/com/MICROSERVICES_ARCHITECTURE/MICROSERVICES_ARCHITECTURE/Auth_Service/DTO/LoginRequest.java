package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO;


import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
