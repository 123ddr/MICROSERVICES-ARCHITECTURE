package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO;


import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String email;
    private String password;
    private String role; // ADMIN / CUSTOMER
}
