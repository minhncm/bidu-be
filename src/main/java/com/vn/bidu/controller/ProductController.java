package com.vn.bidu.controller;

import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseData<List<ProductResponse>> getAllProduct(){
        return new ResponseData<>(HttpStatus.OK.value(),"Product retrieved successfully",productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseData<ProductResponse> getProductById(@PathVariable int id) {
        return new ResponseData<>(HttpStatus.OK.value(),"Product retrieved successfully", productService.getProductById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseData<>(HttpStatus.OK.value(),"Delete success",  true );
    }
}
