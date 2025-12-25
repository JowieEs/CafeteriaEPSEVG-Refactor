package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ProductDetailResponse extends ItemResponse {
    private final CategoryResponse category;
    private final List<ProductUnitResponse> units;
}