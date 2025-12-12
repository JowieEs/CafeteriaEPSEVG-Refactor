package com.github.jowiees.CafeteriaEPSEVG.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.response.QuantityItemResponse;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDetailResponse (
        Long id,
        @JsonProperty("date_time") LocalDateTime dateTime,
        @JsonProperty("total_price") Double totalPrice,
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("client_id") Integer clientId,
        @JsonProperty("quantity_items") List<QuantityItemResponse> quantityItems
){
}
