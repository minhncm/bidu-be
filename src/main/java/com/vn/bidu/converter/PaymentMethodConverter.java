package com.vn.bidu.converter;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.entity.PaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodConverter {
    @Autowired
    private ModelMapper mapper;

    public PaymentMethodResponse toPaymentMethodResponse(PaymentMethod paymentMethod) {
        return mapper.map(paymentMethod, PaymentMethodResponse.class);
    }
}
