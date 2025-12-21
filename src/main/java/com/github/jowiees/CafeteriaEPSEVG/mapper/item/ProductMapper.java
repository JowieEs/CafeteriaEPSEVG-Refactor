package com.github.jowiees.CafeteriaEPSEVG.mapper.item;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductSummaryResponse toSummaryResponse(Product product) {
        return ProductSummaryResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sellingPrice(product.getSellingPrice())
                .itemType(product.getItemType())
                .isActive(product.getIsActive())
                .categoryName(product.getCategory().getName())
                .build();
    }

    public ProductDetailResponse toDetailResponse(Product product) {
        return ProductDetailResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sellingPrice(product.getSellingPrice())
                .itemType(product.getItemType())
                .isActive(product.getIsActive())
                .category(categoryMapper.toDetailResponse(product.getCategory()))
                .build();
    }
}
