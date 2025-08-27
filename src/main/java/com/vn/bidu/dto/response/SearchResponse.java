package com.vn.bidu.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchResponse {

    private List<ShopResponse> shops;

    private List<UserResponse> users;

    private List<ProductResponse> productResponses;


}
