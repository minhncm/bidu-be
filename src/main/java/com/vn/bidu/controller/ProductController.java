package com.vn.bidu.controller;

import com.cloudinary.Cloudinary;
import com.vn.bidu.constant.CloudPath;
import com.vn.bidu.dto.request.ProductRequest;
import com.vn.bidu.dto.request.VariantRequest;
import com.vn.bidu.dto.response.ProductResponse;
import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.entity.Product;
import com.vn.bidu.service.CloudinaryService;
import com.vn.bidu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private final CloudinaryService cloudinaryService;


    @GetMapping
    public ResponseData<List<ProductResponse>> getAllProduct(){
        return new ResponseData<>(HttpStatus.OK.value(),"Product retrieved successfully",productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseData<ProductResponse> getProductById(@PathVariable int id) {
        return new ResponseData<>(HttpStatus.OK.value(),"Product retrieved successfully", productService.getProductById(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseData<Boolean> createProduct(@RequestPart("productRequest") ProductRequest productRequest, @RequestPart("images") List<MultipartFile> images) {

        List<String> urls = new ArrayList<>();
        for (MultipartFile file : images) {
            Map cloud = cloudinaryService.uploadFile(file, CloudPath.PRODUCT);
            urls.add((String) cloud.get("url"));
        }

        String thumbnail = String.join(", ", urls);

        productRequest.setThumbnail(thumbnail);


        return new ResponseData<>(HttpStatus.OK.value(),"Product add successfully",
                productService.createProduct(productRequest));
    }


   @PutMapping("/update/{id}")
   public ResponseData<Boolean> updateProduct(@PathVariable int id, @RequestParam String nameProduct,
                                              @RequestParam List<MultipartFile> images,
                                              @RequestParam int price,
                                              @RequestParam int percent,
                                              @RequestParam int soldQuantity,
                                              @RequestParam String descriptionProduct,
                                              @RequestParam String material,
                                              @RequestParam String origin,
                                              @RequestParam String style,
                                              @RequestParam String vignette,
                                              @RequestParam String collar,
                                              @RequestParam String season,
                                              @RequestParam String bodyShape,
                                              @RequestParam String gender,
                                              @RequestParam String brand){

       List<String> urls = new ArrayList<>();
       for (MultipartFile file : images) {
           Map cloud = cloudinaryService.uploadFile(file, CloudPath.PRODUCT);
           urls.add((String) cloud.get("url"));
       }

       String thumbnail = String.join(", ", urls);

       ProductRequest productRequest = ProductRequest.builder()
               .nameProduct(nameProduct)
               .thumbnail(thumbnail)
               .price(price)
               .percent(percent)
               .soldQuantity(soldQuantity)
               .descriptionProduct(descriptionProduct)
               .material(material)
               .origin(origin)
               .style(style)
               .vignette(vignette)
               .collar(collar)
               .season(season)
               .bodyShape(bodyShape)
               .gender(gender)
               .brand(brand)
               .build();

       return new ResponseData<>(HttpStatus.OK.value(),"Product retrieved successfully",
               productService.updateProduct(id, productRequest));
   }



    @DeleteMapping("/delete/{id}")
    public ResponseData<Boolean> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseData<>(HttpStatus.OK.value(),"Delete success",  true );
    }
}
