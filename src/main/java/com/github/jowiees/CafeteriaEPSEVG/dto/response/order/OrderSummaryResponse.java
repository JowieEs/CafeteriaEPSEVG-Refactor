package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryResponse(
        Long id,
        @JsonProperty("total_price") BigDecimal totalPrice,
        @JsonProperty("created_at")  LocalDateTime createdAt,
        ClientSummaryResponse client
) {}
