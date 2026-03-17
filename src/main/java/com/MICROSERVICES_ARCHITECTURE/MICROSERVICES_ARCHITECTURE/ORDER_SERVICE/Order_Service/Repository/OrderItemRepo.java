package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Repository;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItemEntity, Long> {
    List<OrderItemEntity> findByOrderId(Long orderId);
}
