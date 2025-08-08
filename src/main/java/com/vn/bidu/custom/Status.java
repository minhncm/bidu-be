package com.vn.bidu.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("completed")
    COMPLETE,
    @JsonProperty("processing")
    PROCESSING,
    @JsonProperty("cancelled")
    CANCELLED,

}
