package com.github.jowiees.CafeteriaEPSEVG.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record OrderResponse (
        Long id,
        @JsonProperty("client_id") Long clientId,
        @JsonProperty("total_price") java.math.BigDecimal totalPrice,
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("created_at") LocalDateTime cratedAt
){}
