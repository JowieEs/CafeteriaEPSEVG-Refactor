package com.github.jowiees.CafeteriaEPSEVG.response.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.response.product.ProductResponse;

import java.util.List;

public record MenuDetailResponse (
        Long id,
        double price,
        @JsonProperty("products") List<ProductResponse> productResponses
        ){
}
