package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product;

import lombok.Value;

@Value
public class ProductUnitResponse {
    Long id;
    String name;
    Integer stock;
    Integer quantity;
}
