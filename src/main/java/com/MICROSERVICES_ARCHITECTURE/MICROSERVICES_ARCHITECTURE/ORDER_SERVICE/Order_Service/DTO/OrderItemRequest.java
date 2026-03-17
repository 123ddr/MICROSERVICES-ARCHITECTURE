package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO;


import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private Integer quantity;
    private Double price;
}
