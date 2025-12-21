package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductSummaryResponse;
import lombok.Value;

@Value
public class MenuProductResponse{
    Integer quantity;
    ProductSummaryResponse product;
}
