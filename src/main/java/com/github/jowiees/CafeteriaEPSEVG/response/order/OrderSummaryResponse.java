package com.github.jowiees.CafeteriaEPSEVG.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryResponse(
        Long id,
        @JsonProperty("client_name") String clientName,
        @JsonProperty("total_price") BigDecimal totalPrice,
        @JsonProperty("created_at")  LocalDateTime createdAt
) {}
