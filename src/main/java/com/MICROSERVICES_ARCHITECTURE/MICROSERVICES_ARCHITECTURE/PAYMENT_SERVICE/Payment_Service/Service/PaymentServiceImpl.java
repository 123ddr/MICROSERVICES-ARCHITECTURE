package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.DTO.PaymentCreateRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.DTO.PaymentResponse;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Entity.PaymentEntity;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Repository.PaymentRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepo paymentRepo;

    @Autowired
    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    @Transactional
    public PaymentResponse createPayment(PaymentCreateRequest request) {
        PaymentEntity payment = new PaymentEntity();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setStatus("PENDING");

        paymentRepo.save(payment);
        return toResponse(payment);
    }

    @Override
    public List<PaymentResponse> getPaymentsByOrder(Long orderId) {
        return paymentRepo.findByOrderId(orderId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public PaymentResponse getPaymentById(Long paymentId) {
        PaymentEntity payment = paymentRepo.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("PAYMENT NOT FOUND"));
        return toResponse(payment);
    }

    private PaymentResponse toResponse(PaymentEntity entity) {
        PaymentResponse dto = new PaymentResponse();
        dto.setId(entity.getId());
        dto.setOrderId(entity.getOrderId());
        dto.setAmount(entity.getAmount());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
