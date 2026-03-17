package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserCreateRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.USER_SERVICE.User_Service.DTO.UserUpdateRequest;

public interface IUserService {

    UserResponse createUser(UserCreateRequest request);        // ADMIN

    UserResponse updateUser(Long userId, UserUpdateRequest request); // ADMIN

    void deleteUser(Long userId);                               // ADMIN

    UserResponse getUserById(Long userId);                      // ADMIN

    UserResponse getSelf(Long userId);                          // CUSTOMER
}
