package com.vn.bidu.controller;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping()
    public ResponseData<List<CategoryResponse>> getAllCategory(){

        return new ResponseData<>(HttpStatus.OK.value(),"Category retrieved successfully",  categoryService.getAllCategory() );
    }


    @GetMapping("/{id}")
    public ResponseData<CategoryResponse> getCategoryById(@PathVariable int id) {
        return new ResponseData<>(HttpStatus.OK.value(),"Category retrieved successfully", categoryService.getById(id) );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseData<>(HttpStatus.OK.value(),"Delete success",  true );
    }

}
