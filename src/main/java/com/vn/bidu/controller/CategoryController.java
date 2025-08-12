package com.vn.bidu.controller;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping()
    public ResponseData<List<CategoryResponse>> getAllCategory(){

        return new ResponseData<List<CategoryResponse>>(HttpStatus.OK.value(),"Add success",  categoryService.getAllCategory() );
    }


    @GetMapping("/{id}")
    public ResponseData<CategoryResponse> getCategoryById(@PathVariable int id) {
        return new ResponseData<CategoryResponse>(HttpStatus.OK.value(),"ok",  categoryService.getById(id) );

    }

}
