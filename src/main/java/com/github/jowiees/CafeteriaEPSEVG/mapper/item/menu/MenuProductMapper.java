package com.github.jowiees.CafeteriaEPSEVG.mapper.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuProductResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.menu.MenuProduct;
import org.springframework.stereotype.Component;

@Component
public class MenuProductMapper {
    public MenuProductResponse toResponse(MenuProduct menuProduct) {
        Long productId = null;
        String productName = null;
        String categoryName = null;

        if (menuProduct.getProduct() != null) {
            productId = menuProduct.getProduct().getId();
            productName = menuProduct.getProduct().getName();

            if (menuProduct.getProduct().getCategory() != null) {
                categoryName = menuProduct.getProduct().getCategory().getName();
            }
        }

        return new MenuProductResponse(
                menuProduct.getQuantity(),
                productId,
                productName,
                categoryName
        );
    }
}
