package com.vn.bidu.controller;

import com.vn.bidu.dto.response.PaymentMethodResponse;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.SizeColorResponse;
import com.vn.bidu.service.SizeColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sizecolor")
public class SizeColorController {

    private final SizeColorService sizeColorService;

    @GetMapping()
    public ResponseData<List<SizeColorResponse>> getAllSizeColor(){
        return new ResponseData<List<SizeColorResponse>>(HttpStatus.OK.value(),"Size color retrieved successfully", sizeColorService.getAllSizeColor());
    }

    @GetMapping("/{id}")
    public ResponseData<SizeColorResponse> getSizeColorById(@PathVariable int id){
        return new ResponseData<SizeColorResponse>(HttpStatus.OK.value(),"ok", sizeColorService.getSizeColorById(id));
    }
}
