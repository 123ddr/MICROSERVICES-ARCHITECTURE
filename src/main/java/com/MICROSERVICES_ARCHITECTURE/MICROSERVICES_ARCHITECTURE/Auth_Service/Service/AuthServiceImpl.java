package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.AuthResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.LoginRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.DTO.SignupRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Entity.UserEntity;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Repository.UserRepo;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public AuthResponse signup(SignupRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("CUSTOMER"); // default role

        userRepo.save(user);

        String token = jwtUtils.generateToken(user.getEmail(), user.getRole());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());

        return response;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        UserEntity user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getEmail(), user.getRole());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());

        return response;
    }
}
