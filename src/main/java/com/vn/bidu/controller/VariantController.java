package com.vn.bidu.controller;


import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.VariantResponse;
import com.vn.bidu.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/variants")
public class VariantController {

    private final VariantService variantService;

    @GetMapping()
    public ResponseData<List<VariantResponse>> getAllVariant(){
        return new ResponseData<>(HttpStatus.OK.value(),"Size color retrieved successfully", variantService.getAllVariant());
    }

    @GetMapping("/{id}")
    public ResponseData<VariantResponse> getVariantById(@PathVariable int id){
        return new ResponseData<>(HttpStatus.OK.value(),"ok", variantService.getVariantById(id));
    }
}
