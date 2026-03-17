package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.DTO;


import lombok.Data;

@Data
public class PaymentResponse {
    private Long id;
    private Long orderId;
    private Double amount;
    private String status;
}
