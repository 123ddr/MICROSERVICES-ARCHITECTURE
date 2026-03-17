package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO;


import lombok.Data;

@Data
public class UserUpdateRequest {
    private String username;
    private String password;
}
