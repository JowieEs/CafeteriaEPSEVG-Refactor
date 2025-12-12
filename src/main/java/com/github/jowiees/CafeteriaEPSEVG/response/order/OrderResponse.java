package com.github.jowiees.CafeteriaEPSEVG.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record OrderResponse (
        Long id,
        @JsonProperty("date_time") LocalDateTime dateTime,
        @JsonProperty("total_price") Double totalPrice,
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("client_id") Integer clientId
){}
