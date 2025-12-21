package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDetailResponse (
        Long id,
        @JsonProperty("total_price") BigDecimal totalPrice,
        @JsonProperty("payment_method") String paymentMethod,
        @JsonProperty("created_at") LocalDateTime createdAt,
        @JsonProperty("client_summary") ClientSummaryResponse clientSummary,
        List<OrderItemDetailResponse> items
){}
