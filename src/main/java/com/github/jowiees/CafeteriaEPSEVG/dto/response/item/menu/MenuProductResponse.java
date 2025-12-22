package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductSummaryResponse;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class MenuProductResponse{
    Integer quantity;
    Long id;
    String name;
    String categoryName;
}
