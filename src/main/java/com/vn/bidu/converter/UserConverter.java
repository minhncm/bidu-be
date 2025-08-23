package com.vn.bidu.converter;

import com.vn.bidu.dto.response.CategoryResponse;
import com.vn.bidu.dto.response.UserResponse;
import com.vn.bidu.entity.Category;
import com.vn.bidu.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper mapper;

    public UserResponse toUserResponse(User user) {
        return mapper.map(user, UserResponse.class);
    }
}
