package com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.Service;


import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.DTO.PaymentCreateRequest;
import com.MICROSERVICES_ARCHITECTURE.MICROSERVICES_ARCHITECTURE.PAYMENT_SERVICE.Payment_Service.DTO.PaymentResponse;

import java.util.List;

public interface IPaymentService {

    PaymentResponse createPayment(PaymentCreateRequest request);      // CUSTOMER

    List<PaymentResponse> getPaymentsByOrder(Long orderId);           // CUSTOMER/ADMIN

    List<PaymentResponse> getAllPayments();                           // ADMIN

    PaymentResponse getPaymentById(Long paymentId);                   // ADMIN
}
