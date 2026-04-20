package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.Service;



import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserCreateRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserUpdateRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.Entity.UserEntity;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.Repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepo.save(user);

        return toResponse(user);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, UserUpdateRequest request) {

        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("USER NOT FOUND"));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }

        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        userRepo.save(user);

        return toResponse(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("USER NOT FOUND"));
        return toResponse(user);
    }

    @Override
    public UserResponse getSelf(Long userId) {
        return getUserById(userId);
    }

    /* ===================== MAPPER ===================== */
    private UserResponse toResponse(UserEntity user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}
