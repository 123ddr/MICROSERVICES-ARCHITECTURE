package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Repository;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.Auth_Service.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
