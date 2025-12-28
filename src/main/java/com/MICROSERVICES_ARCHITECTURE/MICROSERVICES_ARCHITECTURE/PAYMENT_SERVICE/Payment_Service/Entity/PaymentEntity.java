package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Double amount;
    private String status;
}

