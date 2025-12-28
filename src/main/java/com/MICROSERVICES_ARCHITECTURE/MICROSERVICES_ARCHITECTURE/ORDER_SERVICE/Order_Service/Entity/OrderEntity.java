package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;        // External reference
    private Double total;
    private String status;
}

