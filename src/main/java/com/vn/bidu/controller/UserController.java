package com.vn.bidu.controller;

import com.vn.bidu.dto.response.ResponseData;
import com.vn.bidu.dto.response.ShopResponse;
import com.vn.bidu.dto.response.UserResponse;
import com.vn.bidu.repository.UserRepository;
import com.vn.bidu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @GetMapping("")
    public ResponseData<List<UserResponse>> getAllUser() {
        return new ResponseData<>(HttpStatus.OK.value(),"Userr retrieved successfully", userService.getAllUser() );
    }

    @GetMapping("/{id}")
    public ResponseData<UserResponse> getUserById(@PathVariable int id) {
        return new ResponseData<>(HttpStatus.OK.value(),"Userr retrieved successfully", userService.getUserById(id) );
    }


    @GetMapping("/search")
        public ResponseData<List<UserResponse> > getUserById(@RequestParam String name) {
        return new ResponseData<>(HttpStatus.OK.value(),"Userr retrieved successfully", userService.getUserByName(name) );
    }
}
