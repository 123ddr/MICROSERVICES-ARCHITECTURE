package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Repository;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findByOrderId(Long orderId);
}
