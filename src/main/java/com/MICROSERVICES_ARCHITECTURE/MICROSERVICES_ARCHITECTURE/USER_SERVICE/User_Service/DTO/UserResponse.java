package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO;


import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;
}
