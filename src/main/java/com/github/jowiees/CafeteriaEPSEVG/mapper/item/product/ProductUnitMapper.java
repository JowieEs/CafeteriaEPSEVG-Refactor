package com.github.jowiees.CafeteriaEPSEVG.mapper.item.product;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.product.ProductUnitResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.Unit;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.product.ProductUnit;
import org.springframework.stereotype.Component;

@Component
public class ProductUnitMapper {

    public ProductUnitResponse toResponse(ProductUnit productUnit) {
        Unit u = productUnit.getUnit();
        return new ProductUnitResponse(
                u.getId(),
                u.getName(),
                u.getStock(),
                productUnit.getQuantity()
        );
    }
}
