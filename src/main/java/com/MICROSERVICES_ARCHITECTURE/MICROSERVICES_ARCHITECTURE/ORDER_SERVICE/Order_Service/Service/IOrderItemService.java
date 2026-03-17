package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO.OrderItemRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO.OrderItemResponse;

import java.util.List;

public interface IOrderItemService {
    OrderItemResponse createOrderItem(Long orderId, OrderItemRequest request);
    List<OrderItemResponse> getOrderItemsByOrder(Long orderId);
}
