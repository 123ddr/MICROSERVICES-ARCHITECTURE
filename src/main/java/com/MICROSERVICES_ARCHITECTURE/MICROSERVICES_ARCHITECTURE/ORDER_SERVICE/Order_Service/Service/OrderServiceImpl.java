package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO.OrderItemResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO.OrderRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.DTO.OrderResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Entity.OrderEntity;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Entity.OrderItemEntity;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Repository.OrderItemRepo;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.ORDER_SERVICE.Order_Service.Repository.OrderRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        OrderEntity order = new OrderEntity();
        order.setUserId(request.getUserId());
        order.setStatus("CREATED");

        double total = request.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
        order.setTotal(total);

        orderRepo.save(order);

        List<OrderItemEntity> items = request.getItems().stream().map(i -> {
            OrderItemEntity item = new OrderItemEntity();
            item.setOrderId(order.getId());
            item.setProductId(i.getProductId());
            item.setQuantity(i.getQuantity());
            item.setPrice(i.getPrice());
            orderItemRepo.save(item);
            return item;
        }).toList();

        return toResponse(order, items);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        OrderEntity order = orderRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ORDER NOT FOUND"));
        List<OrderItemEntity> items = orderItemRepo.findByOrderId(order.getId());
        return toResponse(order, items);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepo.findAll().stream().map(order -> {
            List<OrderItemEntity> items = orderItemRepo.findByOrderId(order.getId());
            return toResponse(order, items);
        }).toList();
    }

    @Override
    public List<OrderResponse> getOrdersByUser(Long userId) {
        return orderRepo.findByUserId(userId).stream().map(order -> {
            List<OrderItemEntity> items = orderItemRepo.findByOrderId(order.getId());
            return toResponse(order, items);
        }).toList();
    }

    private OrderResponse toResponse(OrderEntity order, List<OrderItemEntity> items) {
        OrderResponse resp = new OrderResponse();
        resp.setId(order.getId());
        resp.setUserId(order.getUserId());
        resp.setTotal(order.getTotal());
        resp.setStatus(order.getStatus());
        resp.setItems(items.stream().map(this::toItemResponse).toList());
        return resp;
    }

    private OrderItemResponse toItemResponse(OrderItemEntity entity) {
        OrderItemResponse resp = new OrderItemResponse();
        resp.setId(entity.getId());
        resp.setProductId(entity.getProductId());
        resp.setQuantity(entity.getQuantity());
        resp.setPrice(entity.getPrice());
        return resp;
    }
}
