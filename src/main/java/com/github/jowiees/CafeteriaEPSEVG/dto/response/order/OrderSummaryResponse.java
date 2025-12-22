package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.client.ClientSummaryResponse;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class OrderSummaryResponse{
    Long id;
    BigDecimal totalPrice;
    LocalDateTime createdAt;
    ClientSummaryResponse client;
}
