package com.github.jowiees.CafeteriaEPSEVG.mapper.item.product;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.CategoryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.product.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toDetailResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getIsActive()
        );
    }
}
