package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.AuthResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.LoginRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.SignupRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse signup(SignupRequest request);
}
