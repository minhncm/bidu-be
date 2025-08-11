package com.vn.bidu.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("completed")
    COMPLETE,
    @JsonProperty("processing")
    PROCESSING,
    @JsonProperty("cancelled")
    CANCELLED,

}
