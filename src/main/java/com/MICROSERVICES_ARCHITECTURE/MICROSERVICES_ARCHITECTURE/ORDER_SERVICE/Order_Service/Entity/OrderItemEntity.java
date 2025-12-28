package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long productId;     // External reference

    private Integer quantity;
    private Double price;
}

