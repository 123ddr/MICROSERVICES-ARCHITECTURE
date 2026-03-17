package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO;


import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private Double total;
    private String status;
    private List<OrderItemResponse> items;
}
