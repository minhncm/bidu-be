package com.vn.bidu.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("admin")
    ADMIN,
    @JsonProperty("user")
    USER,
    @JsonProperty("seller")
    SELLER,
}
