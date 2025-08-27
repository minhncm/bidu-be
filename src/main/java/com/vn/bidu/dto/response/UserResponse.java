package com.vn.bidu.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vn.bidu.enums.Gender;
import com.vn.bidu.enums.Role;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse implements Serializable {
    private String fullName;

    private String thumbnail;

//    private String gender;

    private String email;

    private String password;

    private String phone;

}
