package com.vn.bidu.controller;

import com.vn.bidu.dto.request.PaymentMethodRequest;
import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.repository.PaymentMethodRepository;
import com.vn.bidu.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/method")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;
    @GetMapping()
    public ResponseData<List<PaymentMethodResponse>> getAllPaymentMethod(){
        return new ResponseData<List<PaymentMethodResponse>>(HttpStatus.OK.value(),"Payment method retrieved successfully", paymentMethodService.getAllPaymentMethod());
    }

    @GetMapping("/{id}")
    public ResponseData<PaymentMethodResponse> getPaymentById(@PathVariable int id){
        return new ResponseData<PaymentMethodResponse>(HttpStatus.OK.value(),"Payment method retrieved successfully", paymentMethodService.getPaymentById(id));
    }

    @PostMapping()
    public ResponseData<Boolean> createPaymentMethod(@RequestBody PaymentMethodRequest paymentMethodRequest){

        return new ResponseData<>(HttpStatus.OK.value(), "Payment method added successfully", paymentMethodService.createPaymentMethod(paymentMethodRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deletePaymentMethod(@PathVariable int id){
        paymentMethodService.deletePaymentMethod(id);
        return new ResponseData<>(HttpStatus.OK.value(), "Payment method deleted successfully", true);
    }


}
