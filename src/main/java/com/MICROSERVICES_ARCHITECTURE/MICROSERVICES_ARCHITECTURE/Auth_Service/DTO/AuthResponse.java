package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO;


import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String username;
    private String role;
}
