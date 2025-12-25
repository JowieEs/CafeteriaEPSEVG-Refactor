package com.github.jowiees.CafeteriaEPSEVG.mapper.item.product;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.product.Product;
import com.github.jowiees.CafeteriaEPSEVG.mapper.unit.UnitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryMapper categoryMapper;
    private final ProductUnitMapper productUnitMapper;

    public ProductSummaryResponse toSummaryResponse(Product product) {
        return ProductSummaryResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sellingPrice(product.getSellingPrice())
                .itemType(product.getItemType())
                .isActive(product.getIsActive())
                .categoryName((product.getCategory() != null) ? product.getCategory().getName() : null)
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
                .units(product.getProductUnits().stream().map(productUnitMapper::toResponse).toList())
                .build();
    }
}
