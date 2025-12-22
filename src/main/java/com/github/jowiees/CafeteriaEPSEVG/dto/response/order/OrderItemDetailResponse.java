package com.github.jowiees.CafeteriaEPSEVG.dto.response.order;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class OrderItemDetailResponse{
    Long itemId;
    String itemType;
    String name;
    Integer quantity;
    BigDecimal selledAt;
    BigDecimal totalPrice;
}
