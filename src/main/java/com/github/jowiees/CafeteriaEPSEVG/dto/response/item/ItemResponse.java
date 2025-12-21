package com.github.jowiees.CafeteriaEPSEVG.dto.response.item;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public abstract class ItemResponse {
    private final Long id;
    private final String name;
    private final BigDecimal sellingPrice;
    private final String itemType;
    private final Boolean isActive;
}