package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrderDetailResponse{
    Long id;
    BigDecimal totalPrice;
    String paymentMethod;
    LocalDateTime createdAt;
    ClientSummaryResponse clientSummary;
    List<OrderItemDetailResponse> items;
}
