package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProductSummaryResponse extends ItemResponse {
    private final String categoryName;
}
