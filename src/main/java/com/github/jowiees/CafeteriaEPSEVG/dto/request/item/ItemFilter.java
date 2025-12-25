package com.github.jowiees.CafeteriaEPSEVG.dto.request.item;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemFilter {
    private String itemType;
    private String name;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
}
