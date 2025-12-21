package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;

import java.math.BigDecimal;

public record OrderItemDetailResponse(
        Integer quantity,
        BigDecimal totalPrice,
        ItemResponse item
) {
}
