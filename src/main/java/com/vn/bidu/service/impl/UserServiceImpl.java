package com.vn.bidu.service.impl;

import com.vn.bidu.converter.UserConverter;
import com.vn.bidu.dto.response.UserResponse;
import com.vn.bidu.entity.User;
import com.vn.bidu.repository.UserRepository;
import com.vn.bidu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final UserConverter userConverter;

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users) {
            UserResponse userResponse =userConverter.toUserResponse(user);
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    @Override
    public UserResponse getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Size Color not found"));
        return userConverter.toUserResponse(user);

    }

    @Override
    public List<UserResponse>  getUserByName(String name) {
        List<User> users = userRepository.findTop3ByFullNameContaining(name);
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users){

            UserResponse userResponse = userConverter.toUserResponse(user);

            userResponses.add(userResponse);
        }
        return userResponses;
    }

}
