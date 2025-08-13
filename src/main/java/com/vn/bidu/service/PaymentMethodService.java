package com.vn.bidu.service;

import com.vn.bidu.dto.request.PaymentMethodRequest;
import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodResponse> getAllPaymentMethod();
    PaymentMethodResponse getPaymentById(int id);
    boolean createPaymentMethod(PaymentMethodRequest paymentMethodRequest);
    void deletePaymentMethod(int id);
}
