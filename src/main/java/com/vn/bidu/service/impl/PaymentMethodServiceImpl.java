package com.vn.bidu.service.impl;

import com.vn.bidu.converter.PaymentMethodConverter;
import com.vn.bidu.dto.request.PaymentMethodRequest;
import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.entity.PaymentMethod;
import com.vn.bidu.repository.PaymentMethodRepository;
import com.vn.bidu.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodConverter paymentMethodConverter;
    @Override
    public List<PaymentMethodResponse> getAllPaymentMethod() {

        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        List<PaymentMethodResponse> paymentMethodResponseList = new ArrayList<>();

        for(PaymentMethod paymentMethod : paymentMethods){
            PaymentMethodResponse paymentMethodResponse = paymentMethodConverter.toPaymentMethodResponse(paymentMethod);
            paymentMethodResponseList.add(paymentMethodResponse);
        }
        return paymentMethodResponseList;
    }

    @Override
    public PaymentMethodResponse getPaymentById(int id) {

        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new RuntimeException("Paymentmethod not found"));
        return paymentMethodConverter.toPaymentMethodResponse(paymentMethod);
    }

    @Override
    public boolean createPaymentMethod(PaymentMethodRequest paymentMethodRequest) {

        try {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setNamePayment(paymentMethodRequest.getNamePayment());

            paymentMethodRepository.save(paymentMethod);

            return true;
        } catch (Exception e) {
             throw new RuntimeException("Not create");
        }

    }

    @Override
    public void deletePaymentMethod(int id) {
        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
        if(paymentMethod.isPresent()){
            paymentMethodRepository.deleteById(id);
        }else{
            throw new RuntimeException("PaymentMethod not found");
        }
    }
}
