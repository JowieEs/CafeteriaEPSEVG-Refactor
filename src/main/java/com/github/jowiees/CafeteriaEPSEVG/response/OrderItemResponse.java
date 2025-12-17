package com.github.jowiees.CafeteriaEPSEVG.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record OrderItemResponse(
        Long id,
        Integer quantity,
        @JsonProperty("item_id") Long itemId,
        @JsonProperty("item_name") String itemName,
        @JsonProperty("selling_price") BigDecimal sellingPrice,
        @JsonProperty("total_price") BigDecimal totalPrice
) {
}
