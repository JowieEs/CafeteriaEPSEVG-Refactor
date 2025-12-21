package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product;

import lombok.Value;

@Value
public class CategoryResponse {
    Long id;
    String name;
    Boolean is_active;
}
