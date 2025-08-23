package com.vn.bidu.controller;

import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.SearchResponse;
import com.vn.bidu.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping()
    public ResponseData<SearchResponse> search(@RequestParam String name, @RequestParam String type) {
        return new ResponseData<>(HttpStatus.OK.value(),"Userr retrieved successfully", searchService.search(name, type) );
    }

}




